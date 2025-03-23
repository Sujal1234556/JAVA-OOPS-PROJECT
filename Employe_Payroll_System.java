import java.util.*;

abstract class Employee {

    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculate_salary();

    @Override
    public String toString() {
        return "Employee [Name = " + name + " , Id = " + id + " , Salary = " + calculate_salary() + " ] ";
    }
}

class FulltimeEmployeee extends Employee {

    private double monthlySalary;

    public FulltimeEmployeee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculate_salary() {
        return monthlySalary;
    }

}

class ParttimeEmployeee extends Employee {

    private int no_hours_worked;
    private double hourly_rate;

    public ParttimeEmployeee(String name, int id, int no_hours_worked, double hourly_rate) {
        super(name, id);
        this.no_hours_worked = no_hours_worked;
        this.hourly_rate = hourly_rate;
    }

    @Override
    public double calculate_salary() {
        return no_hours_worked * hourly_rate;
    }
}

class PayrollSystem {

    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {

        Employee employeToremove = null;

        for (Employee employee : employeeList) {

            if (employee.getId() == id) {
                employeToremove = employee;
                break;
            }
        }
        if (employeToremove != null) {
            employeeList.remove(employeToremove);
        }
    }

    public void dispEmployye() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Employe_Payroll_System {
    public static void main(String[] args) {
        
        PayrollSystem obj = new PayrollSystem();
        FulltimeEmployeee emp1 = new FulltimeEmployeee("Sujal", 1, 30000);
        ParttimeEmployeee emp2 = new ParttimeEmployeee("Jarvis", 2, 10, 100);

        obj.addEmployee(emp1);
        obj.addEmployee(emp2);
        System.out.println("Initial Employee Details ");
        obj.dispEmployye();
        System.out.println("Removing Employee ");
        obj.removeEmployee(1);
        System.out.println("Remaining Employee Details ");
        obj.dispEmployye();
    }
}
