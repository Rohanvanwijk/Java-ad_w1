package inholland.Model;

public class Camera {
    int id;
    String brand;
    String model;
    double price;
    int amount;

    public Camera(int id, String brand, String model, double price, int amount) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.amount = amount;
    }

    public Camera() {}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Camera: " + id + ", " + brand + ", " + model;
    }
}
