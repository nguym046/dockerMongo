package com.dsi.party.controller;

import com.dsi.party.exceptions.FaultException;
import com.dsi.party.model.Event;
import com.dsi.party.repository.EventRepository;
import com.dsi.party.utils.MessageKeys;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.dsi.party.service.RestBackend;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ExampleController implements IBaseController {

    private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private RestBackend restBackend;


    @Autowired
    private EventRepository repository;

    // stub
    //
    @RequestMapping("/orders/867504")
    public ResponseEntity<String> orderitem() {
        String dummyOrderItem  = "{\n" +
                "    \"commerceId\": \"5I1b0bbPLttGE1uPW9xXKqTrOYxqJ0Gr4q0B3C75y1TSpSTmpv8RQiA+kHQepgCYYP0t+yXmtUWGt5BqYLr1lrqTOSM4VP90AtKNB2owyr6pKiLthehXl/MXUAoJamlNFOpPByLJa8Y0+ThwOxlDtY5XyyUg/2GuDALbAM4CHDJ7CdaVUnpzHTaio1e2K9VzYAzX/ck6Fl8qesqYDeE6YSXc8sY5JAf680jso9O8wL/LkHRXUx9PcrJB6BmJdxe0+yB6ILTsnzQj7UjiM17RzcDESyPNYrhb7cj02DFr4pf8ywZaDXudL5OFuF4IE1VccQznHrYxNWWniYA6kzeTm6WOvmQ4/QDfVPZVkuvjkqi2HsqWX6K+lHPGqhsStbOB2Pn5Af6MJqAPXa5GSAmG1BCHVOyAsSq2lxpUjiKWQdBp1IUCL5hfhIcdEdwJ9B/vMUlb5uFSWHM4mAlY7J/xJCNHnSCaSvk6nOaliZip0rPCxj42jtuTeZarYYUTClY4ErkjQysLFn38C4zLKRT45C7hcD0lQY4RbWGMyDqu//I5Gj9KDgKKjV7cXHaPf05ZRhRrUP4xP2RzZnG+C84la2R3ZvklNuquqUrgeAe9vBe85M835QuAT473Z6bfrbmlQ/KS3EJB2j++xAo45jVUh0grtzUbPBzZn31NbxOfiPTimBL2VhjKNmQbiOfRbJZ9QtqyqpWZJwv5E6s7narrkY6wpQDBuqGS77VBlXk0KPMmXvWPkkrtJjEay+Dfo/eDKQFusHZEkvVDt0K5vzuorf7qz3uxN+yRZpNV5cpgjet7F/cjWvnRsbUdN3ukE9rGoBPTELNJgj2vggJmuh1xP3KMueFBq0/mSutZHdFzzy2j9+JbF0eGCghGbyjEJp4FLTcKRMjbvmVlquANSmUWJtF4RefFZC2KyRszcoPYKyrVvmxC+rm8ZpRYoiwt2Im1\",\n" +
                "    \"conversationId\": \"534eb672-c20b-4c10-bf3e-35a6f311f21e\",\n" +
                "    \"orders\": [\n" +
                "        {\n" +
                "            \"orderId\": 867504,\n" +
                "            \"addresses\": [\n" +
                "                \n" +
                "            ],\n" +
                "            \"shippingMethod\": {\n" +
                "                \"shipModeId\": 0\n" +
                "            },\n" +
                "            \"paymentMethods\": [\n" +
                "                \n" +
                "            ],\n" +
                "            \"paymentInstruction\": [\n" +
                "                \n" +
                "            ],\n" +
                "            \"orderSummary\": {\n" +
                "                \"discountedSubtotal\": \"0.00\",\n" +
                "                \"orderGrandTotal\": \"0\",\n" +
                "                \"originalSubtotal\": \"0\",\n" +
                "                \"totalEstimatedTax\": \"0\",\n" +
                "                \"totalShippingCost\": \"330.95\",\n" +
                "                \"totalShippingDiscount\": \"-330.95\"\n" +
                "            },\n" +
                "            \"payments\": [\n" +
                "                \n" +
                "            ],\n" +
                "            \"description\": \"ORDER #1\",\n" +
                "            \"status\": \"P\",\n" +
                "            \"sourceCode\": \"DSIWEB\",\n" +
                "            \"lastUpdateDate\": \"2016-10-28T18:37:40Z\",\n" +
                "            \"orderItems\": [\n" +
                "                \n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        return new ResponseEntity<>(dummyOrderItem,HttpStatus.OK);
    }

    //
    //Rest Example
    //
    @RequestMapping(value="/rest/order",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> ordercreate( HttpServletRequest request, HttpServletResponse response, @RequestBody String requestBody) throws Exception  {
        try{
            ResponseEntity<String>responseBody = restBackend.callAPI("ordercreate", HttpMethod.POST, requestBody, request);
            return responseBody;
        } catch (ResourceAccessException re){
            logger.error(re.getMessage());
            throw new FaultException(MessageKeys._ERROR_PROVIDER_HOST_CONNECTIVITY,MessageKeys._ERROR_PROVIDER_HOST_CONNECTIVITY, "Connection error, please contact network admin.");
        } catch(Exception e){
            if (e instanceof FaultException)
                throw (FaultException) e;
            else {
                logger.error(e.getMessage());
                throw new FaultException(MessageKeys._ERROR_GENERIC,MessageKeys._ERROR_GENERIC,e.getMessage());
            }
        }
    }

    //
    //Mongo DB examples
    // create
    @RequestMapping(value="/mongo/event",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> createEvent(HttpServletRequest request, HttpServletResponse response,@RequestBody Event requestBody ) throws Exception  {
         Event s = repository.save(requestBody);
         return new ResponseEntity<String>(objectMapper.writeValueAsString(s),HttpStatus.OK);
    }

    //
    // get
    @RequestMapping(value="/mongo/event/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> getEvent(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) throws Exception  {
        Event event = repository.findOne(id);
        return new ResponseEntity<String>(objectMapper.writeValueAsString(event), HttpStatus.OK);
    }

    //
    // update
    @RequestMapping(value="/mongo/event/{id}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> updateEvent(HttpServletRequest request, HttpServletResponse response, @PathVariable String id, @RequestBody Event requestBody) throws Exception  {
        Event event = repository.findOne(id);
        if (requestBody.eventName!=null)
            event.eventName=requestBody.eventName;
        if (requestBody.attendeesTotal!=null)
            event.attendeesTotal=requestBody.attendeesTotal;
        repository.save(event);
        return new ResponseEntity<String>(objectMapper.writeValueAsString(event), HttpStatus.OK);
    }

    //
    // delete
    @RequestMapping(value="/mongo/event/{id}",method = RequestMethod.DELETE)
    ResponseEntity<String> deleteEvent(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) throws Exception  {
        repository.delete(id);
        return new ResponseEntity<String>("delete success", HttpStatus.OK);
    }

    //
    // findByName
    @RequestMapping(value="/mongo/event",method = RequestMethod.GET,  params= "eventName", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> findEventByName(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "eventName") String eventName ) throws Exception  {
        List<Event> events = repository.findByEventName(eventName);
        if (events!=null)
        return new ResponseEntity<String>(objectMapper.writeValueAsString(events.get(0)), HttpStatus.OK);
        else
            return new ResponseEntity<String>("empty results", HttpStatus.OK);
    }



    @ExceptionHandler(FaultException.class)
    @ResponseBody
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public String handle(FaultException e) throws JsonProcessingException {
        //clearing out stack trace info from SpringBoot.
        StackTraceElement[] st = new StackTraceElement[] {};
        e.setStackTrace(st);
        return objectMapper.writer().writeValueAsString(e);
    }

}
