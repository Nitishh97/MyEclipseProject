package org.rijushree.restapi.controller;

import java.util.List;
import java.util.Optional;
import org.rijushree.restapi.dao.StudentRepository;
import org.rijushree.restapi.enities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id);
    }
    
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
    
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentRepository.findById(id).map(student -> {
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setAge(studentDetails.getAge());
            return studentRepository.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }
    
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}
