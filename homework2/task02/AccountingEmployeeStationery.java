package homework2.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class AccountingEmployeeStationery {
    TreeMap<Employee, EmployeeStationery> employeeStationeryMap = new TreeMap<Employee, EmployeeStationery>();

    public void createAccounting() throws IOException {
        if (employeeStationeryMap.isEmpty()) {
            Employee newEmployee = new Employee();
            System.out.println("Enter first name of employee");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            newEmployee.setFirstName(reader.readLine());
            System.out.println("Enter the last name of employee");
            newEmployee.setLastName(reader.readLine());
            for (Department d : Department.values()) {
                System.out.println(d.ordinal() + 1 + ") " + d);
            }
            System.out.println("Enter id of department");
            newEmployee.setDepartment(Department.extract(Integer.parseInt(reader.readLine())));

            System.out.println("Enter 1 to add document holder");
            System.out.println("Enter 2 to add marker");
            System.out.println("Enter 3 to add office paper");

            EmployeeStationery newEmployeeStationery = new EmployeeStationery();
            String r = reader.readLine();
            switch (r) {
                case "1":
                    newEmployeeStationery = this.createStationery(Integer.parseInt(r));
                    break;
                case "2":
                    newEmployeeStationery = this.createStationery(Integer.parseInt(r));
                    break;
                case "3":
                    System.out.println("pressed 3");
                    break;
                default:
                    System.out.println("Something goes wrong");
            }
            employeeStationeryMap.put(newEmployee, newEmployeeStationery);
        } else {
            this.showEmployees();
        }
        int i = 1;
        for (Map.Entry entry : employeeStationeryMap.entrySet()) {
            Employee employee = (Employee) entry.getKey();
            employee.setId(i);
            i++;
            System.out.println(employee + " id " + employee.getId() + "\n");
            EmployeeStationery employeeStationery = (EmployeeStationery) entry.getValue();
            for (Stationery stationery : employeeStationery.employeeStationery) {
                System.out.println(stationery.brand + " " + stationery.price + " " + stationery.category);
            }
        }
    }

    public EmployeeStationery createStationery(int i) throws IOException {
        EmployeeStationery employeeStationery = new EmployeeStationery();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        switch (i) {
            case 1:
                DocumentHolder documentHolder = new DocumentHolder();
                System.out.println("Choose the color");
                int n = 1;
                for (Color color : Color.values()) {
                    System.out.println("Enter " + n + " to choose " + color);
                    n++;
                }
                documentHolder.setColor(Color.extractColor(Integer.parseInt(reader.readLine())));
                System.out.println("Enter the price");
                documentHolder.setPrice(Double.parseDouble(reader.readLine()));
                System.out.println("Enter the brand");
                documentHolder.setBrand(reader.readLine());
                System.out.println("Choose the category");
                int m = 1;
                for (StationeryCategory stationeryCategory : StationeryCategory.values()) {
                    System.out.println("Enter " + m + " to choose " + stationeryCategory);
                    m++;
                }
                documentHolder.setCategory(StationeryCategory.extractStationeryCategory(Integer.parseInt(reader.readLine())));
                employeeStationery.employeeStationery.add(documentHolder);
                break;
            case 2:
                Marker marker = new Marker();
                System.out.println("Choose marker color");
                int j = 1;
                for (Color color : Color.values()) {
                    System.out.println("enter " + j + " to choose " + color.toString());
                    j++;
                }
                marker.setColor(Color.extractColor(Integer.parseInt(reader.readLine())));
                System.out.println("Enter the price");
                marker.setPrice(Double.parseDouble(reader.readLine()));
                System.out.println("Enter the brand");
                marker.setBrand(reader.readLine());
                System.out.println("Choose category");
                int k = 1;
                for (StationeryCategory stationeryCategory : StationeryCategory.values()) {
                    System.out.println("Enter " + k + " to choose " + stationeryCategory.toString());
                    k++;
                }
                marker.setCategory(StationeryCategory.extractStationeryCategory(Integer.parseInt(reader.readLine())));
                employeeStationery.employeeStationery.add(marker);
                break;
            default:
                System.out.println("Something goes wrong");

        }
        return employeeStationery;
    }

    public void showEmployeeStationery() throws IOException {
        this.showEmployees();
        System.out.println("Enter employee's id");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String r = reader.readLine();
        for (Map.Entry entrySet : employeeStationeryMap.entrySet()) {
            Employee e = (Employee) entrySet.getKey();
            if (r.equals(Integer.toString(e.getId()))) {
                System.out.println(entrySet.getValue());
            }
        }
    }

    public void showEmployees() {
        int i = 1;
        for (Map.Entry entry : employeeStationeryMap.entrySet()) {
            System.out.println(i + ") " + entry.getKey().toString() + "\n");
            i++;
        }
    }

    public static void main(String[] args) {
        AccountingEmployeeStationery accountingEmployeeStationery = new AccountingEmployeeStationery();
        try {
            accountingEmployeeStationery.createAccounting();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
