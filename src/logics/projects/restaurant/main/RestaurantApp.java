package logics.projects.restaurant.main;


import logics.projects.restaurant.exception.DuplicateEntryException;
import logics.projects.restaurant.exception.MenuSelectionException;
import logics.projects.restaurant.exception.ResourceNotFoundException;
import logics.projects.restaurant.model.Customer;
import logics.projects.restaurant.model.MenuItem;
import logics.projects.restaurant.model.Order;
import logics.projects.restaurant.service.CustomerService;
import logics.projects.restaurant.service.MenuService;
import logics.projects.restaurant.service.OrderService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RestaurantApp {

    // Services
    private static final MenuService menuService = new MenuService();
    private static final CustomerService customerService = new CustomerService();
    private static final OrderService orderService = new OrderService(customerService, menuService);

    // Scanner for console input
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenuLoop();
        scanner.close();
    }

    /**
     * Main menu loop (BRD 4)
     */
    private static void mainMenuLoop() {
        boolean exit = false;
        while (!exit) {
            try {
                displayMainMenu();
                int choice = getUserIntInput();

                switch (choice) {
                    case 1:
                        handleMenuManagement();
                        break;
                    case 2:
                        handleCustomerManagement();
                        break;
                    case 3:
                        handleOrderManagement();
                        break;
                    case 0:
                        exit = true;
                        System.out.println("Thank you for using the Restaurant Management App. Goodbye!");
                        break;
                    default:
                        // Per BRD 5: Invalid menu selection
                        throw new MenuSelectionException("Invalid choice. Please select from 0-3.");
                }
            } catch (MenuSelectionException | InputMismatchException e) {
                // Per BRD 5: Handle input mismatch and invalid selection
                System.err.println("Error: " + e.getMessage());
                if (e instanceof InputMismatchException) {
                    scanner.nextLine(); // Clear invalid input from scanner
                }
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n--- 🍽️ Restaurant Management Main Menu ---");
        System.out.println("1. Menu Item Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Order Management");
        System.out.println("0. Exit Application");
        System.out.print("Enter your choice: ");
    }

    // --- Menu Item Management ---

    private static void handleMenuManagement() {
        boolean back = false;
        while (!back) {
            try {
                displayMenuManagementMenu();
                int choice = getUserIntInput();

                switch (choice) {
                    case 1:
                        addMenuItem();
                        break;
                    case 2:
                        viewAllMenuItems();
                        break;
                    case 3:
                        updateMenuItem();
                        break;
                    case 4:
                        deleteMenuItem();
                        break;
                    case 5:
                        viewCategories();
                        break;
                    case 0:
                        back = true;
                        break;
                    default:
                        throw new MenuSelectionException("Invalid choice. Please select from 0-5.");
                }
            } catch (MenuSelectionException | DuplicateEntryException | ResourceNotFoundException | InputMismatchException e) {
                System.err.println("Error: " + e.getMessage());
                if (e instanceof InputMismatchException) {
                    scanner.nextLine(); // Clear buffer
                }
            }
        }
    }

    private static void displayMenuManagementMenu() {
        System.out.println("\n--- 📋 Menu Item Management ---");
        System.out.println("1. Add New Menu Item");
        System.out.println("2. View All Menu Items");
        System.out.println("3. Update Menu Item");
        System.out.println("4. Delete Menu Item");
        System.out.println("5. View All Categories");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private static void addMenuItem() throws DuplicateEntryException, InputMismatchException {
        System.out.println("\n--- Add New Menu Item ---");
        System.out.print("Enter Item ID (e.g., M004): ");
        String id = scanner.nextLine();
        System.out.print("Enter Item Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Item Price: ");
        double price = getUserDoubleInput();
        System.out.print("Enter Item Category: ");
        String category = scanner.nextLine();

        menuService.addMenuItem(id, name, price, category);
        System.out.println("✅ Menu item added successfully!");
    }

    private static void viewAllMenuItems() {
        System.out.println("\n--- All Menu Items ---");
        List<MenuItem> items = menuService.getAllMenuItems();
        if (items.isEmpty()) {
            System.out.println("No menu items found.");
        } else {
            items.forEach(System.out::println);
        }
    }

    private static void viewCategories() {
        System.out.println("\n--- Unique Categories ---");
        System.out.println(menuService.getCategories());
    }

    private static void updateMenuItem() throws ResourceNotFoundException, InputMismatchException {
        System.out.println("\n--- Update Menu Item ---");
        System.out.print("Enter Item ID to update: ");
        String id = scanner.nextLine();
        // Check if item exists first
        menuService.getMenuItemById(id);

        System.out.print("Enter New Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter New Price: ");
        double newPrice = getUserDoubleInput();
        System.out.print("Enter New Category: ");
        String newCategory = scanner.nextLine();

        menuService.updateMenuItem(id, newName, newPrice, newCategory);
        System.out.println("✅ Menu item updated successfully!");
    }

    private static void deleteMenuItem() throws ResourceNotFoundException {
        System.out.println("\n--- Delete Menu Item ---");
        System.out.print("Enter Item ID to delete: ");
        String id = scanner.nextLine();

        menuService.deleteMenuItem(id);
        System.out.println("✅ Menu item deleted successfully!");
    }

    // --- Customer Management ---

    private static void handleCustomerManagement() {
        boolean back = false;
        while (!back) {
            try {
                displayCustomerManagementMenu();
                int choice = getUserIntInput();

                switch (choice) {
                    case 1:
                        addCustomer();
                        break;
                    case 2:
                        viewAllCustomers();
                        break;
                    case 3:
                        updateCustomer();
                        break;
                    case 4:
                        deleteCustomer();
                        break;
                    case 0:
                        back = true;
                        break;
                    default:
                        throw new MenuSelectionException("Invalid choice. Please select from 0-4.");
                }
            } catch (MenuSelectionException | DuplicateEntryException | ResourceNotFoundException | InputMismatchException e) {
                System.err.println("Error: " + e.getMessage());
                if (e instanceof InputMismatchException) {
                    scanner.nextLine(); // Clear buffer
                }
            }
        }
    }

    private static void displayCustomerManagementMenu() {
        System.out.println("\n--- 👥 Customer Management ---");
        System.out.println("1. Add New Customer");
        System.out.println("2. View All Customers");
        System.out.println("3. Update Customer Details");
        System.out.println("4. Delete Customer");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private static void addCustomer() throws DuplicateEntryException {
        System.out.println("\n--- Add New Customer ---");
        System.out.print("Enter Customer ID (e.g., C003): ");
        String id = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Customer Phone Number: ");
        String phone = scanner.nextLine();

        customerService.addCustomer(id, name, phone);
        System.out.println("✅ Customer added successfully!");
    }

    private static void viewAllCustomers() {
        System.out.println("\n--- All Customers ---");
        List<Customer> customers = customerService.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            customers.forEach(System.out::println);
        }
    }

    private static void updateCustomer() throws ResourceNotFoundException {
        System.out.println("\n--- Update Customer ---");
        System.out.print("Enter Customer ID to update: ");
        String id = scanner.nextLine();
        // Check if customer exists
        customerService.getCustomerById(id);

        System.out.print("Enter New Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter New Phone Number: ");
        String newPhone = scanner.nextLine();

        customerService.updateCustomer(id, newName, newPhone);
        System.out.println("✅ Customer updated successfully!");
    }

    private static void deleteCustomer() throws ResourceNotFoundException {
        System.out.println("\n--- Delete Customer ---");
        System.out.print("Enter Customer ID to delete: ");
        String id = scanner.nextLine();

        customerService.deleteCustomer(id);
        System.out.println("✅ Customer deleted successfully!");
    }

    // --- Order Management ---

    private static void handleOrderManagement() {
        boolean back = false;
        while (!back) {
            try {
                displayOrderManagementMenu();
                int choice = getUserIntInput();

                switch (choice) {
                    case 1:
                        createOrder();
                        break;
                    case 2:
                        viewAllOrders();
                        break;
                    case 3:
                        updateOrder();
                        break;
                    case 4:
                        cancelOrder();
                        break;
                    case 0:
                        back = true;
                        break;
                    default:
                        throw new MenuSelectionException("Invalid choice. Please select from 0-4.");
                }
            } catch (MenuSelectionException | DuplicateEntryException | ResourceNotFoundException | InputMismatchException e) {
                System.err.println("Error: " + e.getMessage());
                if (e instanceof InputMismatchException) {
                    scanner.nextLine(); // Clear buffer
                }
            }
        }
    }

    private static void displayOrderManagementMenu() {
        System.out.println("\n--- 🧾 Order Management ---");
        System.out.println("1. Create New Order");
        System.out.println("2. View All Orders");
        System.out.println("3. Update Order (Add/Remove Items)");
        System.out.println("4. Cancel Order");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private static void createOrder() throws DuplicateEntryException, ResourceNotFoundException {
        System.out.println("\n--- Create New Order ---");
        System.out.print("Enter new Order ID (e.g., O1001): ");
        String orderId = scanner.nextLine();
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();

        // Display items for user
        viewAllMenuItems();

        List<String> menuItemIds = new ArrayList<>();
        while (true) {
            System.out.print("Enter Menu Item ID to add (or 'done' to finish): ");
            String itemId = scanner.nextLine();
            if (itemId.equalsIgnoreCase("done")) {
                break;
            }
            menuItemIds.add(itemId);
        }

        if (menuItemIds.isEmpty()) {
            System.out.println("Order must contain at least one item. Order creation cancelled.");
            return;
        }

        orderService.createOrder(orderId, customerId, menuItemIds);
        System.out.println("✅ Order created successfully!");
    }

    private static void viewAllOrders() {
        System.out.println("\n--- All Orders ---");
        List<Order> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            orders.forEach(System.out::println);
        }
    }

    private static void updateOrder() throws ResourceNotFoundException {
        System.out.println("\n--- Update Order ---");
        System.out.print("Enter Order ID to update: ");
        String orderId = scanner.nextLine();

        // Fetch and display current order
        Order order = orderService.getOrderById(orderId);
        System.out.println("Current Order Details:");
        System.out.println(order);

        System.out.println("1. Add Item to Order");
        System.out.println("2. Remove Item from Order");
        System.out.println("0. Cancel Update");
        System.out.print("Choose action: ");

        int choice = getUserIntInput();

        switch (choice) {
            case 1:
                viewAllMenuItems();
                System.out.print("Enter Menu Item ID to ADD: ");
                String itemToAddId = scanner.nextLine();
                orderService.addItemToOrder(orderId, itemToAddId);
                System.out.println("✅ Item added to order!");
                break;
            case 2:
                System.out.print("Enter Menu Item ID to REMOVE: ");
                String itemToRemoveId = scanner.nextLine();
                orderService.removeItemFromOrder(orderId, itemToRemoveId);
                System.out.println("✅ Item removed from order!");
                break;
            case 0:
                System.out.println("Update cancelled.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void cancelOrder() throws ResourceNotFoundException {
        System.out.println("\n--- Cancel Order ---");
        System.out.print("Enter Order ID to cancel: ");
        String orderId = scanner.nextLine();

        orderService.cancelOrder(orderId);
        System.out.println("✅ Order cancelled successfully!");
    }


    // --- Utility Methods ---

    /**
     * Helper to get an integer input and handle newline.
     */
    private static int getUserIntInput() throws InputMismatchException {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }

    /**
     * Helper to get a double input and handle newline.
     */
    private static double getUserDoubleInput() throws InputMismatchException {
        double input = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        return input;
    }
}