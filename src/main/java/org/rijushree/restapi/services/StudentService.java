package org.rijushree.restapi.services;

import java.util.List;
import java.util.Optional;

import org.rijushree.restapi.enities.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student saveStudent(Student student);
    Student updateStudent(Long id, Student studentDetails);
    void deleteStudent(Long id);
}
