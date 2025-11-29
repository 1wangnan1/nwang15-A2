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
    
    // PART 4A: Ride history method
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("Success: " + visitor.getName() + " added to ride history");
        } else {
            System.out.println("Error: Cannot add null visitor to history");
        }
    }

    // PART 4A: Ride history method
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Cannot check null visitor");
            return false;
        }
        
        boolean found = rideHistory.contains(visitor);
        if (found) {
            System.out.println("Success: " + visitor.getName() + " found in ride history");
        } else {
            System.out.println("Info: " + visitor.getName() + " not found in ride history");
        }
        return found;
    }

    // PART 4A: Ride history method
    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Number of visitors in history: " + count);
        return count;
    }

    // PART 4A: Ride history method
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history for " + rideName + " is empty");
        } else {
            System.out.println("=== Ride History for " + rideName + " ===");
            Iterator<Visitor> iterator = rideHistory.iterator();
            int count = 1;
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println(count + ". " + visitor.toString());
                count++;
            }
            System.out.println("Total visitors in history: " + rideHistory.size());
        }
    }

    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Info: No visitors in history to sort");
            return;
        }
        
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Success: Ride history sorted by VIP status and age");
    }

    public void runOneCycle() {
        System.out.println("runOneCycle - not implemented yet");
    }
}