package com.example.LibraryManagementSystemSpring.repository;


import com.example.LibraryManagementSystemSpring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByMob(String mob);
    Student findByEmailId(String emailId);
}
