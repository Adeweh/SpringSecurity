package com.example.springsecurity.service;

import com.example.springsecurity.dtos.StudentRegistrationRequest;
import com.example.springsecurity.dtos.StudentRegistrationResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;
    private StudentRegistrationRequest registrationRequest;
    private StudentRegistrationRequest registrationRequest2;
    private StudentRegistrationRequest registrationRequest3;
    private StudentRegistrationResponse registrationResponse;


    @BeforeEach
    void setUp() {
        registrationRequest = StudentRegistrationRequest.builder()
                .firstName("Dee")
                .lastName("Ade")
                .passWord("Dee12345")
                .emailAddress("Dee@email.com")
                .build();

        registrationRequest2 = StudentRegistrationRequest.builder()
                .firstName("Joe")
                .lastName("Snow")
                .passWord("Joe12345")
                .emailAddress("Joe@email.com")
                .build();

        registrationRequest3 = StudentRegistrationRequest.builder()
                .firstName("Love")
                .lastName("Moon")
                .passWord("Love12345")
                .emailAddress("Love@email.com")
                .build();

        registrationResponse = studentService.register(registrationRequest);
        registrationResponse = studentService.register(registrationRequest2);
        registrationResponse = studentService.register(registrationRequest3);


    }
    @AfterEach
    void tearDown() {
        studentService.deleteAll();
    }
    @Test
    void registerStudentTest() {
        assertThat(registrationResponse).isNotNull();
        assertEquals("Successful", registrationResponse.getMessage());
        assertEquals("Dee", registrationRequest.getFirstName());
        assertEquals("Snow", registrationRequest2.getLastName());
        assertEquals("Love@email.com", registrationRequest3.getEmailAddress());
    }
    @Test
    void getAllStudentTest() {

    }
}