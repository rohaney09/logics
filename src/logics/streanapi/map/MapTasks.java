package logics.streanapi.map;


import java.util.*;
import java.util.stream.Collectors;

// -------------------- Customer Class --------------------
class Customer {
    private String id;
    private String name;
    private String country;
    private int age;
    private int yearsOfMembership;
    private double balance;
    private int loyaltyScore;
    private int numberOfTransactions;


    public Customer(String id, String name, String country, int age,
                    int yearsOfMembership, double balance,
                    int loyaltyScore, int numberOfTransactions) {

        this.id = id;
        this.name = name;
        this.country = country;
        this.age = age;
        this.yearsOfMembership = yearsOfMembership;
        this.balance = balance;
        this.loyaltyScore = loyaltyScore;
        this.numberOfTransactions = numberOfTransactions;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCountry() { return country; }
    public int getAge() { return age; }
    public int getYearsOfMembership() { return yearsOfMembership; }
    public double getBalance() { return balance; }
    public int getLoyaltyScore() { return loyaltyScore; }
    public int getNumberOfTransactions() { return numberOfTransactions; }

    @Override
    public String toString() {
        return name + " (" + id + ", " + country + ", Age=" + age + ", Mem=" + yearsOfMembership + ")";
    }
}



// -------------------- MAIN CLASS --------------------
public class MapTasks {
    public static void main(String[] args) {

        // ---------- SAMPLE MAP OF CUSTOMER OBJECTS ----------
        Map<String, Customer> customers = new HashMap<>();


        customers.put("C1", new Customer("C1", "Rohan", "India", 25, 3, 4500, 3, 12));
        customers.put("C2", new Customer("C2", "Neha", "India", 33, 7, 5200, 5, 40));
        customers.put("C3", new Customer("C3", "Amit", "USA", 29, 5, 1800, 2, 20));
        customers.put("C4", new Customer("C4", "Sneha", "UK", 40, 10, 7000, 7, 30));
        customers.put("C5", new Customer("C5", "Kiran", "India", 23, 2, 3000, 3, 10));
        customers.put("C6", new Customer("C6", "Priya", "USA", 31, 9, 6500, 8, 55));
        customers.put("C7", new Customer("C7", "Vikas", "India", 28, 4, 2400, 1, 6));
        customers.put("C8", new Customer("C8", "Meena", "UK", 36, 11, 8000, 9, 70));
        customers.put("C9", new Customer("C9", "Suman", "India", 22, 1, 2700, 2, 8));
        customers.put("C10", new Customer("C10", "Deepak", "USA", 30, 6, 5000, 4, 25));

        // -------------------------------------------------------------
        //                          TASK 1
        // -------------------------------------------------------------

        // 1️⃣ Average balance
        double avgBalance = customers.values().stream()
                .mapToDouble(Customer::getBalance)
                .average()
                .orElse(0);

        // 2️⃣ Filter customers with balance >= avg balance
        List<Customer> filteredTask1 = customers.values().stream()
                .filter(c -> c.getBalance() >= avgBalance)
                .collect(Collectors.toList());

        // 3️⃣ Total years of membership
        int totalMembershipYears = filteredTask1.stream()
                .mapToInt(Customer::getYearsOfMembership)
                .sum();

        // 4️⃣ Find customer with highest membership
        Optional<Customer> highestMember =
                filteredTask1.stream()
                        .max(Comparator.comparing(Customer::getYearsOfMembership));

        System.out.println("==== TASK 1 RESULT ====");
        System.out.println("Average Balance: " + avgBalance);
        System.out.println("Filtered Customers: " + filteredTask1);
        System.out.println("Total Years of Membership: " + totalMembershipYears);
        System.out.println("Customer With Highest Membership: " +
                highestMember.orElse(null));


        // -------------------------------------------------------------
        //                          TASK 2
        // -------------------------------------------------------------

        // 1️⃣ Filter customers: joined last 3 years + loyalty<4 + balance 2000-5000
        List<Customer> filteredTask2 = customers.values().stream()
                .filter(c -> c.getYearsOfMembership() <= 3)
                .filter(c -> c.getLoyaltyScore() < 4)
                .filter(c -> c.getBalance() >= 2000 && c.getBalance() <= 5000)
                .collect(Collectors.toList());

        // 2️⃣ Sum balances for even age
        double sumBalancesEvenAge = filteredTask2.stream()
                .filter(c -> c.getAge() % 2 == 0)
                .mapToDouble(Customer::getBalance)
                .sum();

        // 3️⃣ Average age if country has >10 customers
        Map<String, List<Customer>> groupByCountry =
                customers.values().stream()
                        .collect(Collectors.groupingBy(Customer::getCountry));

        double avgAgeTask2 = groupByCountry.entrySet().stream()
                .filter(e -> e.getValue().size() > 10)
                .flatMap(e -> e.getValue().stream())
                .mapToInt(Customer::getAge)
                .average()
                .orElse(0);

        System.out.println("\n==== TASK 2 RESULT ====");
        System.out.println("Filtered Customers (Task 2): " + filteredTask2);
        System.out.println("Sum of Balances (Even Age): " + sumBalancesEvenAge);
        System.out.println("Average Age (Countries with >10 users): " + avgAgeTask2);
    }
}

