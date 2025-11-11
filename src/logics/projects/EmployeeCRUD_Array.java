package logics.projects;

import java.util.InputMismatchException;
import java.util.Scanner;

class Employee {
    int empId;
    String empName;
    double salary;

    public Employee(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void display() {
        System.out.println(empId + "\t" + empName + "\t" + salary);
    }
}

class EmployeeService {
    private Employee[] employees = new Employee[100];
    private int count = 0;

    // Method Overloading (Polymorphism)
    public void addEmployee(int id, String name, double salary) {
        if (count < employees.length) {
            employees[count++] = new Employee(id, name, salary);
            System.out.println(" Employee added successfully!");
        } else {
            System.out.println(" Employee list is full!");
        }
    }

    public void addEmployee(int id, String name) {
        addEmployee(id, name, 0.0);
    }

    public void viewEmployees() {
        if (count == 0) {
            System.out.println(" No employees found!");
            return;
        }
        System.out.println("\nID\tName\tSalary");
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    public void updateEmployee(int id, String newName, double newSalary) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmpId() == id) {
                employees[i].setEmpName(newName);
                employees[i].setSalary(newSalary);
                System.out.println(" Employee updated successfully!");
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println(" Employee not found!");
    }

    public void deleteEmployee(int id) {
        boolean deleted = false;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmpId() == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null;
                count--;
                System.out.println("🗑️ Employee deleted successfully!");
                deleted = true;
                break;
            }
        }
        if (!deleted)
            System.out.println(" Employee not found!");
    }
}


public class EmployeeCRUD_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        while (true) {
            System.out.println("\n===== Employee CRUD Menu =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Employee Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double sal = sc.nextDouble();
                        service.addEmployee(id, name, sal);
                        break;

                    case 2:
                        service.viewEmployees();
                        break;

                    case 3:
                        System.out.print("Enter Employee ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new salary: ");
                        double newSal = sc.nextDouble();
                        service.updateEmployee(uid, newName, newSal);
                        break;

                    case 4:
                        System.out.print("Enter Employee ID to delete: ");
                        int did = sc.nextInt();
                        service.deleteEmployee(did);
                        break;

                    case 5:
                        System.out.println(" Exiting program...");
                        System.exit(0);

                    default:
                        System.out.println(" Invalid choice! Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input! Please enter correct data type.");
                sc.nextLine(); // clear invalid input
            } catch (Exception e) {
                System.out.println(" Unexpected error: " + e.getMessage());
            }
        }
    }
}
