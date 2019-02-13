package homework2.task02;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
    private String firstName;
    private String lastName;
    private Department department;

    public Employee(String firstName, String lastName, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                department == employee.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, department);
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
