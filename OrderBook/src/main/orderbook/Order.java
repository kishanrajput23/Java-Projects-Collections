package orderbook;

public class Order {
    private String id;
    private double price;
    private int quantity;
    private boolean isBuyOrder;

    public Order(String id, double price, int quantity, boolean isBuyOrder) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.isBuyOrder = isBuyOrder;
    }

    //getters
    public String getId() { 
        return id; 
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public boolean getIsBuyOrder() {
        return isBuyOrder;
    }

    //setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //debugging
    public String toString() {
        return (isBuyOrder ? "Buy" : "Sell") + " Order[ID: " + id + ", Price: " + price + ", Quantity: " + quantity + "]";
    }
}
