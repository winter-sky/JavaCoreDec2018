package homework2.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

import static homework2.task02.Department.IT;
import static homework2.task02.StationeryType.NOTEBOOK;
import static homework2.task02.StationeryType.PEN;

public class AccountingEmployeeStationery {
    TreeMap<Employee, EmployeeStationery> empStationery = new TreeMap<Employee, EmployeeStationery>();

    public void createAccounting() throws IOException{
        Employee newEmployee = new Employee();
        System.out.println("Enter first name of employee");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        newEmployee.setFirstName(reader.readLine());
        System.out.println("Enter the last name of employee");
        newEmployee.setLastName(reader.readLine());
        for(Department d: Department.values()){
            System.out.println(d.ordinal()+1+") "+d);
        }
        System.out.println("Enter id of department");
        newEmployee.setDepartment(Integer.parseInt(reader.readLine()));
        System.out.println(newEmployee);
    }

    public void showEmployeeStationery() throws IOException {
        this.showEmployees();
        System.out.println("Enter employee's id");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String r = reader.readLine();
            for(Map.Entry entrySet:empStationery.entrySet()){
                Employee e = (Employee) entrySet.getKey();
                if(r.equals(Integer.toString(e.getId()))){
                    System.out.println(entrySet.getValue());
                }
            }

    }

    public void showEmployees(){
        int i =1;
        for(Map.Entry entry:empStationery.entrySet()){
            System.out.println(i+") "+entry.getKey().toString()+"\n");
            i++;
        }
    }


    public static void main(String[] args) {
//        Employee employee = new Employee("Kirill", "Romanov", IT);
//        employee.setId(1);
//        EmployeeStationery employeeStationery = new EmployeeStationery();
//        employeeStationery.addStationery(300,"SomeBrand", PEN);
//        employeeStationery.addStationery(60,"SomeBrand",StationeryType.NOTEBOOK);
        AccountingEmployeeStationery accountingEmployeeStationery = new AccountingEmployeeStationery();
//        accountingEmployeeStationery.empStationery.put(employee,employeeStationery);
//        employeeStationery.addStationery(50, "AnotherBrand", StationeryType.NOTEBOOK);
//
//        Employee emp = new Employee("Vasya","Ivanov", IT);
//        EmployeeStationery employeeStationery1 = new EmployeeStationery();
//        employeeStationery1.addStationery(80, "BrandName", PEN);
//        accountingEmployeeStationery.empStationery.put(emp,employeeStationery1);
//
//        Employee emp2 = new Employee("Alisa","Taiga", IT);
//        EmployeeStationery employeeStationery2 = new EmployeeStationery();
//        employeeStationery1.addStationery(700, "BrandName", NOTEBOOK);
//        accountingEmployeeStationery.empStationery.put(emp2,employeeStationery2);

//        for(Map.Entry entry:accountingEmployeeStationery.empStationery.entrySet()){
//            System.out.println(entry.getKey().toString());
//            EmployeeStationery e = (EmployeeStationery) entry.getValue();
//            System.out.println(e.employeeStationery);
//        }

//        accountingEmployeeStationery.showEmployees();
//        try {
//            accountingEmployeeStationery.showEmployeeStationery();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            accountingEmployeeStationery.createAccounting();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
