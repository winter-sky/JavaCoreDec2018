package homework2.task02;

public class Marker extends Stationery {
    Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

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

    @Override
    public String toString() {
        return "Marker{" +
                "color=" + color +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", category=" + category +
                '}';
    }
}
