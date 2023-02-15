package com.example.springsecurity.service;

import com.example.springsecurity.dtos.StudentRegistrationRequest;
import com.example.springsecurity.dtos.StudentRegistrationResponse;
import com.example.springsecurity.exception.StudentException;
import com.example.springsecurity.model.Student;
import com.example.springsecurity.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;
    private final ModelMapper mapper;
    @Override
    public StudentRegistrationResponse register(StudentRegistrationRequest registrationRequest) throws StudentException {
        Optional<Student> foundStudent = studentRepository.findStudentByEmailAddress(registrationRequest.getEmailAddress());
        if(foundStudent.isPresent()) throw new
                StudentException(String.format("Student %s already in use", registrationRequest.getEmailAddress()));

        Student student = mapper.map(registrationRequest, Student.class);
        student.setFirstName(registrationRequest.getFirstName());
        student.setLastName(registrationRequest.getLastName());
        student.setEmailAddress(registrationRequest.getEmailAddress());
        student.setPassword(registrationRequest.getPassWord());

        studentRepository.save(student);
        return StudentRegistrationResponse.builder()
                .message("Successful")
                .build();
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
