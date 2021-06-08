package app;

public class Complaint {

    private Long id;
    private String complaintDate;
    private String complaintText;
    private String author;
    private String status;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "entities.Complaint[ id=" + id + " ]";
    }

    public String getComplaintDate() {
        return complaintDate;
    }

    public String getComplaintText() {
        return complaintText;
    }

    public String getAuthor() {
        return author;
    }

    public String getStatus() {
        return status;
    }

    public void setComplaintDate(String complaintDate) {
        this.complaintDate = complaintDate;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void prettyPrint() {
        System.out.println("Complaint");
        System.out.println("  id: " + this.id.toString());
        System.out.println("  complaintDate: " + this.complaintDate);
        System.out.println("  complaintText: " + this.complaintText);
        System.out.println("  author: " + this.author);
        System.out.println("  status: " + this.status);
    }
}
