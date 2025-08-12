package courier.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Package {
    private final int id;
    private int weight;
    private String description;
    private String destination;
    private String mailedDate;
    private String expectedArrival;
    private String status;
    private final List<String> history = new ArrayList<>();

    public Package(int id, int weight, String description, String destination,
                   String mailedDate, String expectedArrival) {
        this.id = id;
        this.weight = weight;
        this.description = description;
        this.destination = destination;
        this.mailedDate = mailedDate;
        this.expectedArrival = expectedArrival;
        this.status = "Packed";
        appendHistory("Created");
    }

    private void appendHistory(String event) {
        history.add(LocalDateTime.now() + " - " + event);
    }

    public int getId() { return id; }
    public int getWeight() { return weight; }
    public String getDescription() { return description; }
    public String getDestination() { return destination; }
    public String getMailedDate() { return mailedDate; }
    public String getExpectedArrival() { return expectedArrival; }
    public String getStatus() { return status; }
    public List<String> getHistory() { return new ArrayList<>(history); }

    public void setExpectedArrival(String expectedArrival) {
        this.expectedArrival = expectedArrival;
        appendHistory("Expected arrival updated to " + expectedArrival);
    }

    public void setStatus(String status) {
        this.status = status;
        appendHistory("Status set to " + status);
    }
}
