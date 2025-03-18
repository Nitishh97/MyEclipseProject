package org.rijushree.restapi.dao;

import java.util.List;

import org.rijushree.restapi.enities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


	@Repository
	public interface StudentRepository extends JpaRepository<Student, Long> {
	    
	    @Query("SELECT s FROM Student s WHERE s.name = :name")
	    List<Student> findByName(@Param("name") String name);
	    
	    @Query("SELECT s FROM Student s WHERE s.age >= :age")
	    List<Student> findByAgeGreaterThanEqual(@Param("age") int age);
	}

	
