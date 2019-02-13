package homework2.task02;

import java.util.Map;
import java.util.TreeMap;

import static homework2.task02.Department.IT;
import static homework2.task02.StationeryType.PEN;

public class AccountingEmployeeStationery {
    TreeMap<Employee, EmployeeStationery> empStationery = new TreeMap<Employee, EmployeeStationery>();

    public AccountingEmployeeStationery(Employee emp, EmployeeStationery employeeStationery) {
        empStationery.put(emp, employeeStationery);
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Ivan", "Ivanov", IT);
        EmployeeStationery employeeStationery = new EmployeeStationery();
        employeeStationery.addStationery(300,"SomeBrand", PEN);
        employeeStationery.addStationery(60,"SomeBrand",StationeryType.NOTEBOOK);
        AccountingEmployeeStationery accountingEmployeeStationery = new AccountingEmployeeStationery(employee,
                employeeStationery);
        employeeStationery.addStationery(50, "AnotherBrand", StationeryType.NOTEBOOK);

        Employee emp = new Employee("Vasya","Ivanov", IT);
        EmployeeStationery employeeStationery1 = new EmployeeStationery();
        employeeStationery1.addStationery(80, "BrandName", PEN);
        accountingEmployeeStationery.empStationery.put(emp,employeeStationery1);

        for(Map.Entry entry:accountingEmployeeStationery.empStationery.entrySet()){
            System.out.println(entry.getKey().toString());
            EmployeeStationery e = (EmployeeStationery) entry.getValue();
            System.out.println(e.employeeStationery);
        }


    }
}
