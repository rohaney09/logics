package logics.projects.restaurant.service;

import logics.projects.restaurant.exception.DuplicateEntryException;
import logics.projects.restaurant.exception.ResourceNotFoundException;
import logics.projects.restaurant.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class for Customer Management.
 * Per BRD 6 (Maintainability) & 7.
 */
public class CustomerService {

    // Per BRD 7: Customers -> HashMap
    private final Map<String, Customer> customers = new HashMap<>();

    public CustomerService() {
        // Adding some dummy data
        try {
            addCustomer("C001", "Alice Smith", "9876543210");
            addCustomer("C002", "Bob Johnson", "8765432109");
        } catch (DuplicateEntryException e) {
            // This won't happen with initial data
        }
    }

    /**
     * Adds a new customer.
     * Throws DuplicateEntryException if ID exists.
     */
    public void addCustomer(String id, String name, String phone) throws DuplicateEntryException {
        if (customers.containsKey(id)) {
            throw new DuplicateEntryException("Customer with ID " + id + " already exists.");
        }
        Customer newCustomer = new Customer(id, name, phone);
        customers.put(id, newCustomer);
    }

    /**
     * Retrieves all customers.
     */
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    /**
     * Gets a customer by ID.
     * Throws ResourceNotFoundException if not found.
     */
    public Customer getCustomerById(String id) throws ResourceNotFoundException {
        Customer customer = customers.get(id);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer with ID " + id + " not found.");
        }
        return customer;
    }

    /**
     * Updates an existing customer.
     * Throws ResourceNotFoundException if ID doesn't exist.
     */
    public void updateCustomer(String id, String newName, String newPhone) throws ResourceNotFoundException {
        Customer customerToUpdate = getCustomerById(id); // This will throw if not found

        customerToUpdate.setName(newName);
        customerToUpdate.setPhoneNumber(newPhone);
    }

    /**
     * Deletes a customer by ID.
     * Throws ResourceNotFoundException if ID doesn't exist.
     */
    public void deleteCustomer(String id) throws ResourceNotFoundException {
        if (customers.remove(id) == null) {
            throw new ResourceNotFoundException("Customer with ID " + id + " not found.");
        }
    }
}
