package com.benlufuta.hirelog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benlufuta.hirelog.service.ApplicationService;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    
    private final ApplicationService service;

    public ApplicationController (ApplicationService service){

        this.service = service;
    }

    @GetMapping
    public Object getAllApplications(){

        return service.getAllApplications();
    }
}
