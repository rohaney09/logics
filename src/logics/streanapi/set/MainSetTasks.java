package logics.streanapi.set;

import java.util.*;
import java.util.stream.Collectors;

// -------------------- Student Class --------------------
class Student {
    private String name;
    private String major;
    private int age;
    private int yearsOfEnrollment;
    private double gpa;
    private int numberOfIncompleteCourses;
    private boolean onProbation;


    public Student(String name, String major, int age, int yearsOfEnrollment,
                   double gpa, int numberOfIncompleteCourses, boolean onProbation) {
        this.name = name;
        this.major = major;
        this.age = age;
        this.yearsOfEnrollment = yearsOfEnrollment;
        this.gpa = gpa;
        this.numberOfIncompleteCourses = numberOfIncompleteCourses;
        this.onProbation = onProbation;
    }

    // Getters
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getAge() { return age; }
    public int getYearsOfEnrollment() { return yearsOfEnrollment; }
    public double getGpa() { return gpa; }
    public int getNumberOfIncompleteCourses() { return numberOfIncompleteCourses; }
    public boolean isOnProbation() { return onProbation; }

    @Override
    public String toString() {
        return name + " (" + major + ", GPA=" + gpa + ", Age=" + age + ")";
    }
}

// -------------------- MAIN CLASS --------------------
public class MainSetTasks {
    public static void main(String[] args) {


        // -------- SAMPLE SET OF STUDENTS --------
        Set<Student> students = new HashSet<>(Arrays.asList(
                new Student("Rohan", "CS", 20, 2, 3.8, 0, false),
                new Student("Amit", "CS", 22, 3, 2.9, 1, true),
                new Student("Priya", "Biology", 19, 1, 3.4, 0, false),
                new Student("Sneha", "Engineering", 23, 4, 3.7, 0, false),
                new Student("Vikas", "Mathematics", 24, 2, 2.8, 2, true),
                new Student("Deepak", "Mathematics", 21, 1, 2.5, 1, true),
                new Student("Ritu", "Biology", 20, 3, 3.1, 0, false),
                new Student("Meena", "Chemistry", 22, 2, 3.3, 0, false),
                new Student("Sumit", "Engineering", 25, 5, 3.9, 0, false),
                new Student("Rahul", "Chemistry", 19, 1, 3.0, 0, false),
                new Student("Kiran", "CS", 21, 2, 3.5, 0, false),
                new Student("Suresh", "Mathematics", 26, 3, 2.7, 3, true)
        ));

        // -------------------------------------------------------------
        //                      TASK 1
        // -------------------------------------------------------------

        Map<String, Set<Student>> task1Result =
                students.stream()

                        // Group by major
                        .collect(Collectors.groupingBy(
                                Student::getMajor,
                                Collectors.toSet()
                        ))

                        // Filter majors: >5 students + avg GPA > 3.0
                        .entrySet().stream()
                        .filter(e -> e.getValue().size() > 5)
                        .filter(e -> e.getValue().stream()
                                .mapToDouble(Student::getGpa).average().orElse(0) > 3.0)

                        // Sort students inside the major
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                e -> e.getValue().stream()
                                        .sorted(
                                                Comparator.comparing(Student::getGpa)
                                                        .thenComparing(Student::getAge, Comparator.reverseOrder())
                                        )
                                        .collect(Collectors.toCollection(LinkedHashSet::new))
                        ));

        System.out.println("\n==== TASK 1 RESULT ====");
        task1Result.forEach((m, s) -> System.out.println(m + " → " + s));


        // -------------------------------------------------------------
        //                      TASK 2
        // -------------------------------------------------------------

        double avgGpa = students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0);

        Set<Student> filteredTask2 = students.stream()

                // Filter GPA < average + age > 18 + major Bio or Chem
                .filter(s -> s.getGpa() < avgGpa)
                .filter(s -> s.getAge() > 18)
                .filter(s -> s.getMajor().equalsIgnoreCase("Biology")
                        || s.getMajor().equalsIgnoreCase("Chemistry"))

                .collect(Collectors.toSet());

        // total years of enrollment (if joined last 4 years)
        int totalEnrollment = filteredTask2.stream()
                .filter(s -> s.getYearsOfEnrollment() <= 4)
                .filter(s -> s.getMajor().equalsIgnoreCase("CS")
                        || s.getMajor().equalsIgnoreCase("Engineering"))
                .mapToInt(Student::getYearsOfEnrollment)
                .sum();

        // student with highest enrollment (age<30,GPA>3.7)
        Optional<Student> highestEnrolled =
                filteredTask2.stream()
                        .filter(s -> s.getAge() < 30)
                        .filter(s -> s.getGpa() > 3.7)
                        .max(Comparator.comparing(Student::getYearsOfEnrollment));

        System.out.println("\n==== TASK 2 RESULT ====");
        System.out.println("Filtered Students: " + filteredTask2);
        System.out.println("Total Years of Enrollment: " + totalEnrollment);
        System.out.println("Highest Enrolled Student: " +
                highestEnrolled.orElse(null));


        // -------------------------------------------------------------
        //                      TASK 3
        // -------------------------------------------------------------

        // 1. Filter out:
        Set<Student> filteredTask3 = students.stream()
                .filter(s ->
                        !(s.getYearsOfEnrollment() <= 3 &&
                                s.getMajor().equalsIgnoreCase("Mathematics") &&
                                s.getGpa() < 3.0 &&
                                s.isOnProbation())
                )
                .collect(Collectors.toSet());

        // Average GPA of all
        double avgGpaAll = students.stream().mapToDouble(Student::getGpa).average().orElse(0);

        // 2. Sum GPAs of remaining students
        double sumGpa = filteredTask3.stream()
                .filter(s -> s.getAge() > 22)
                .filter(s -> s.getGpa() > avgGpaAll)
                .mapToDouble(Student::getGpa)
                .sum();

        // 3. Average age (if dept >10 students & avg GPA>3.5)
        Map<String, List<Student>> groupDept = filteredTask3.stream()
                .collect(Collectors.groupingBy(Student::getMajor));

        double avgAgeTask3 = groupDept.entrySet().stream()
                .filter(e -> e.getValue().size() > 10)
                .filter(e -> e.getValue().stream()
                        .mapToDouble(Student::getGpa).average().orElse(0) > 3.5)
                .flatMap(e -> e.getValue().stream())
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);

        // 4. Factorial of avg age
        int totalYears = students.stream()
                .mapToInt(Student::getYearsOfEnrollment)
                .sum();

        long factorial = 0;
        if (totalYears > 30 && avgGpaAll < 3.9 && avgAgeTask3 > 0) {
            int n = (int) avgAgeTask3;
            factorial = factorial(n);
        }

        System.out.println("\n==== TASK 3 RESULT ====");
        System.out.println("Sum of GPAs: " + sumGpa);
        System.out.println("Average Age: " + avgAgeTask3);
        System.out.println("Factorial of Average Age: " + factorial);
    }

    // factorial method
    private static long factorial(int n) {
        long f = 1;
        for (int i = 1; i <= n; i++) f *= i;
        return f;
    }
}

