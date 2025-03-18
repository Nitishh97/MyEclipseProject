package org.rijushree.restapi.services;

import java.util.List;
import java.util.Optional;
import org.rijushree.restapi.dao.DepartmentRepository;
import org.rijushree.restapi.enities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;


@Service
public class DepartnmentServiceImpl implements DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @PostConstruct
    public void initDepartments() {
        if (departmentRepository.count() == 0) { // Only add data if DB is empty
            Department dept1 = new Department("Finance", "Responsible for budgeting and accounts");
            Department dept2 = new Department("IT", "Manages technology and infrastructure");
            Department dept3 = new Department("HR", "Handles recruitment and employee relations");

            departmentRepository.saveAll(List.of(dept1, dept2, dept3));
        }
    }
    
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    
    @Override
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }
    
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    
    @Override
    public Department updateDepartment(Long id, Department departmentDetails) {
        return departmentRepository.findById(id).map(department -> {
            department.setName(departmentDetails.getName());
            department.setDescription(departmentDetails.getDescription());
            return departmentRepository.save(department);
        }).orElseThrow(() -> new RuntimeException("Department not found"));
    }
    
    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}

