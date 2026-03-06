package com.benlufuta.hirelog.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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

        //If nothing found, then return null.
        return null;
    }

    public List<Application> findByStatus(Status status){

        if (status == null) {
            throw new IllegalArgumentException("Status can't be null");
        }
        List <Application> filteredApplications = new ArrayList<>();

        for (Application app: applications){

            if (app.getStatus() == status){
                filteredApplications.add(app);
            }
        }
        return filteredApplications;
    }

    public List<Application> getAllApplications(){

        //Return a new list instead of return internal list.
        //This protects internal list from external modification.
        return new ArrayList<>(applications);
    }
    
    public boolean deleteApplicaton(long applicationId){

        // Iterator allows safe removal while iterating over the list
        Iterator<Application> iterator = applications.iterator();

        while (iterator.hasNext()) {

            Application app = iterator.next();

            //If found, remove and return true otherwise false
            if (app.getId() == applicationId) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }
}
