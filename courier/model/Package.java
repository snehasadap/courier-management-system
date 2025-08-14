package courier.model;

public class Package {
    private final int id;
    private int weight;                 
    private String description;
    private String destination;
    private String mailedDate;           
    private String expectedArrival;      
    private String status = "CREATED";

    public Package(int id, int weight, String description, String destination,
                   String mailedDate, String expectedArrival) {
        this.id = id;
        this.weight = weight;
        this.description = description;
        this.destination = destination;
        this.mailedDate = mailedDate;
        this.expectedArrival = expectedArrival;
    }

    public int getId() { return id; }
    public int getWeight() { return weight; }
    public String getDescription() { return description; }
    public String getDestination() { return destination; }
    public String getMailedDate() { return mailedDate; }
    public String getExpectedArrival() { return expectedArrival; }
    public String getStatus() { return status; }

    public void setWeight(int weight) { this.weight = weight; }
    public void setDescription(String description) { this.description = description; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setMailedDate(String mailedDate) { this.mailedDate = mailedDate; }
    public void setExpectedArrival(String expectedArrival) { this.expectedArrival = expectedArrival; }
    public void setStatus(String status) { this.status = status; }
}
