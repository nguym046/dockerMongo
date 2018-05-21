package com.dsi.party.exceptions;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dsi.party.service.RestBackend;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.google.gson.Gson;


public class PartyErrorHandler implements ResponseErrorHandler {

    protected Gson gson = new Gson();

    private static final Logger logger = LoggerFactory.getLogger(PartyErrorHandler.class);

    @Override
    public void handleError(ClientHttpResponse response) throws IOException, FaultException {
        String errorAsJSON = null;

        errorAsJSON = readErrorAsJsonString(response.getBody(),500);


        try{

            FaultException faultE = gson.fromJson(errorAsJSON, FaultException.class);
            throw faultE;

        }
        catch(Exception e){
            if ( e instanceof FaultException )
                throw e;

        }
    }

    public static String readErrorAsJsonString(final InputStream is, final int bufferSize)
    {
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        try {
            final Reader in = new InputStreamReader(is, "UTF-8");
            try {
                for (;;) {
                    int rsz = in.read(buffer, 0, buffer.length);
                    if (rsz < 0)
                        break;
                    out.append(buffer, 0, rsz);
                }
            }
            finally {
                in.close();
            }
        }
        catch (UnsupportedEncodingException ex) {
            // ...
        }
        catch (IOException ex) {
            //  ...
        }
        return out.toString();
    }


    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return RestBackend.isError(response.getStatusCode());
    }

}
