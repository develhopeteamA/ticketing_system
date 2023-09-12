package TicketService;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
public class TicketService {
    private Map<Integer, Ticket> tickets;

    public TicketService() {
        tickets = new HashMap<>();
    }

    public void createTicket(int ticketId, String description, String priorityLevel, Timestamp deadlineDate) {
        Ticket newTicket = new Ticket(ticketId, null, description, priorityLevel, deadlineDate);
        tickets.put(ticketId, newTicket);
    }

    public Ticket readTicket(int ticketId) {
        return tickets.get(ticketId);
    }

    public void updateTicket(int ticketId, String description, String priorityLevel, Timestamp deadlineDate) {
        Ticket ticketToUpdate = tickets.get(ticketId);
        if (ticketToUpdate != null) {
            ticketToUpdate.setDescription(description);
            ticketToUpdate.setPriorityLevel(priorityLevel);
            ticketToUpdate.setDeadlineDate(deadlineDate);
        } else {
            System.out.println("Ticket with ID " + ticketId + " does not exist.");
        }
    }
}

