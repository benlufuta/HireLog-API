package com.benlufuta.hirelog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    
    @GetMapping("/hello")
    public String hello(){

        return "HireLog API is running!";
        
    }
}
