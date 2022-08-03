package com.tvc95.rest.ws.restfulwebservices.controllers;

import com.tvc95.rest.ws.restfulwebservices.beans.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// This annotation tells Spring that this class is a Rest Controller
@RestController
public class HelloWorldController {

    /**
     * Type of method: GET
     * URI: /hello-world
     * Returns a string containing "Hello World"
     *
     * OBS.: you can use @GetMapping as well
     */
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }
}
