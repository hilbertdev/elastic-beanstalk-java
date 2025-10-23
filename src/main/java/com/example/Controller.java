package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String index() {
        return "Hello Elastic Beanstalk!";
    }
   @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("EnrollStudent")
    public String EnrollStudent() {
        return "User Added Successfully";
    }

}