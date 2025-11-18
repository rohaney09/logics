package logics.streanapi.list;

import java.util.*;
import java.util.stream.Collectors;

// -------------------- Employee Class --------------------
class Employee {
    private int id;                      // Added
    private String name;
    private String department;
    private String jobTitle;
    private String type;                 // Added: FULL-TIME / PART-TIME
    private int age;
    private int yearsOfExperience;
    private double salary;
    private int performanceRating;
    private int yearsSinceJoining;


    public Employee(int id, String name, String department, String jobTitle, String type, int age,
                    int yearsOfExperience, double salary, int performanceRating,
                    int yearsSinceJoining) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.jobTitle = jobTitle;
        this.type = type;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
        this.performanceRating = performanceRating;
        this.yearsSinceJoining = yearsSinceJoining;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getJobTitle() { return jobTitle; }
    public String getType() { return type; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public int getYearsSinceJoining() { return yearsSinceJoining; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public int getPerformanceRating() { return performanceRating; }
}


// -------------------- Main Class --------------------
public class Main {
    public static void main(String[] args){

        // --------- STATIC LIST OF 10 EMPLOYEES ---------
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Rohan", "IT", "Manager", "FULL-TIME", 30, 8, 120000, 4, 2),
                new Employee(2, "Priya", "HR", "Executive", "PART-TIME", 26, 3, 60000, 5, 1),
                new Employee(3, "Amit", "IT", "Manager", "FULL-TIME", 35, 10, 150000, 3, 1),
                new Employee(4, "Sneha", "Finance", "Manager", "FULL-TIME", 40, 12, 90000, 4, 4),
                new Employee(5, "Rahul", "IT", "Developer", "PART-TIME", 25, 2, 70000, 5, 1),
                new Employee(6, "Kiran", "Sales", "Manager", "PART-TIME", 38, 11, 110000, 2, 3),
                new Employee(7, "Vikas", "IT", "Manager", "FULL-TIME", 32, 6, 130000, 5, 2),
                new Employee(8, "Meena", "HR", "Manager", "FULL-TIME", 45, 15, 140000, 1, 5),
                new Employee(9, "Deepak", "Finance", "Analyst", "FULL-TIME", 29, 4, 75000, 4, 2),
                new Employee(10, "Suman", "IT", "Manager", "FULL-TIME", 28, 5, 105000, 3, 1)
        );

        // ------------------- TASK 1 ---------------------------
        List<String> result = employees.stream()
                .filter(e -> e.getJobTitle().equalsIgnoreCase("Manager"))
                .filter(e -> e.getSalary() > 100000)
                .filter(e -> e.getYearsSinceJoining() <= 3)
                .sorted(Comparator
                        .comparing(Employee::getYearsOfExperience).reversed()
                        .thenComparing(Employee::getPerformanceRating))
                .map(e -> new StringBuilder(e.getName()).reverse().toString().toUpperCase())
                .collect(Collectors.toList());

        System.out.println("\nTask 1 Result:");
        result.forEach(System.out::println);


        // ------------------- TASK 2 ---------------------------
        List<Integer> resultIds = employees.stream()
                .filter(e -> e.getYearsSinceJoining() <= 5)
                .filter(e -> e.getPerformanceRating() < 8)
                .filter(e -> e.getSalary() >= 60000 && e.getSalary() <= 120000)
                .sorted(
                        Comparator.comparing(Employee::getSalary)
                                .thenComparing(Employee::getYearsOfExperience, Comparator.reverseOrder())
                )
                .map(e -> e.getId() * 10) // FIXED
                .collect(Collectors.toList());

        System.out.println("\nTask 2 Result IDs:");
        resultIds.forEach(System.out::println);


        // ------------------- TASK 3 ---------------------------
        List<Employee> filtered = employees.stream()
                .filter(e -> !(e.getType().equalsIgnoreCase("PART-TIME")
                        && e.getSalary() < 50000
                        && (e.getDepartment().equalsIgnoreCase("Sales")
                        || e.getDepartment().equalsIgnoreCase("Marketing"))))
                .collect(Collectors.toList());

        double salarySum = filtered.stream()
                .filter(e -> e.getYearsOfExperience() > 3)
                .mapToDouble(Employee::getSalary)
                .sum();

        double avgAge = filtered.stream()
                .filter(e -> e.getPerformanceRating() >= 7)
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0.0);

        System.out.println("\nTask 3 Salary Sum: " + salarySum);
        System.out.println("Task 3 Average Age: " + avgAge);
    }
}
