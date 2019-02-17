package homework2.task02;

public class DocumentHolder extends Stationery {
    Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "DocumentHolder{" +
                "color=" + color +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", category=" + category +
                '}';
    }
}
