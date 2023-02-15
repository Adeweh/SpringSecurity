package com.example.springsecurity.service;

import com.example.springsecurity.dtos.StudentRegistrationRequest;
import com.example.springsecurity.dtos.StudentRegistrationResponse;
import com.example.springsecurity.exception.StudentException;
import com.example.springsecurity.model.Student;

import java.util.List;

public interface StudentService {
    StudentRegistrationResponse register(StudentRegistrationRequest registrationRequest) throws StudentException;

    void deleteAll();

    List<Student> getAllStudents();

}
