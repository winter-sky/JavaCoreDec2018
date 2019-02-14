package homework2.task02;

import java.util.Objects;

import static homework2.task02.Department.UNDEFINED;

public class Employee implements Comparable<Employee>{
    private int id;
    private String firstName;
    private String lastName;
    private Department department=UNDEFINED;

    public Employee(){

    }

    public Employee(String firstName, String lastName, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(int id) {
        for(Department d:Department.values()){
            if (id==d.ordinal()+1)
                department=d;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                department == employee.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, department);
    }

    @Override
    public int compareTo(Employee emp) {
        int lastCmp = lastName.compareTo(emp.lastName);
        return (lastCmp != 0 ? lastCmp : firstName.compareTo(emp.firstName));
    }

    @Override
    public String toString() {
        return lastName +" "+
                firstName +
                ", " + department;
    }
}
