package com.controller;

import com.StudentRepository;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://192.168.178.50:4200")
@RequestMapping("api/sm")
public class StudentController {

    @Autowired
    private StudentRepository employeeRepository;

    //GetAllEmployees
    @GetMapping("students")
    public List<Student> getAllEmployees(){
        return  employeeRepository.findAll();
    }
}
