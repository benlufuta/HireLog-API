import java.time.LocalDate;
import java.time.LocalDateTime;

public class Application {

    //Fields
    private Long id;
    private final String companyName;
    private final String roleTitle;
    private Status status;
    private String location;
    private final LocalDate dateApplied;
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
            throw new IllegalArgumentException("Role Title is required");
        }
        this.roleTitle = roleTitle;
        this.status = Status.SAVED;
        this.location = null;
        this.dateApplied = LocalDate.now();
        this.jobUrl = jobUrl;
        this.nextFollowUpDate = null;
        this.notes = notes;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }   

}
