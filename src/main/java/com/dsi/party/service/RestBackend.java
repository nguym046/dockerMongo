package com.dsi.party.service;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.env.Environment;


@Component
@PropertySource("classpath:rest.properties")
//TODO: This is a poc utilizing rest template and may be removed for disneyParty.
public class RestBackend {
   //private static final Logger logger = LoggerFactory.getLogger(RestBackend.class);

    private RestTemplate restTemplate;

    private static final String[] headerRequestKeys={"conversationId","commerceId","access_token","accept","X-Forwarded-For"};

    @Value("${host.api.uri}")
    private String host;

    @Value("${context.root}")
    private String contextRoot;

    @Value("${partnerId}")
    private String partnerId;

    @Autowired
    Environment restProperties;

    @Autowired
    public RestBackend(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SuppressWarnings("unchecked")
    public ResponseEntity<String> callAPI (String serviceCall, HttpMethod httpMethod, String payLoad, HttpServletRequest request) throws Exception {
        String url = getApiUrl(serviceCall);
        HttpEntity<Object> httpEntity = preApi( httpMethod,  payLoad, request);
        ResponseEntity<String> restResponse = restTemplate.exchange(url, httpMethod, httpEntity, String.class);
        return postApi(restResponse);
    }


    private String getApiUrl(String serviceCall){
        return host+contextRoot+partnerId+restProperties.getProperty(serviceCall);
    }


    HttpEntity<Object> preApi( HttpMethod httpMethod, String payLoad, HttpServletRequest request){
        HttpHeaders extractedHeaders = this.extractIncomingHeaders(request);
        HttpEntity<Object> httpEntity = (HttpEntity<Object>) (((httpMethod == HttpMethod.POST)|| (httpMethod == HttpMethod.PUT))?  new HttpEntity<Object>(payLoad,extractedHeaders) : new HttpEntity<String>(extractedHeaders));
        return httpEntity;
    }

    private HttpHeaders extractIncomingHeaders(HttpServletRequest request){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);

            if (Arrays.asList(headerRequestKeys).contains(key)) {
                headers.set(key, (String)value);
                continue;
            }
            continue;
        };
        return headers;
    }

    public static boolean isError(HttpStatus status) {
        HttpStatus.Series series = status.series();
        return (HttpStatus.Series.CLIENT_ERROR.equals(series)
                || HttpStatus.Series.SERVER_ERROR.equals(series));
    }

    ResponseEntity<String> postApi(ResponseEntity<String> preResponse){
        return new ResponseEntity<String>(preResponse.getBody(), isError(preResponse.getStatusCode())?HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }
}