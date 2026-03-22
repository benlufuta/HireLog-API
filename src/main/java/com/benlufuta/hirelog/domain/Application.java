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

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void assignId(Long id) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }

        if (this.id != null) {
            throw new IllegalArgumentException("Application ID has already been assigned");
        }
        this.id = id;

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
        
        //If status is already INTERVIEWING, then don't do anything.
        if (this.status == Status.INTERVIEWING) return;

        if (this.status != Status.APPLIED) {
            throw new IllegalArgumentException("No interview prior to application. Must apply first!");
        }

        this.status = Status.INTERVIEWING;
        this.updatedAt = LocalDateTime.now();
    }

    public void setNextFollowUpDate(LocalDate nextFollowUpDate) {

        if (nextFollowUpDate == null) {
            this.nextFollowUpDate = null;
            this.updatedAt = LocalDateTime.now();
            return;
        }
        if(this.status == null || this.dateApplied == null) {
            throw new IllegalArgumentException("Follow-up allowed only for APPLIED or INTERVIEWING status");
        }
        if (this.status != Status.APPLIED && this.status != Status.INTERVIEWING) {
            throw new IllegalArgumentException("Follow-up allowed only for APPLIED or INTERVIEWING status");
        }

        if (this.dateApplied.isAfter(nextFollowUpDate)) {
            throw new IllegalArgumentException("Follow-up allowed only for APPLIED or INTERVIEWING status");
        }
        this.nextFollowUpDate = nextFollowUpDate;
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

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", roleTitle='" + roleTitle + '\'' +
                ", status=" + status +
                ", dateApplied=" + dateApplied +
                ", nextFollowUpDate=" + nextFollowUpDate +
                ", notes='" + notes + '\'' +
                '}';
    }
}