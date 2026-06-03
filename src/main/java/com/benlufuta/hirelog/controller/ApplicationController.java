package com.benlufuta.hirelog.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Application>> getAllApplications(){

        return ResponseEntity.ok(service.getAllApplications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {

        Application application = service.findById(id);
    
        if (application == null) {
            return ResponseEntity.notFound().build();  // 404, no body
        }
        
        return ResponseEntity.ok(application);  // Code 200 + JSON body

        //return repository.findById(id)
           // .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + id));
    }
} 
