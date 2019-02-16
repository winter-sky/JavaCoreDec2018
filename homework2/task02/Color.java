package homework2.task02;

public enum Color {
    BLUE(1),
    BLACK(2),
    GREEN(3),
    RED(4),
    YELLOW(5);

    private int v;

    Color(int v) {
        this.v = v;
    }
    public static Color extractColor(int v){
        for(Color color:values()){
            if(color.getValue()==v) {
                return color;
            }
        }
        throw new RuntimeException("Value is not found: " + v);
    }
    public int getValue() {
        return v;
    }
}
