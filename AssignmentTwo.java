// AssignmentTwo.java
public class AssignmentTwo {
    
    public static void main(String[] args) {
        System.out.println("Assignment 2 Start");
        
        // test the classes we made
        testPart1();
    }
    
    // method to test part 1
    public static void testPart1() {
        System.out.println("Testing Part 1:");
        
        // create an employee
        Employee emp1 = new Employee("John", 25, "E001", "Ride Operator", 3000.0);
        System.out.println("Employee created: " + emp1.getName());
        
        // create a visitor
        Visitor vis1 = new Visitor("Alice", 20, "V001", "day pass", true);
        System.out.println("Visitor created: " + vis1.getName());
        
        // create a ride with employee
        Ride ride1 = new Ride("Roller Coaster", "thrill", 20, emp1);
        System.out.println("Ride created: " + ride1.getRideName());
        
        // test setters
        vis1.setTicketType("season pass");
        System.out.println("Visitor ticket changed to: " + vis1.getTicketType());
        
        // test getters
        System.out.println("Ride capacity: " + ride1.getCapacity());
        System.out.println("Ride operator: " + ride1.getOperator().getName());
    }
    
    // other parts will go here later
    public void partThree() {}
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}