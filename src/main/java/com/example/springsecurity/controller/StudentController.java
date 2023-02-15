package com.example.springsecurity.controller;

import com.example.springsecurity.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
//@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService studentService;

//    @GetMapping("/students")
//    public String listStudents(Model model) {
//        model.addAttribute("students", studentService.getAllStudents());
//
//        return "students";
//    }

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
