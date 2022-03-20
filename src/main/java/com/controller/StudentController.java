package com.controller;

import com.StudentRepository;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/sm")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    //GetAllEmployees
    @GetMapping("/students")
    public List<Student> getAllEmployees(){
        return  studentRepository.findAll();

    }

    //Add new Student
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student newStudent){
        return studentRepository.save(newStudent);

    }
}
