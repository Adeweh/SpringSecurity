package com.example.springsecurity.repository;

import com.example.springsecurity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository  extends JpaRepository<Student, Long> {
    Optional <Student> findStudentByEmailAddress(String email);
}
