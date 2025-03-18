package org.rijushree.restapi.services;

import java.util.List;
import java.util.Optional;

import org.rijushree.restapi.dao.StudentRepository;
import org.rijushree.restapi.enities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @PostConstruct
    public void initStudents() {
        if (studentRepository.count() == 0) { // Only add data if DB is empty
            Student student1 = new Student("Alice brown", "brown@example.com", 21);
            Student student2 = new Student("Bob hook", "hook@example.com", 22);
            Student student3 = new Student("Charlie Rob", "Rob@example.com", 23);
            
            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);
        }
    }
    
    
    
    
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    
    @Override
    public Student updateStudent(Long id, Student studentDetails) {
        return studentRepository.findById(id).map(student -> {
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setAge(studentDetails.getAge());
            return studentRepository.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }
    
    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}








