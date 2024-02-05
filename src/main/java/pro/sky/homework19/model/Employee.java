package pro.sky.homework19.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private  String lastName;
    private double salary;
    private Integer department;
    private final String hashKey;
    public Employee (String firstName, String lastName, double salary, int department) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.hashKey = (firstName + lastName).toLowerCase();
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getHashKey() { return hashKey;}
    public double getSalary() {return salary;}
    public Integer getDepartment() {return department;}
    @Override
    public String toString() {
        return "Сотрудник: " + firstName + " " + lastName + " (зарплата: " + salary + " отдел: " + department + ")";
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(firstName, lastName);
    }
}
