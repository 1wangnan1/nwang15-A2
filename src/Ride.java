import java.util.*; 

public class Ride implements RideInterface { 
    private String rideName;
    private String type;
    private int capacity;
    private Employee operator;
    
    // collections for queue and history
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
    
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingQueue.add(visitor);
            System.out.println("Success: " + visitor.getName() + " added to queue for " + rideName);
        } else {
            System.out.println("Error: Cannot add null visitor to queue");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            Visitor removed = waitingQueue.remove();
            System.out.println("Success: " + removed.getName() + " removed from queue");
        } else {
            System.out.println("Error: Queue is empty, cannot remove visitor");
        }
    }
    
    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue for " + rideName + " is empty");
        } else {
            System.out.println("=== Waiting Queue for " + rideName + " ===");
            int position = 1;
            for (Visitor visitor : waitingQueue) {
                System.out.println(position + ". " + visitor.toString());
                position++;
            }
            System.out.println("Total visitors in queue: " + waitingQueue.size());
        }
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