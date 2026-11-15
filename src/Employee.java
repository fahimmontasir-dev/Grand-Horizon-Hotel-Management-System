
public class Employee extends Person {

    private String employeeId;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String phoneNumber,
                    String email, String position, double salary) {

        super(name, phoneNumber, email);

        this.employeeId = employeeId;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void displayDetails() {

        System.out.println("\n===== EMPLOYEE DETAILS =====");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("Position: " + position);
        System.out.println("Salary: €" + salary);
    }
}
