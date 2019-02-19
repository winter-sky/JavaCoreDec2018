package homework2.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The general class for creating and managing of accounting employee stationery.
 */
public class AccountingEmployeeStationery {
    TreeMap<Employee, List<Stationery>> employeeStationeryMap = new TreeMap<Employee, List<Stationery>>();

    /**
     * Method of creating and managing of accounting employee stationery
     *
     * @throws IOException
     */
    public void createAccounting() throws IOException {
        boolean condition = true;
        while (condition) {
            System.out.println("Enter 1 to show list of all employees to show and manage their stationery");
            System.out.println("Enter 2 to add new employee");
            System.out.println("Enter 3 to finish");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            switch (s) {
                case "1":
                    this.showEmployeeStationery();
                    break;
                case "2":
                    this.addEmployee(reader);
                    break;
                case "3":
                    condition = false;
                    break;
                default:
                    System.out.println("Everything was broken");
            }
        }
    }

    /**
     * Adds new entry with employee and stationery
     *
     * @param reader
     * @return
     * @throws IOException
     */
    private void addEmployee(BufferedReader reader) throws IOException {
        Employee newEmployee = new Employee();
        System.out.println("Enter first name of employee");
        newEmployee.setFirstName(reader.readLine());
        System.out.println("Enter the last name of employee");
        newEmployee.setLastName(reader.readLine());
        for (Department d : Department.values()) {
            System.out.println(d.ordinal() + 1 + ") " + d);
        }
        System.out.println("Enter id of department");
        newEmployee.setDepartment(Department.extract(Integer.parseInt(reader.readLine())));
        List<Stationery> employeeStationery = new ArrayList<Stationery>();
        employeeStationeryMap.put(newEmployee, employeeStationery);
        int i = 1;
        for (Map.Entry entry : employeeStationeryMap.entrySet()) {
            Employee employee = (Employee) entry.getKey();
            employee.setId(i);
            i++;
        }
        System.out.println("Enter 1 to add stationery to " + newEmployee.getFirstName());
        System.out.println("Enter 2 to show list of all employees");
        String s = reader.readLine();
        switch (s) {
            case "1":
                boolean flag = true;
                while (flag) {
                    this.addStationery(employeeStationery, reader);
                    System.out.println("Enter 1 to add one more stationery to " + newEmployee.getFirstName());
                    if (reader.readLine().equals("1")) {
                        continue;
                    } else break;
                }
                break;
            case "2":
                this.showEmployeeStationery();
                break;
            default:
                System.out.println("Everything was broken");
        }
    }

    /**
     * Method allows to add new stationery to employee
     *
     * @param employeeStationery
     * @param reader
     * @throws IOException
     */
    private void addStationery(List employeeStationery, BufferedReader reader) throws IOException {
        System.out.println("Enter 1 to add document holder");
        System.out.println("Enter 2 to add marker");
        System.out.println("Enter 3 to add office paper");
        String r = reader.readLine();
        switch (r) {
            case "1":
                employeeStationery.add(this.createStationery(Integer.parseInt(r)));
                break;
            case "2":
                employeeStationery.add(this.createStationery(Integer.parseInt(r)));
                break;
            case "3":
                employeeStationery.add(this.createStationery(Integer.parseInt(r)));
                break;
            default:
                System.out.println("Something goes wrong");
        }
    }

    /**
     * Creates and adds a new stationery to list of stationery
     *
     * @param i
     * @return
     * @throws IOException
     */
    private Stationery createStationery(int i) throws IOException {
        Stationery employeeStationery = new Stationery();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int j = 1;
        switch (i) {
            case 1:
                DocumentHolder documentHolder = new DocumentHolder();
                System.out.println("Choose the color");
                for (Color color : Color.values()) {
                    System.out.println("Enter " + j + " to choose " + color);
                    j++;
                }
                documentHolder.setColor(Color.extractColor(Integer.parseInt(reader.readLine())));
                System.out.println("Enter the price");
                documentHolder.setPrice(Double.parseDouble(reader.readLine()));
                System.out.println("Enter the brand");
                documentHolder.setBrand(reader.readLine());
                System.out.println("Choose the category");
                j = 1;
                for (StationeryCategory stationeryCategory : StationeryCategory.values()) {
                    System.out.println("Enter " + j + " to choose " + stationeryCategory);
                    j++;
                }
                documentHolder.setCategory(StationeryCategory.extractStationeryCategory(Integer.parseInt(reader.readLine())));
                employeeStationery = documentHolder;
                break;
            case 2:
                Marker marker = new Marker();
                System.out.println("Choose marker color");
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
                j = 1;
                for (StationeryCategory stationeryCategory : StationeryCategory.values()) {
                    System.out.println("Enter " + j + " to choose " + stationeryCategory.toString());
                    j++;
                }
                marker.setCategory(StationeryCategory.extractStationeryCategory(Integer.parseInt(reader.readLine())));
                employeeStationery = marker;
                break;
            case 3:
                OfficePaper officePaper = new OfficePaper();
                System.out.println("Enter the amount of sheet");
                officePaper.setAmountOfSheet(Integer.parseInt(reader.readLine()));
                System.out.println("Choose the paper format");
                for (PaperFormat paperFormat : PaperFormat.values()) {
                    System.out.println("Enter " + j + " to choose " + paperFormat);
                    j++;
                }
                officePaper.setPaperFormat(PaperFormat.extractPaperFormat(Integer.parseInt(reader.readLine())));
                System.out.println("Enter the price");
                officePaper.setPrice(Double.parseDouble(reader.readLine()));
                System.out.println("Enter the brand");
                officePaper.setBrand(reader.readLine());
                System.out.println("Choose category");
                j = 1;
                for (StationeryCategory stationeryCategory : StationeryCategory.values()) {
                    System.out.println("Enter " + j + " to choose " + stationeryCategory);
                    j++;
                }
                officePaper.setCategory(StationeryCategory.extractStationeryCategory(Integer.parseInt(reader.readLine())));
                employeeStationery = officePaper;
                break;
            default:
                System.out.println("Something goes wrong");
        }
        return employeeStationery;
    }

    /**
     * Shows list of employees and allows to manage employee stationery
     *
     * @throws IOException
     */
    private void showEmployeeStationery() throws IOException {
        this.showEmployees();
        System.out.println("Enter employee's id to show stationery or add new stationery");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String r = reader.readLine();
        System.out.println("Enter 1 to show stationery");
        System.out.println("Enter 2 to add new stationery");
        String s = reader.readLine();
        switch (s) {
            case "1":
                for (Map.Entry entrySet : employeeStationeryMap.entrySet()) {
                    Employee e = (Employee) entrySet.getKey();
                    if (r.equals(Integer.toString(e.getId()))) {
                        List employeeStationery = (List) entrySet.getValue();
                        for (Object stationery : employeeStationery) {
                            System.out.println(stationery.toString());
                        }
                    }
                }
                break;
            case "2":
                for (Map.Entry entrySet : employeeStationeryMap.entrySet()) {
                    Employee e = (Employee) entrySet.getKey();
                    if (r.equals(Integer.toString(e.getId()))) {
                        List employeeStationery = (List) entrySet.getValue();
                        this.addStationery(employeeStationery, reader);
                    }
                }
                break;
            default:
                System.out.println("Everything was broken");
        }
    }

    /**
     * Shows list of all employees
     */
    private void showEmployees() {
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
