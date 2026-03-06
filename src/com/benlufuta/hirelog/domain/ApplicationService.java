package com.benlufuta.hirelog.domain;

import java.util.ArrayList;
import java.util.List;

public class ApplicationService {

    private List <Application> applications;
    private long nextId;

    public ApplicationService() {
        this.applications = new ArrayList<>();
        this.nextId = 1;
    }

    public Application addApplications(String companyName, String jobTitle, String jobUrl, String notes){

        //Create a new application object when addApplications is called.
        Application app = new Application(companyName, jobTitle, jobUrl, notes);

        //add new object and also assign id number.
        //Manually assigned for now, will be automated when DB is implemented.
        applications.add(app);
        app.assignId(nextId);

        nextId++;

        //return newly created object.
        return app;
    }

    public Application findById(long id) {

        for (Application app : applications) {
            if (id == app.getId()) {
                return app;
            }
        }
        return null;
    }

    public List<Application> getAllApplications(){

        //Return a new list. Safer and protects internal collections.
        return new ArrayList<>(applications);
    }
    
    
}
