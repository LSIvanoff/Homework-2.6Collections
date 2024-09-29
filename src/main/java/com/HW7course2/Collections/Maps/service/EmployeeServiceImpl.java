package com.HW7course2.Collections.Maps.service;

import com.HW7course2.Collections.Maps.employee.Employee;
import com.HW7course2.Collections.Maps.exception.EmployeeAlreadyAddedInList;
import com.HW7course2.Collections.Maps.exception.EmployeeNotFoundInList;
import com.HW7course2.Collections.Maps.exception.EmployeeStorageIsFullList;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final int STORAGE_SIZE = 10;

    public Map<String, Employee> employees;

    {
        employees = new HashMap<>(Map.of(

                "Иван Иванов",
                new Employee("Иван", "Иванов"),

                "Семен Горбунков",
                new Employee("Семен", "Горбунков"),

                "Петр Петров",
                new Employee("Петр", "Петров"),

                "Николай Николаев",
                new Employee("Николай", "Николаев"),

                "Федор Федоров",
                new Employee("Федор", "Федоров")
        ));
    }

    @Override


    public Employee add(String name, String lastName) throws EmployeeStorageIsFullList, EmployeeAlreadyAddedInList {

        Employee employee = new Employee(name, lastName);

        if (employees.size() >= STORAGE_SIZE) {


            throw new EmployeeStorageIsFullList("Хранилище заполнено");

        }


        if (employees.containsKey(employee.getFullName())) {

            throw new EmployeeAlreadyAddedInList("Сотрудник уже есть в хранилище");

        }

        employees.put(employee.getFullName(), employee);

        return employee;

    }

    @Override


    public Employee remove(String name, String lastName) throws EmployeeNotFoundInList {

        Employee employee = new Employee(name, lastName);

        if (employees.containsKey(employee.getFullName())) {

            return employees.remove(employee.getFullName());


        }

        throw new EmployeeNotFoundInList("Такого  сотрудника нет в хранилище");

    }


    @Override

    public Employee find(String name, String lastName) throws EmployeeNotFoundInList {

        Employee employee = new Employee(name, lastName);

        if (employees.containsKey(employee.getFullName())) {

            return employees.get(employee.getFullName());

        }

        throw new EmployeeNotFoundInList("Такого  сотрудника нет в хранилище");

    }

    @Override

    public Collection<Employee> getAll() {

        return Collections.unmodifiableCollection(employees.values());
    }

    private String getFullName(String name, String lastName) {
        return name + lastName;
    }

    private void checkExistence(String fullName) {
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFoundInList("Такого сотрудника нет");
        }
    }
}
