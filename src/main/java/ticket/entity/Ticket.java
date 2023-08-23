package ticket.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int ticketID;

    @Column(name = "ticket_name")
    private String ticketName;

    @Column(name = "description")
    private String description;

    @Column(name = "tags")
    private String tags;

    @Column(name = "priorityLevel")
    private String priorityLevel;

//    @ManyToOne(targetEntity = User.class)
//    @JoinColumn(name = "user_id")
    @Column(name = "user_id")
    private int agentAssigned;

    @Column(name = "subTasks")
    private List<String> subTasks;

    @Column(name = "attachments")
    private String attachments;

    @Column(name = "tags")
    private Timestamp deadlineDate;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "created_by")
    private Timestamp createdBy;

    @Column(name="updated_by")
    private Integer updatedBy;

    @Column(name="updated_on")
    private Timestamp updatedOn;

    public Ticket(){

    }

    public Ticket(int ticketID, String ticketName, String description, String priorityLevel, Timestamp deadlineDate){
        this.ticketID = ticketID;
        this.ticketName = ticketName;
        this.description = description;
        this.priorityLevel = priorityLevel;
        this.deadlineDate = deadlineDate;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public int getAgentAssigned() {
        return agentAssigned;
    }

    public void setAgentAssigned(int agentAssigned) {
        this.agentAssigned = agentAssigned;
    }

    public List<String> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<String> subTasks) {
        this.subTasks = subTasks;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public Timestamp getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Timestamp deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Timestamp createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", ticketName='" + ticketName + '\'' +
                ", description='" + description + '\'' +
                ", tags='" + tags + '\'' +
                ", priorityLevel='" + priorityLevel + '\'' +
                ", agentAssigned=" + agentAssigned +
                ", subTasks=" + subTasks +
                ", attachments='" + attachments + '\'' +
                ", deadlineDate=" + deadlineDate +
                ", createdOn=" + createdOn +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
