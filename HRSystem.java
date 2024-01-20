interface Employee {
    String getFullName();
    String getJobTitle();
    String getSSN();
}

class FullTimeSalariedEmployee implements Employee {
    private String fullName;
    private String jobTitle;
    private String ssn;

    public FullTimeSalariedEmployee(String fullName, String jobTitle, String ssn) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.ssn = ssn;
    }


    public String getFullName() {
        return fullName;
    }


    public String getJobTitle() {
        return jobTitle;
    }

    public String getSSN() {
        return ssn;
    }
}

class PartTimeSalariedEmployee implements Employee {
    private String fullName;
    private String jobTitle;
    private String ssn;
    private int weeklyHours;

    public PartTimeSalariedEmployee(String fullName, String jobTitle, String ssn, int weeklyHours) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.ssn = ssn;
        this.weeklyHours = weeklyHours;
    }


    public String getFullName() {
        return fullName;
    }


    public String getJobTitle() {
        return jobTitle;
    }


    public String getSSN() {
        return ssn;
    }
}

class ContractorEmployee implements Employee {
    private String fullName;
    private String jobTitle;
    private String ssn;

    public ContractorEmployee(String fullName, String jobTitle, String ssn) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.ssn = ssn;
    }

    public String getFullName() {
        return fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getSSN() {
        return ssn;
    }
}

public class HRSystem {
    private static final int MAX_EMPLOYEES = 100;
    private static Employee[] employees = new Employee[MAX_EMPLOYEES];
    private static int employeeCount = 0;

    public static void addEmployee(Employee employee) {
        if (employeeCount < MAX_EMPLOYEES) {
            employees[employeeCount++] = employee;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Cannot add more employees. Maximum limit reached.");
        }
    }

    public static void deleteEmployee(String ssnToDelete) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getSSN().equals(ssnToDelete)) {
                System.arraycopy(employees, i + 1, employees, i, employeeCount - i - 1);
                employees[--employeeCount] = null;
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void viewEmployeeDetails() {
        if (employeeCount == 0) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee List:");
            for (int i = 0; i < employeeCount; i++) {
                Employee employee = employees[i];
                System.out.println("Name: " + employee.getFullName() + ", Job Title: " + employee.getJobTitle() + ", SSN: " + employee.getSSN());
            }
        }
    }

    public static void main(String[] args) {
        // Sample data
        addEmployee(new FullTimeSalariedEmployee("Jeffrey John", "Software Engineer", "333-22-3333"));
        addEmployee(new PartTimeSalariedEmployee("Charles Smith", "Artist", "123-65-4321", 30));
      

