package homework2.task02;

public class Stationery {
    protected double price;
    protected String brand;
    protected StationeryCategory category;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public StationeryCategory getCategory() {
        return category;
    }

    public void setCategory(StationeryCategory category) {
        this.category = category;
    }
}
