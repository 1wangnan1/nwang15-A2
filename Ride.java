// Ride.java
public class Ride {
    private String rideName;
    private String type;
    private int capacity;
    private Employee operator;
    
    // default constructor
    public Ride() {
        this.rideName = "unknown ride";
        this.type = "general";
        this.capacity = 10;
        this.operator = null;
    }
    
    // constructor with parameters
    public Ride(String rideName, String type, int capacity, Employee operator) {
        this.rideName = rideName;
        this.type = type;
        this.capacity = capacity;
        this.operator = operator;
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
}