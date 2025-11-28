public class AssignmentTwo {
    
    public static void main(String[] args) {
        System.out.println("Assignment 2 Start");
        partOne();
        partTwo();
        partThree();
    }
    
    // method to test part 1
    public static void partOne() {
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
    //method to test part 2
    public static void partTwo() {
        System.out.println("\n=== Testing Part 2 ===");
        
        // create objects for testing
        Employee emp1 = new Employee("Mike", 30, "E002", "Operator", 2500.0);
        Ride ride2 = new Ride("Ferris Wheel", "scenic", 15, emp1);
        
        // test that Ride implements the interface
        System.out.println("Ride implements RideInterface: " + (ride2 instanceof RideInterface));
        
        // test interface methods (they will print "not implemented yet")
        Visitor testVisitor = new Visitor("Bob", 18, "V002", "regular", false);
        ride2.addVisitorToQueue(testVisitor);
        ride2.printQueue();
    }

    //method to test part3
    public static void partThree() {
        System.out.println("\n=== Testing Part 3: Queue Operations ===");
        
        // create a new Ride object
        Employee operator = new Employee("Sarah", 28, "E003", "Ride Operator", 2800.0);
        Ride rollerCoaster = new Ride("Thunder Bolt", "roller coaster", 25, operator);
        
        System.out.println("Created ride: " + rollerCoaster.getRideName());
        
        // create at least 5 visitors
        Visitor visitor1 = new Visitor("Tom", 22, "V101", "day pass", false);
        Visitor visitor2 = new Visitor("Emma", 19, "V102", "vip", true);
        Visitor visitor3 = new Visitor("James", 35, "V103", "regular", false);
        Visitor visitor4 = new Visitor("Lisa", 27, "V104", "day pass", false);
        Visitor visitor5 = new Visitor("David", 31, "V105", "vip", true);
        Visitor visitor6 = new Visitor("Sophia", 24, "V106", "regular", false);
        
        // add visitors to queue
        System.out.println("\n--- Adding visitors to queue ---");
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);
        rollerCoaster.addVisitorToQueue(visitor6); // added 6 visitors
        
        // print queue before removal
        System.out.println("\n--- Queue before removal ---");
        rollerCoaster.printQueue();
        
        // remove a visitor from queue
        System.out.println("\n--- Removing one visitor ---");
        rollerCoaster.removeVisitorFromQueue();
        
        // print queue after removal
        System.out.println("\n--- Queue after removal ---");
        rollerCoaster.printQueue();
        
        // test edge cases
        System.out.println("\n--- Testing failed cases ---");
        
        // test adding null visitor
        rollerCoaster.addVisitorToQueue(null);
        
        // test removing from empty queue (create new empty ride)
        Ride emptyRide = new Ride("Empty Ride", "test", 10, operator);
        emptyRide.removeVisitorFromQueue();
        
        // print empty queue
        emptyRide.printQueue();
    }
}