package org.rijushree.restapi.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.rijushree.restapi.dao.EmployeeRopository;
import org.rijushree.restapi.enities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    List<Employee> list = new ArrayList<>(Arrays.asList(
        new Employee(1, "Nitesh", "Tester"),
        new Employee(2, "Naveen", "Software Engineer"),
        new Employee(3, "Mahesh", "Team Lead")
    ));
    
    @Autowired
    private EmployeeRopository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

