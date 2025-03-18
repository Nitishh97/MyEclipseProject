package org.rijushree.restapi.services;

import java.util.List;
import java.util.Optional;

import org.rijushree.restapi.enities.Employee;
import org.springframework.stereotype.Service;
@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long id);
}