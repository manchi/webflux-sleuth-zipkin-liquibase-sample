package com.example.springboot.person.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.ToString;

@Data
@JsonSerialize
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    private String firstName;
    private String lastName;
    private String middleName;

    // new addition for v2 client
    private String city;

}