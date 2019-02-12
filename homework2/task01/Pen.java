package homework2.task01;

import java.util.Objects;

public class Pen {
    private double price;
    private Type type;
    private Color color;
    private String brandName;

    public Pen(double price, Type type, Color color, String brandName) {
        this.price = price;
        this.type = type;
        this.color = color;
        this.brandName = brandName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return Double.compare(pen.price, price) == 0 &&
                type == pen.type &&
                color.equals(pen.color) &&
                brandName.equals(pen.brandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color, brandName, price);
    }

    @Override
    public String toString() {
        return "Pen{" +
                "type=" + type +
                ", color=" + color +
                ", brandName='" + brandName + '\'' +
                ", price=" + price +
                '}';
    }
}
