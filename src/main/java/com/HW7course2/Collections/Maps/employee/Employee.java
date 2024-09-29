package com.HW7course2.Collections.Maps.employee;

import java.util.Objects;

public class Employee {

    private final String name;
    private final String lastName;

    public Employee(String name, String lastName) {

        this.name = name;

        this.lastName = lastName;

    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return name + "  " + lastName + "  ";
    }


    @Override

    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getName(), employee.getName()) && Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastName());

    }
}
