package inholland.Model;

public class Camera {
    int id;
    String brand;
    String model;

    public Camera(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Camera: " + id + ", " + brand + ", " + model;
    }
}
