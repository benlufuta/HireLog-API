package com.benlufuta.hirelog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.benlufuta.hirelog.domain.Application;
import com.benlufuta.hirelog.service.ApplicationService;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    
    private final ApplicationService service;

    public ApplicationController (ApplicationService service){

        this.service = service;
    }

    @GetMapping
    public List<Application> getAllApplications(){

        return service.getAllApplications();
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable ("id") Long id){

        return service.findById(id);
    }
}
