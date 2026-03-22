package com.benlufuta.hirelog.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    String companyName = "Google";
    String jobTitle = "SWE Intern";
    String website = "google.com";
    String description = "Very big and influential company with a lot of opportunities.";
    Application application;

    @BeforeEach
    void setUp() {
        application = new Application(companyName, jobTitle, website, description);
    }

    @Test
    void constructor_shouldThrowWhenCompanyNameIsNull(){

        assertThrows(IllegalArgumentException.class, () -> new Application(null, jobTitle, website, description));
    }

    @Test
    void constructor_shouldThrowWhenCompanyNameIsBlank(){

        assertThrows(IllegalArgumentException.class, () -> new Application(" ", jobTitle, website, description));
    }

    @Test
    void constructor_shouldThrowWhenCompanyNameIsEmpty(){

        assertThrows(IllegalArgumentException.class, () -> new Application("", jobTitle, website, description));
    }

    @Test
    void constructor_shouldThrowWhenJobTitleIsNull(){

        assertThrows(IllegalArgumentException.class, () -> new Application(companyName, null,website, description));
    }

    @Test
    void constructor_shouldThrowWhenJobTitleIsEmpty(){

        assertThrows(IllegalArgumentException.class, () -> new Application(companyName, "",website, description));
    }

    @Test
    void constructor_shouldThrowWhenJobTitleIsBlank(){

        assertThrows(IllegalArgumentException.class, () -> new Application(companyName, " ",website, description));
    }

    @Test
    void assignId_shouldThrowWhenIdIsNull() {

        assertThrows(IllegalArgumentException.class, () -> application.assignId(null));
    }

    @Test
    void assignId_shouldThrowWhenIdIsInvalid() {

        Long invalidId = -9999L;

        assertThrows(IllegalArgumentException.class, () -> application.assignId(invalidId));
    }

    @Test
    void assignId_shouldThrowWhenIdIsAlreadyAssigned() {

        application.assignId(1L);

        assertThrows(IllegalArgumentException.class, () -> application.assignId(2L));
    }

    @Test
    void markAsApplied_shouldSetStatusToApplied() {
        
        //Check status state prior to updating it.
        assertEquals(Status.SAVED, application.getStatus());

        //Update status state and then check again.
        application.markAsApplied();
        assertEquals(Status.APPLIED, application.getStatus());
    }

    @Test
    void markAsApplied_shouldSetDateApplied(){

        LocalDate todayDate = LocalDate.now();

        application.markAsApplied();
        assertEquals(todayDate, application.getDateApplied());
    }

    @Test
    void markAsInterviewing_shouldThrowWhenNotApplied () {
        
        assertEquals(Status.SAVED, application.getStatus());

        assertThrows(IllegalArgumentException.class, () -> application.markAsInterviewing());

    }

    @Test
    void markAsInterviewing_shouldSetStatusWhenApplied() {

        application.markAsApplied();

        assertEquals(Status.APPLIED, application.getStatus());

        application.markAsInterviewing();

        assertEquals(Status.INTERVIEWING, application.getStatus());
    }

    @Test
    void markAsRejected_shouldClearFollowUpDate(){

        //Set status to interviewing and set follow-up date.
        application.markAsApplied();
        application.markAsInterviewing();

        //Create a followup date.
        LocalDate followUp = LocalDate.now().plusDays(7);

        application.setNextFollowUpDate(followUp);

        assertEquals(Status.INTERVIEWING, application.getStatus());

        //Then mark as rejected and check that follow-up date is removed.
        application.markAsRejected();
        assertNull(application.getNextFollowUpDate());

    }

    @Test
    void markAsRejected_shouldUpdateStatus(){

        //First, make sure status is not null.
        application.markAsApplied();
        assertEquals(Status.APPLIED, application.getStatus());

        //Then, mark as rejected and check that status actually changed.
        application.markAsRejected();
        assertEquals(Status.REJECTED, application.getStatus());

    }
    
}
