package cl.luci.poc.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;

/**
 * @author Oreste Luci
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }

    @RequestMapping(
            value = "/json",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseMessage json() {

        ResponseMessage responseMessage = new ResponseMessage("json","Hello World!");

        return responseMessage;
    }

    @RequestMapping(
            value = "/xml",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody ResponseMessage xml() {

        ResponseMessage responseMessage = new ResponseMessage("xml","Hello World!");

        return responseMessage;
    }
}
