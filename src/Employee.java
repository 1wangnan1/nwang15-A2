// Employee.java
public class Employee extends Person {
    private String jobTitle;
    private double salary;
    
    // default constructor
    public Employee() {
        super();
        this.jobTitle = "staff";
        this.salary = 0.0;
    }
    
    // constructor with parameters
    public Employee(String name, int age, String id, String jobTitle, double salary) {
        super(name, age, id);
        this.jobTitle = jobTitle;
        this.salary = salary;
    }
    
    // getters and setters
    public String getJobTitle() {
        return jobTitle;
    }
    
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
}