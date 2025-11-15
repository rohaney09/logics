package logics.projects.restaurant.service;


import logics.projects.restaurant.exception.DuplicateEntryException;
import logics.projects.restaurant.exception.ResourceNotFoundException;
import logics.projects.restaurant.model.Customer;
import logics.projects.restaurant.model.MenuItem;
import logics.projects.restaurant.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Service class for Order Management.
 * Per BRD 6 (Maintainability) & 7.
 */
public class OrderService {

    // Per BRD 7: Orders -> HashMap
    private final Map<String, Order> orders = new HashMap<>();

    // Dependencies on other services
    private final CustomerService customerService;
    private final MenuService menuService;

    public OrderService(CustomerService customerService, MenuService menuService) {
        this.customerService = customerService;
        this.menuService = menuService;
    }

    /**
     * Creates a new order.
     * Throws DuplicateEntryException if order ID exists.
     * Throws ResourceNotFoundException if customer or menu items don't exist.
     */
    public void createOrder(String orderId, String customerId, List<String> menuItemIds)
            throws DuplicateEntryException, ResourceNotFoundException {

        if (orders.containsKey(orderId)) {
            throw new DuplicateEntryException("Order with ID " + orderId + " already exists.");
        }

        // Validate customer
        Customer customer = customerService.getCustomerById(customerId); // Throws if not found

        // Per BRD 7: Order Items -> LinkedList
        List<MenuItem> items = new LinkedList<>();

        // Validate and retrieve menu items
        for (String itemId : menuItemIds) {
            MenuItem item = menuService.getMenuItemById(itemId); // Throws if not found
            items.add(item);
        }

        Order newOrder = new Order(orderId, customer.getId(), items);
        orders.put(orderId, newOrder);
    }

    /**
     * Retrieves all orders.
     */
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    /**
     * Gets a single order by ID.
     * Throws ResourceNotFoundException if not found.
     */
    public Order getOrderById(String orderId) throws ResourceNotFoundException {
        Order order = orders.get(orderId);
        if (order == null) {
            throw new ResourceNotFoundException("Order with ID " + orderId + " not found.");
        }
        return order;
    }

    /**
     * Adds an item to an existing order.
     */
    public void addItemToOrder(String orderId, String menuItemId) throws ResourceNotFoundException {
        Order order = getOrderById(orderId);
        MenuItem item = menuService.getMenuItemById(menuItemId);

        order.getMenuItems().add(item);
    }

    /**
     * Removes an item from an existing order.
     * Note: This removes the first occurrence of the item.
     */
    public void removeItemFromOrder(String orderId, String menuItemId) throws ResourceNotFoundException {
        Order order = getOrderById(orderId);
        MenuItem itemToRemove = null;

        // Find the item in the order's list
        for (MenuItem item : order.getMenuItems()) {
            if (item.getId().equals(menuItemId)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            order.getMenuItems().remove(itemToRemove);
        } else {
            throw new ResourceNotFoundException("Item ID " + menuItemId + " not found in order " + orderId + ".");
        }
    }

    /**
     * Cancels (deletes) an order.
     * Throws ResourceNotFoundException if ID doesn't exist.
     */
    public void cancelOrder(String orderId) throws ResourceNotFoundException {
        if (orders.remove(orderId) == null) {
            throw new ResourceNotFoundException("Order with ID " + orderId + " not found.");
        }
    }
}