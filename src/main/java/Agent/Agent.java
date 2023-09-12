package Agent;

public class Agent extends User {

    private int agentId;
    private int numberOfTickets;
    private int resolvedTicketCount;
    private int assignedTicketId;


    public Agent(int agentId, int userId, String firstName, String surname, String password,
                 int departmentId, int roleId, String expertise, int numberOfTickets) {
        super();
        this.agentId = agentId;
        this.numberOfTickets = numberOfTickets;
        this.resolvedTicketCount = 0;
    }


    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }


    public void assignTicket(int ticketId) {
        this.assignedTicketId = ticketId;
    }

    public void reassignTicket() {
        this.assignedTicketId = 0;
    }

    public void incrementResolvedTicketCount() {
        resolvedTicketCount++;
    }

    @Override
    public String toString() {
        String assignedTicketInfo = (assignedTicketId != 0) ? String.valueOf(assignedTicketId) : "Not assigned to any ticket";
        String s = super.toString() +
                "\nAgent ID: " + agentId +
                "\nNumber of Tickets Assigned: " + numberOfTickets +
                "\nNumber of Tickets Resolved: " + resolvedTicketCount +
                "\nAssigned Ticket ID: " + assignedTicketInfo;
        return s;
    }
}