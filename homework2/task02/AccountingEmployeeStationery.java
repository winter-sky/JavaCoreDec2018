package homework2.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class AccountingEmployeeStationery {
    TreeMap<Employee, EmployeeStationery> empStationery = new TreeMap<Employee, EmployeeStationery>();

    public void createAccounting() throws IOException {
        boolean flag = true;
        while (flag) {
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

            empStationery.put(newEmployee, null);

            System.out.println("Enter 1 to add new employee");
            System.out.println("Enter 0 to finish adding");

            if (Integer.parseInt(reader.readLine()) == 1) {
                continue;
            } else {
                flag = false;
            }
        }

        int i = 1;
        for (Map.Entry entry : empStationery.entrySet()) {
            Employee employee = (Employee) entry.getKey();
            employee.setId(i);
            i++;
            System.out.println(employee+" id " + employee.getId());
        }
    }

    public void showEmployeeStationery() throws IOException {
        this.showEmployees();
        System.out.println("Enter employee's id");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String r = reader.readLine();
        for (Map.Entry entrySet : empStationery.entrySet()) {
            Employee e = (Employee) entrySet.getKey();
            if (r.equals(Integer.toString(e.getId()))) {
                System.out.println(entrySet.getValue());
            }
        }

    }

    public void showEmployees() {
        int i = 1;
        for (Map.Entry entry : empStationery.entrySet()) {
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
