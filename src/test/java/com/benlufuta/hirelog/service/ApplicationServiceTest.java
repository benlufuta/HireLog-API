package com.benlufuta.hirelog.service;
import com.benlufuta.hirelog.domain.Application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ApplicationServiceTest {

    String companyName = "Google";
    String jobTitle = "SWE Intern";
    String website = "google.com";
    String description = "Very big and influential company with a lot of opportunities.";

    ApplicationService service = new ApplicationService();

    @Test
    void addApplication_shouldCreateAndStoreApplication() {
        
        Application app = service.addApplication(companyName, jobTitle, website, description);

        //Object Creation check
        assertNotNull(app);
        //ID generation check
        assertEquals(1, app.getId());
        //Retrieval check
        assertEquals(app, service.findById(app.getId()));
        //Storage Check
        assertEquals(1, service.getAllApplications().size());
        //Data Integrity Check
        assertEquals(companyName, app.getCompanyName());

    }

    @Test
    void findById_shouldReturnNullWhenNotFound() {

        long nonExistingId = 99999;

        Application result = service.findById(nonExistingId);

        assertNull(result);
    }

    @Test
    void deleteApplication_shouldRemoveApplication(){
        
        Application app = service.addApplication(companyName, jobTitle, website, description);
        //Return true if successfully deleted.
        assertTrue(service.deleteApplication(app.getId()));
    }

    @Test
    void deleteApplication_shouldReturnFalseWhenNotFound(){

        Application app = service.addApplication(companyName, jobTitle, website, description);
        service.deleteApplication(app.getId());
        //Return false if not found.
        assertFalse(service.deleteApplication(app.getId()));

    }

    @Test
    void testFindByStatus() {
        fail("This test method is yet to be implemented!");
    }

    @Test
    void testGetAllApplications() {
        fail("This test method is yet to be implemented!");
    }
}
