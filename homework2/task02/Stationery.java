package homework2.task02;

public class Stationery {
    private double price;
    private String brand;
    private StationeryType type;

    public Stationery(double price, String brand, StationeryType type) {
        this.price = price;
        this.brand = brand;
        this.type = type;
    }

    @Override
    public String toString() {
        return "price=" + price +
                ", brand='" + brand + '\'' +
                ", type=" + type;
    }
}
