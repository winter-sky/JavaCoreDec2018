package homework2.task02;

import java.util.Map;
import java.util.TreeMap;

public class EmployeeStationery {
    Map<Employee, Stationery> empStationery = new TreeMap<Employee, Stationery>();

    public void createEmployeeStationery() {
        this.chooseStationeryType();
    }

    public void chooseStationeryType() {
        int i = 1;
        for (StationeryType type : StationeryType.values()) {
            System.out.println("Enter " + i + " to add " + type.toString());
            i++;
        }
    }

    public void addStationery() {

    }

    public void deleteStationery() {

    }

    public static void main(String[] args) {
        EmployeeStationery employeeStationery = new EmployeeStationery();
        employeeStationery.createEmployeeStationery();
    }
}
