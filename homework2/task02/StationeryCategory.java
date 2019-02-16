package homework2.task02;

public enum StationeryCategory {
    OFFICE(1),
    SCHOOL(2),
    CHILDREN(3);
    private int v;

    StationeryCategory(int v) {
        this.v = v;
    }

    public static StationeryCategory extractStationeryCategory(int v) {
        for (StationeryCategory stationeryCategory : values()) {
            if (stationeryCategory.getValue() == v)
                return stationeryCategory;
        }
        throw new RuntimeException("Value is not found: " + v);
    }

    public int getValue() {
        return v;
    }
}
