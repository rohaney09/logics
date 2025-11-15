package logics.projects.restaurant.model;


public class MenuItem {
    private String id;
    private String name;
    private double price;
    private String category;

    public MenuItem(String id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setCategory(String category) { this.category = category; }

    @Override
    public String toString() {
        return "MenuItem [ID=" + id + ", Name=" + name + ", Price=₹" + price + ", Category=" + category + "]";
    }
}
