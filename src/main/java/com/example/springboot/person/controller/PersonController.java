package com.example.springboot.person.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.person.model.Person;

@RestController
public class PersonController {

    @PostMapping("v1/person")
    public Person person(@RequestBody Person person) {
        System.out.println("Person: " + person);
        return person;
    }

    @PostMapping("v2/person")
    public Person personV2(@RequestBody Person person) {
        System.out.println("V2 person:" + person);
        return person;
    }

}
