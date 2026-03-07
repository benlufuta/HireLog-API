package com.benlufuta.hirelog.demo;
import java.time.LocalDate;

import com.benlufuta.hirelog.domain.Application;
import com.benlufuta.hirelog.domain.Status;
import com.benlufuta.hirelog.service.ApplicationService;

public class AppRunner {
    public static void main(String[] args) throws Exception {
        

        ApplicationService service = new ApplicationService();
        
        System.out.println("=== ADD APPLICATIONS ===");
        Application app1 = service.addApplication(
                "Google",
                "Software Engineer Intern",
                "https://careers.google.com",
                "Strong backend role"
        );

        Application app2 = service.addApplication(
                "Amazon",
                "SDE Intern",
                "https://amazon.jobs",
                "Need to review OA prep"
        );

        Application app3 = service.addApplication(
                "Microsoft",
                "Explore Intern",
                "https://careers.microsoft.com",
                "Good company culture"
        );

        System.out.println(app1);
        System.out.println(app2);
        System.out.println(app3);

        System.out.println("\n=== GET ALL APPLICATIONS ===");
        for (Application app : service.getAllApplications()) {
            System.out.println(app);
        }

        System.out.println("\n=== FIND BY ID ===");
        Application found = service.findById(2);
        if (found != null) {
            System.out.println("Found application with ID 2:");
            System.out.println(found);
        } else {
            System.out.println("Application with ID 2 not found.");
        }

        System.out.println("\n=== FIND MISSING ID ===");
        Application missing = service.findById(99);
        if (missing == null) {
            System.out.println("Application with ID 99 not found.");
        }

        System.out.println("\n=== FILTER BY STATUS: SAVED ===");
        for (Application app : service.findByStatus(Status.SAVED)) {
            System.out.println(app);
        }

        System.out.println("\n=== MARK AS APPLIED / INTERVIEWING ===");
        app1.markAsApplied();
        app1.setNextFollowUpDate(LocalDate.now().plusDays(7));
        app2.markAsApplied();
        app2.markAsInterviewing();

        System.out.println("Updated app1:");
        System.out.println(app1);
        System.out.println("Updated app2:");
        System.out.println(app2);

        System.out.println("\n=== FILTER BY STATUS: APPLIED ===");
        for (Application app : service.findByStatus(Status.APPLIED)) {
            System.out.println(app);
        }

        System.out.println("\n=== FILTER BY STATUS: INTERVIEWING ===");
        for (Application app : service.findByStatus(Status.INTERVIEWING)) {
            System.out.println(app);
        }

        System.out.println("\n=== INVALID FOLLOW-UP TEST ===");
        try {
            app3.setNextFollowUpDate(LocalDate.now().plusDays(5));
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        System.out.println("\n=== DELETE APPLICATION ===");
        boolean deleted = service.deleteApplication(2);
        System.out.println("Deleted ID 2? " + deleted);

        System.out.println("\n=== DELETE MISSING APPLICATION ===");
        boolean deletedMissing = service.deleteApplication(99);
        System.out.println("Deleted ID 99? " + deletedMissing);

        System.out.println("\n=== FINAL APPLICATION LIST ===");
        for (Application app : service.getAllApplications()) {
            System.out.println(app);
        }
    }
}
