package logics.projects.restaurant.service;


import logics.projects.restaurant.exception.DuplicateEntryException;
import logics.projects.restaurant.exception.ResourceNotFoundException;
import logics.projects.restaurant.model.MenuItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuService {

    // Per BRD 7: Menu Items -> ArrayList
    private final List<MenuItem> menuItems = new ArrayList<>();
    // Per BRD 7: Unique Categories -> HashSet
    private final Set<String> categories = new HashSet<>();

    public MenuService() {
        // Adding some dummy data to start with
        try {
            addMenuItem("M001", "Paneer Tikka", 250.00, "Starters");
            addMenuItem("M002", "Dal Makhani", 350.00, "Main Course");
            addMenuItem("M003", "Garlic Naan", 60.00, "Breads");
        } catch (DuplicateEntryException e) {
            // This won't happen with initial data
        }
    }

    /**
     * Adds a new menu item.
     * Throws DuplicateEntryException if ID exists.
     */
    public void addMenuItem(String id, String name, double price, String category) throws DuplicateEntryException {
        // Check for duplicate ID
        if (findItemById(id) != null) {
            throw new DuplicateEntryException("Menu Item with ID " + id + " already exists.");
        }

        MenuItem newItem = new MenuItem(id, name, price, category);
        menuItems.add(newItem);
        categories.add(category); // Add to set (duplicates are automatically ignored)
    }

    /**
     * Retrieves all menu items.
     */
    public List<MenuItem> getAllMenuItems() {
        return new ArrayList<>(menuItems); // Return a copy
    }

    /**
     * Retrieves all unique categories.
     */
    public Set<String> getCategories() {
        return new HashSet<>(categories); // Return a copy
    }

    /**
     * Finds a menu item by its ID. Returns null if not found.
     * This is a helper method.
     */
    private MenuItem findItemById(String id) {
        for (MenuItem item : menuItems) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Public getter for item by ID, throwing an exception if not found.
     * Used by OrderService.
     */
    public MenuItem getMenuItemById(String id) throws ResourceNotFoundException {
        MenuItem item = findItemById(id);
        if (item == null) {
            throw new ResourceNotFoundException("Menu Item with ID " + id + " not found.");
        }
        return item;
    }

    /**
     * Updates an existing menu item.
     * Throws ResourceNotFoundException if ID doesn't exist.
     */
    public void updateMenuItem(String id, String newName, double newPrice, String newCategory) throws ResourceNotFoundException {
        MenuItem itemToUpdate = getMenuItemById(id); // This will throw if not found

        itemToUpdate.setName(newName);
        itemToUpdate.setPrice(newPrice);
        itemToUpdate.setCategory(newCategory);

        // Update category set
        categories.add(newCategory);
        // Note: Old category is not removed for simplicity,
        // a full implementation might check if it's still in use.
    }

    /**
     * Deletes a menu item by ID.
     * Throws ResourceNotFoundException if ID doesn't exist.
     */
    public void deleteMenuItem(String id) throws ResourceNotFoundException {
        MenuItem itemToRemove = getMenuItemById(id); // This will throw if not found
        menuItems.remove(itemToRemove);
    }
}
