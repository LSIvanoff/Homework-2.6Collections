package com.HW7course2.Collections.Maps.service;

import com.HW7course2.Collections.Maps.employee.Employee;
import com.HW7course2.Collections.Maps.exception.EmployeeAlreadyAddedInList;
import com.HW7course2.Collections.Maps.exception.EmployeeNotFoundInList;
import com.HW7course2.Collections.Maps.exception.EmployeeStorageIsFullList;

import java.util.Collection;
public interface EmployeeService {
    Employee add(String name, String lastName) throws EmployeeStorageIsFullList, EmployeeAlreadyAddedInList;

    Employee remove(String name, String lastName) throws EmployeeNotFoundInList;

    Employee find(String name, String lastName) throws EmployeeNotFoundInList;

    Collection<Employee> getAll();
}
