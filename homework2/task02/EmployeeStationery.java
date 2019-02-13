package homework2.task02;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStationery {
    public List<Stationery> employeeStationery = new ArrayList<Stationery>();

    public void addStationery(double price, String brand, StationeryType type) {
        Stationery stationery = new Stationery(price, brand, type);
        employeeStationery.add(stationery);
    }

    @Override
    public String toString() {
        return "Employee stationery: " +
                employeeStationery;
    }
}
