package TicketService;

import java.sql.Timestamp;
import java.util.List;

public class Ticket {
    private int ticketID;
    private String ticketName;
    private String description;
    private String tags;
    private String priorityLevel;
    private int agentAssigned; // userID
    private List<String> subTasks;
    private String attachments;
    private Timestamp deadlineDate;

    public Ticket(int ticketID, String ticketName, String description, String priorityLevel, Timestamp deadlineDate) {
        this.ticketID = ticketID;
        this.ticketName = ticketName;
        this.description = description;
        this.priorityLevel = priorityLevel;
        this.deadlineDate = deadlineDate;
    }

    // Getters and Setters for all the fields...

    public int getTicketID() {
        return ticketID;
    }

    // Other getters and setters...

    public Timestamp getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Timestamp deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public void setDescription(String description) {
    }

    public void setPriorityLevel(String priorityLevel) {
    }
}