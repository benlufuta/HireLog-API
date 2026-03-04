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
        this.dateApplied = (this.dateApplied == null) ? LocalDate.now() : this.dateApplied;
        this.updatedAt = LocalDateTime.now();
    }
    
    public void markAsRejected(){
        
        this.status = Status.REJECTED;
        this.nextFollowUpDate = null;
        this.updatedAt = LocalDateTime.now();
    }
    /**
     * Updates the status of this job applcation.
     * 
     */
    public void markAsInterviewing(){
        
        if (this.status == Status.SAVED && dateApplied == null) {
            throw new IllegalArgumentException("Not allowed. Must apply first!");
        }
        this.status = Status.INTERVIEWING;
        this.updatedAt = LocalDateTime.now();
    }

    public void setNextFollowUpDate(LocalDate nextFollowUpDate) {

        if (this.status != Status.APPLIED && this.status != Status.INTERVIEWING && this.dateApplied == null) {

            throw new IllegalArgumentException("You can only follow up if you’re actively in the process");

        }

        if (this.dateApplied.isAfter(nextFollowUpDate)) {
            throw new IllegalArgumentException("Follow Up date has to be after date appliaction was submitted");
        }
        this.nextFollowUpDate = nextFollowUpDate == null ? null : nextFollowUpDate;
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
