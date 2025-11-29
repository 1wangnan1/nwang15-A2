
import java.util.*;
import java.io.*;

public class Ride implements RideInterface {

    private String rideName;
    private String type;
    private int capacity;
    private Employee operator;

    // collections for queue and history
    private Queue<Visitor> waitingQueue; // for waiting line
    private LinkedList<Visitor> rideHistory; // for ride history

    // PART 5: new instance variables
    private int maxRider;
    private int numOfCycles;

    // default constructor
    public Ride() {
        this.rideName = "unknown ride";
        this.type = "general";
        this.capacity = 10;
        this.operator = null;
        this.waitingQueue = new LinkedList<>(); // initialize queue
        this.rideHistory = new LinkedList<>(); // initialize history
        this.maxRider = 4; // default max riders per cycle
        this.numOfCycles = 0; // start at 0
    }

    // constructor with parameters
    public Ride(String rideName, String type, int capacity, Employee operator) {
        this.rideName = rideName;
        this.type = type;
        this.capacity = capacity;
        this.operator = operator;
        this.waitingQueue = new LinkedList<>(); // initialize queue
        this.rideHistory = new LinkedList<>(); // initialize history
        this.maxRider = 4; // default max riders per cycle
        this.numOfCycles = 0; // start at 0
    }

    // Part5: new constructor with maxRider
    public Ride(String rideName, String type, int capacity, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.type = type;
        this.capacity = capacity;
        this.operator = operator;
        this.maxRider = maxRider;
        this.numOfCycles = 0;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
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
    // PART 5: new getters and setters
    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
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

    // PART 5: runOneCycle implementation
    public void runOneCycle() {
        // check if operator is assigned
        if (operator == null) {
            System.out.println("Error: Cannot run " + rideName + " - no operator assigned");
            return;
        }

        // check if queue is empty
        if (waitingQueue.isEmpty()) {
            System.out.println("Error: Cannot run " + rideName + " - no visitors in queue");
            return;
        }

        System.out.println("\n=== Running " + rideName + " Cycle ===");
        System.out.println("Operator: " + operator.getName());
        System.out.println("Max riders per cycle: " + maxRider);
        System.out.println("Visitors in queue before: " + waitingQueue.size());

        int ridersThisCycle = 0;

        // take visitors from queue and add to history
        for (int i = 0; i < maxRider; i++) {
            if (!waitingQueue.isEmpty()) {
                Visitor rider = waitingQueue.remove();
                rideHistory.add(rider);
                ridersThisCycle++;
                System.out.println(" - " + rider.getName() + " is riding");
            } else {
                break; // no more visitors in queue
            }
        }

        // update cycle count
        numOfCycles++;

        System.out.println("Cycle completed: " + ridersThisCycle + " visitors rode");
        System.out.println("Visitors in queue after: " + waitingQueue.size());
        System.out.println("Total cycles run: " + numOfCycles);
        System.out.println("Success: Ride cycle completed successfully");
    }

    public int getQueueSize() {
        return waitingQueue.size();
    }

        // PART 6: Export ride history to file
    public void exportRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Error: No visitors in ride history to export");
            return;
        }
        
        // Create filename based on ride name
        String filename = rideName.replace(" ", "_") + "_history.csv";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Write header line
            writer.println("Name,Age,ID,TicketType,VIP");
            
            // Write each visitor as a CSV line
            for (Visitor visitor : rideHistory) {
                String line = visitor.getName() + "," +
                             visitor.getAge() + "," +
                             visitor.getId() + "," +
                             visitor.getTicketType() + "," +
                             visitor.getHasVIP();
                writer.println(line);
            }
            
            System.out.println("Success: Exported " + rideHistory.size() + 
                             " visitors to file: " + filename);
            
        } catch (IOException e) {
            System.out.println("Error: Could not write to file " + filename);
            System.out.println("Error message: " + e.getMessage());
        }
    }
    
    // PART 6: Alternative method with custom filename (for testing)
    public void exportRideHistory(String filename) {
        if (rideHistory.isEmpty()) {
            System.out.println("Error: No visitors in ride history to export");
            return;
        }
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Write header line
            writer.println("Name,Age,ID,TicketType,VIP");
            
            // Write each visitor as a CSV line
            for (Visitor visitor : rideHistory) {
                String line = visitor.getName() + "," +
                             visitor.getAge() + "," +
                             visitor.getId() + "," +
                             visitor.getTicketType() + "," +
                             visitor.getHasVIP();
                writer.println(line);
            }
            
            System.out.println("Success: Exported " + rideHistory.size() + 
                             " visitors to file: " + filename);
            
        } catch (IOException e) {
            System.out.println("Error: Could not write to file " + filename);
            System.out.println("Error message: " + e.getMessage());
        }
    }
}
