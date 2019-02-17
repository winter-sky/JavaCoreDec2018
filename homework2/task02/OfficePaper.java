package homework2.task02;

public class OfficePaper extends Stationery {
    int amountOfSheet;
    PaperFormat paperFormat;

    public int getAmountOfSheet() {
        return amountOfSheet;
    }

    public void setAmountOfSheet(int amountOfSheet) {
        this.amountOfSheet = amountOfSheet;
    }

    public PaperFormat getPaperFormat() {
        return paperFormat;
    }

    public void setPaperFormat(PaperFormat paperFormat) {
        this.paperFormat = paperFormat;
    }

    @Override
    public String toString() {
        return "OfficePaper{" +
                "amountOfSheet=" + amountOfSheet +
                ", paperFormat=" + paperFormat +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", category=" + category +
                '}';
    }
}
