package homework2.task02;

public enum PaperFormat {
    A3(1),
    A4(2),
    A5(3);
    private int v;

    PaperFormat(int v) {
        this.v = v;
    }

    public static PaperFormat extractPaperFormat(int v) {
        for(PaperFormat paperFormat: PaperFormat.values()){
            if(paperFormat.getValue()==v)
                return paperFormat;
        }
        throw new RuntimeException("Value is not found: " + v);
    }

    public int getValue() {
        return v;
    }
}
