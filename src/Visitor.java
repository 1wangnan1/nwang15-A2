public class Visitor extends Person {
    private String ticketType;
    private boolean hasVIP;
    
    // default constructor
    public Visitor() {
        super();
        this.ticketType = "regular";
        this.hasVIP = false;
    }
    
    // constructor with parameters
    public Visitor(String name, int age, String id, String ticketType, boolean hasVIP) {
        super(name, age, id);
        this.ticketType = ticketType;
        this.hasVIP = hasVIP;
    }
    
    // getters and setters
    public String getTicketType() {
        return ticketType;
    }
    
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    
    public boolean getHasVIP() {
        return hasVIP;
    }
    
    public void setHasVIP(boolean hasVIP) {
        this.hasVIP = hasVIP;
    }

    public String toString() {
        String vipStatus = hasVIP ? "VIP" : "Regular";
        return "Visitor: " + getName() + " (ID: " + getId() + ", Age: " + getAge() + 
               ", Ticket: " + ticketType + ", " + vipStatus + ")";
    }
}