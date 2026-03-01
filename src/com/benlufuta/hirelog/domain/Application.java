package com.benlufuta.hirelog.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Application {

    //Fields
    private Long id;
    private final String companyName;
    private final String roleTitle;
    private Status status;
    private String location;
    private LocalDate dateApplied;
    private String jobUrl;
    private LocalDate nextFollowUpDate;
    private String notes;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Application(String companyName, String roleTitle, String jobUrl, String notes) {
        
        if (companyName == null || companyName.isBlank()) {
            throw new IllegalArgumentException("Company name is required");
        }
        this.companyName = companyName;

        if (roleTitle == null || roleTitle.isBlank()) {
            throw new IllegalArgumentException("Role title is required");
        }
        this.roleTitle = roleTitle;
        this.status = Status.SAVED;
        this.dateApplied = null;
        this.jobUrl = jobUrl;
        this.notes = notes;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void markAsApplied(){

        this.status = Status.APPLIED;
        this.dateApplied = LocalDate.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    public void markAsRejected(){
        
        this.status = Status.REJECTED;
        this.updatedAt = LocalDateTime.now();
    }

    public void markAsInterviewing(){
        
        this.status = Status.INTERVIEWING;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * Updates notes of this job application.
     * 
     * @param notes the new notes from user.
     */
    public void updateNotes(String notes){
        
        this.notes = notes;
        this.updatedAt = LocalDateTime.now();
    }
}
