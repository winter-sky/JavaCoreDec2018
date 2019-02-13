package homework2.task02;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import static homework2.task02.Department.IT;
import static homework2.task02.StationeryType.NOTEBOOK;
import static homework2.task02.StationeryType.PEN;

public class AccountingEmployeeStationery {
    TreeMap<Employee, EmployeeStationery> empStationery = new TreeMap<Employee, EmployeeStationery>();

    public void showEmployees(){
        int i =1;
        for(Map.Entry entry:empStationery.entrySet()){
            System.out.println(i+") "+entry.getKey().toString()+"\n");
            i++;
        }
    }


    public static void main(String[] args) {
        Employee employee = new Employee("Kirill", "Knize", IT);
        EmployeeStationery employeeStationery = new EmployeeStationery();
        employeeStationery.addStationery(300,"SomeBrand", PEN);
        employeeStationery.addStationery(60,"SomeBrand",StationeryType.NOTEBOOK);
        AccountingEmployeeStationery accountingEmployeeStationery = new AccountingEmployeeStationery();
        accountingEmployeeStationery.empStationery.put(employee,employeeStationery);
        employeeStationery.addStationery(50, "AnotherBrand", StationeryType.NOTEBOOK);

        Employee emp = new Employee("Vasya","Ivanov", IT);
        EmployeeStationery employeeStationery1 = new EmployeeStationery();
        employeeStationery1.addStationery(80, "BrandName", PEN);
        accountingEmployeeStationery.empStationery.put(emp,employeeStationery1);

        Employee emp2 = new Employee("Alisa","Taiga", IT);
        EmployeeStationery employeeStationery2 = new EmployeeStationery();
        employeeStationery1.addStationery(700, "BrandName", NOTEBOOK);
        accountingEmployeeStationery.empStationery.put(emp2,employeeStationery2);

//        for(Map.Entry entry:accountingEmployeeStationery.empStationery.entrySet()){
//            System.out.println(entry.getKey().toString());
//            EmployeeStationery e = (EmployeeStationery) entry.getValue();
//            System.out.println(e.employeeStationery);
//        }

        accountingEmployeeStationery.showEmployees();
    }
}
