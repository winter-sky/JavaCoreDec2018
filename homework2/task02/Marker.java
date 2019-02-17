package homework2.task02;

public class Marker extends Stationery {
    Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
