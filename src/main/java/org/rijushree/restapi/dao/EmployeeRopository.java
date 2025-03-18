package org.rijushree.restapi.dao;

import org.rijushree.restapi.enities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRopository extends JpaRepository<Employee, Long>{

}
