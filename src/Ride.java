import java.util.*; 

public class Ride implements RideInterface { 
    private String rideName;
    private String type;
    private int capacity;
    private Employee operator;
    
    // added collections for part 2
    private Queue<Visitor> waitingQueue; // for waiting line
    private LinkedList<Visitor> rideHistory; // for ride history
    
    // default constructor
    public Ride() {
        this.rideName = "unknown ride";
        this.type = "general";
        this.capacity = 10;
        this.operator = null;
        this.waitingQueue = new LinkedList<>(); // initialize queue
        this.rideHistory = new LinkedList<>(); // initialize history
    }
    
    // constructor with parameters
    public Ride(String rideName, String type, int capacity, Employee operator) {
        this.rideName = rideName;
        this.type = type;
        this.capacity = capacity;
        this.operator = operator;
        this.waitingQueue = new LinkedList<>(); // initialize queue
        this.rideHistory = new LinkedList<>(); // initialize history
    }
    
    // getters and setters
    public String getRideName() {
        return rideName;
    }
    
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public Employee getOperator() {
        return operator;
    }
    
    public void setOperator(Employee operator) {
        this.operator = operator;
    }
    
    // Interface methods - will implement properly in next parts
    public void addVisitorToQueue(Visitor visitor) {
        System.out.println("addVisitorToQueue - not implemented yet");
    }
    
    public void removeVisitorFromQueue() {
        System.out.println("removeVisitorFromQueue - not implemented yet");
    }
    
    public void printQueue() {
        System.out.println("printQueue - not implemented yet");
    }
    
    public void addVisitorToHistory(Visitor visitor) {
        System.out.println("addVisitorToHistory - not implemented yet");
    }
    
    public boolean checkVisitorFromHistory(Visitor visitor) {
        System.out.println("checkVisitorFromHistory - not implemented yet");
        return false;
    }
    
    public int numberOfVisitors() {
        System.out.println("numberOfVisitors - not implemented yet");
        return 0;
    }
    
    public void printRideHistory() {
        System.out.println("printRideHistory - not implemented yet");
    }
    
    public void runOneCycle() {
        System.out.println("runOneCycle - not implemented yet");
    }
}