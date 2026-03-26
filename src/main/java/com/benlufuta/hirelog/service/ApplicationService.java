package com.benlufuta.hirelog.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.benlufuta.hirelog.domain.Application;
import com.benlufuta.hirelog.domain.Status;

import java.util.Iterator;

@Service
public class ApplicationService {

    private List <Application> applications;
    private long nextId;

    public ApplicationService() {
        this.applications = new ArrayList<>();
        this.nextId = 1;

        //Line 25 to 37 are just for manually testing, as we do not have the database yet.
        addApplication("Google", "SWE Intern", "google.com", "Strong Backend Role");
        applications.get(0).markAsApplied();
        applications.get(0).setNextFollowUpDate(LocalDate.now().plusDays(7));

        addApplication("Amazon", "SDE 1", "amazon.com", "Prepare for Technical Interview.");
        applications.get(1).markAsApplied();
        applications.get(1).markAsInterviewing();
        applications.get(1).setNextFollowUpDate(LocalDate.now().plusDays(15));

        addApplication("Netflix","Backend Engineer Intern", "netflix.com","Focus on distributed systems"
    );
        applications.get(2).markAsApplied();
        applications.get(2).setNextFollowUpDate(LocalDate.now().plusDays(5));
    }

    public Application addApplication(String companyName, String jobTitle, String jobUrl, String notes){

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
    
    public boolean deleteApplication(long applicationId){

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
