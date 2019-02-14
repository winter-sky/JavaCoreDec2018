package homework2.task02;

public enum Department {
    IT(0),
    HR(1),
    ACCOUNTING_DEPARTMENT(2),
    UNDEFINED(3);

    private int v;

    /**
     * Constructor.
     *
     * @param v Integer representation.
     */
    Department(int v) {
        this.v = v;
    }

    public static Department extract(int v) {
        for (Department d : values()) {
            if (d.getValue() == v) {
                return d;
            }
        }

        throw new RuntimeException("Value is not found: " + v);
    }

    public int getValue() {
        return v;
    }
}
