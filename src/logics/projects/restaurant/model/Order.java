package logics.projects.restaurant.model;

import java.util.List;

public class Order {
    private String orderId;
    private String customerId;
    // Per BRD 7: Order Items -> LinkedList
    private List<MenuItem> menuItems;

    public Order(String orderId, String customerId, List<MenuItem> menuItems) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.menuItems = menuItems;
    }

    // Getters
    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public List<MenuItem> getMenuItems() { return menuItems; }

    // Setters
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public void setMenuItems(List<MenuItem> menuItems) { this.menuItems = menuItems; }

    public double getTotalPrice() {
        double total = 0;
        for (MenuItem item : menuItems) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order [ID=").append(orderId)
                .append(", CustomerID=").append(customerId)
                .append(", Total=₹").append(getTotalPrice())
                .append("]\n");

        for (MenuItem item : menuItems) {
            sb.append("\t- ").append(item.getName()).append(" (₹").append(item.getPrice()).append(")\n");
        }
        return sb.toString();
    }
}
