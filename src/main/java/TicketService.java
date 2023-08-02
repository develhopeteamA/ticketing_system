import ticket.Ticket;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketService {
    private Map<Integer, ticket.Ticket> tickets;

    public TicketService() {
        tickets = new HashMap<>();
    }

    public void createTicket(int ticketId, String description,ticket.Ticket.PriorityLevel priorityLevel, Timestamp deadlineDate) {
        ticket.Ticket newTicket = new ticket.Ticket(ticketId, description, priorityLevel, deadlineDate);
        tickets.put(ticketId, newTicket);
    }

    public Ticket readTicket(int ticketId) {
        return tickets.get(ticketId);
    }

    public void updateTicket(int ticketId, String description,
                             Ticket.PriorityLevel priorityLevel,Timestamp deadlineDate) {
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
