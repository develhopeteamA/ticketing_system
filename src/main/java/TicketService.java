
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class TicketService {
    // Data structure to store tickets (Replace this with your actual data storage or database)
    private Map<Integer, Ticket> tickets;

    public TicketService() {
        // Initialize the data structure for storing tickets (e.g., HashMap)
        tickets = new HashMap<>();
    }

    // Method to create a ticket and add it to the ticket data structure
    public void createTicket(int ticketId, String description, String tags, String priorityLevel,
                             String agentAssigned, String subtasks, String attachments, Timestamp deadlineDate) {
        Ticket newTicket = new Ticket(ticketId, description, tags, priorityLevel, agentAssigned,
                subtasks, attachments, deadlineDate);
        tickets.put(ticketId, newTicket);
    }

    // Method to read and return a ticket by its ticket ID
    public Ticket readTicket(int ticketId) {
        return tickets.get(ticketId);
    }

    // Method to update a ticket by its ticket ID
    public void updateTicket(int ticketId, String description, String tags, String priorityLevel,
                             String agentAssigned, String subtasks, String attachments, String deadlineDate) {
        Ticket ticketToUpdate = tickets.get(ticketId);
        if (ticketToUpdate != null) {
            // Update the ticket properties
            ticketToUpdate.setDescription(description);
            ticketToUpdate.setTags(tags);
            ticketToUpdate.setPriorityLevel(priorityLevel);
            ticketToUpdate.setAgentAssigned(agentAssigned);
            ticketToUpdate.setSubtasks(subtasks);
            ticketToUpdate.setAttachments(attachments);
            ticketToUpdate.setDeadlineDate(deadlineDate);
        } else {
            System.out.println("Ticket with ID " + ticketId + " does not exist.");
        }
    }
}