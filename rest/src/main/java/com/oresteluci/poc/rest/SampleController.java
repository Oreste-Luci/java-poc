package com.oresteluci.poc.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This controller has three endpoints:
 *
 * - /json: returns only json objects.
 * - /xml: returns only xml objects.
 * - /: returns either json or xml depending on the Accept header.
 *
 * @author Oreste Luci
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseMessage get() {

        ResponseMessage responseMessage = new ResponseMessage("rest-example","Hello World!");

        return responseMessage;
    }

    @RequestMapping(
            value = "/json",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseMessage json() {

        ResponseMessage responseMessage = new ResponseMessage("json-example","Hello World JSON!");

        return responseMessage;
    }

    @RequestMapping(
            value = "/xml",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseMessage xml() {

        ResponseMessage responseMessage = new ResponseMessage("xml-example","Hello World XML!");

        return responseMessage;
    }
}
