package com.benlufuta.hirelog.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

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

        assertThrows(IllegalArgumentException.class, () -> application.assignId(1L));
    }

    @Test
    void testMarkAsApplied() {
        fail("This test method is yet to be implemented!");
    }

    @Test
    void testMarkAsInterviewing() {
        fail("This test method is yet to be implemented!");
    }

    @Test
    void testMarkAsRejected() {
        fail("This test method is yet to be implemented!");
    }

    @Test
    void testSetNextFollowUpDate() {
        fail("This test method is yet to be implemented!");
    }
    
}
