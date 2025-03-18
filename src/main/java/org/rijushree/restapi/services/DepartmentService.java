package org.rijushree.restapi.services;

import java.util.List;
import java.util.Optional;

import org.rijushree.restapi.enities.Department;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    List<Department> getAllDepartments();
    Optional<Department> getDepartmentById(Long id);
    Department saveDepartment(Department department);
    void deleteDepartment(Long id);
	Department updateDepartment(Long id, Department departmentDetails);
	
}
