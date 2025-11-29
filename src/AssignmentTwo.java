public class AssignmentTwo {
    
    public static void main(String[] args) {
        System.out.println("Assignment 2 Start");
        partOne();
        partTwo();
        partThree();
        partFourA();
        partFourB();
        partFive();
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
        
        // test failededed cases
        System.out.println("\n--- Testing failed cases ---");
        
        // test adding null visitor
        rollerCoaster.addVisitorToQueue(null);
        
        // test removing from empty queue (create new empty ride)
        Ride emptyRide = new Ride("Empty Ride", "test", 10, operator);
        emptyRide.removeVisitorFromQueue();
        
        // print empty queue
        emptyRide.printQueue();
    }

    // PART 4A: Ride history implementation
    public static void partFourA() {
        System.out.println("\n=== Testing Part 4A: Ride History ===");
        
        Employee operator = new Employee("Chris", 32, "E004", "Operator", 2700.0);
        Ride waterRide = new Ride("Splash Mountain", "water ride", 30, operator);
        
        // create 5 visitors
        Visitor visitor1 = new Visitor("Anna", 25, "V201", "regular", false);
        Visitor visitor2 = new Visitor("Ben", 30, "V202", "vip", true);
        Visitor visitor3 = new Visitor("Cathy", 22, "V203", "day pass", false);
        Visitor visitor4 = new Visitor("Dan", 28, "V204", "vip", true);
        Visitor visitor5 = new Visitor("Eva", 35, "V205", "regular", false);
        
        // add visitors to history
        System.out.println("\n--- Adding visitors to history ---");
        waterRide.addVisitorToHistory(visitor1);
        waterRide.addVisitorToHistory(visitor2);
        waterRide.addVisitorToHistory(visitor3);
        waterRide.addVisitorToHistory(visitor4);
        waterRide.addVisitorToHistory(visitor5);
        
        // check if visitor is in history
        System.out.println("\n--- Checking visitor in history ---");
        waterRide.checkVisitorFromHistory(visitor3);
        
        Visitor unknownVisitor = new Visitor("Unknown", 40, "V999", "regular", false);
        waterRide.checkVisitorFromHistory(unknownVisitor);
        
        // print number of visitors
        System.out.println("\n--- Counting visitors ---");
        waterRide.numberOfVisitors();
        
        // print ride history using iterator
        System.out.println("\n--- Printing ride history ---");
        waterRide.printRideHistory();
    }

    // PART 4B: Sorting implementation
    public static void partFourB() {
        System.out.println("\n=== Testing Part 4B: Sorting Ride History ===");
        
        Employee operator = new Employee("Alex", 29, "E005", "Operator", 2600.0);
        Ride coaster = new Ride("Dragon Coaster", "thrill ride", 20, operator);
        
        // create visitors with different VIP status and ages
        Visitor v1 = new Visitor("Young VIP", 18, "V301", "vip", true);
        Visitor v2 = new Visitor("Old Regular", 45, "V302", "regular", false);
        Visitor v3 = new Visitor("Young Regular", 20, "V303", "regular", false);
        Visitor v4 = new Visitor("Old VIP", 40, "V304", "vip", true);
        Visitor v5 = new Visitor("Middle Regular", 30, "V305", "regular", false);
        
        // add to history
        System.out.println("\n--- Adding visitors to history ---");
        coaster.addVisitorToHistory(v1);
        coaster.addVisitorToHistory(v2);
        coaster.addVisitorToHistory(v3);
        coaster.addVisitorToHistory(v4);
        coaster.addVisitorToHistory(v5);
        
        // print before sorting
        System.out.println("\n--- Before sorting ---");
        coaster.printRideHistory();
        
        // sort the history
        System.out.println("\n--- Sorting ride history ---");
        coaster.sortRideHistory();
        
        // print after sorting
        System.out.println("\n--- After sorting ---");
        coaster.printRideHistory();
    }
     // PART 5: Run one cycle implementation
    public static void partFive() {
        System.out.println("\n=== Testing Part 5: Run Ride Cycle ===");
        
        // create ride with operator and maxRider = 3
        Employee operator = new Employee("Sam", 26, "E006", "Ride Operator", 2900.0);
        Ride rollerCoaster = new Ride("Lightning Coaster", "thrill", 15, operator, 3);
        
        System.out.println("Created ride: " + rollerCoaster.getRideName());
        System.out.println("Max riders per cycle: " + rollerCoaster.getMaxRider());
        
        // create 10 visitors
        System.out.println("\n--- Adding 10 visitors to queue ---");
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor("Visitor" + i, 20 + i, "V" + (400 + i), "regular", i % 3 == 0);
            rollerCoaster.addVisitorToQueue(visitor);
        }
        
        // print queue before running cycle
        System.out.println("\n--- Queue before running cycle ---");
        rollerCoaster.printQueue();
        
        // run one cycle
        System.out.println("\n--- Running one cycle ---");
        rollerCoaster.runOneCycle();
        
        // print queue after running cycle
        System.out.println("\n--- Queue after running cycle ---");
        rollerCoaster.printQueue();
        
        // print ride history
        System.out.println("\n--- Ride history after cycle ---");
        rollerCoaster.printRideHistory();
        
        // test failed cases
        System.out.println("\n--- Testing failed cases ---");
        
        // test ride without operator
        Ride noOperatorRide = new Ride("Broken Ride", "test", 10, null, 2);
        noOperatorRide.runOneCycle();
        
        // test ride with empty queue
        Ride emptyRide = new Ride("Empty Ride", "test", 5, operator, 2);
        emptyRide.runOneCycle();
        
        // run another cycle on original ride
        System.out.println("\n--- Running second cycle ---");
        rollerCoaster.runOneCycle();
        System.out.println("Total cycles run: " + rollerCoaster.getNumOfCycles());
    }
}