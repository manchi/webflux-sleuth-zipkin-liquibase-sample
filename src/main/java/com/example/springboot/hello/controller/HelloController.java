package com.example.springboot.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("/")
    public String hello() {
        log.info("received get request for hello controller");
        return "Greetings from Spring Boot!";
    }


    @PostMapping("/")
    public String hello(@RequestBody String fullName) {
        log.info("received post request for hello controller");
        String response = "Hello " + fullName;
        log.info("sending response {}", response);
        return response;
    }

}