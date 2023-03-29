package student.controller;

import student.exception.ResourceNotFoundException;
import student.StudentRepository;
import student.model.Student;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/sm")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //GetAllEmployees
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return  studentRepository.findAll();
    }

    //Add new Student
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student newStudent){
        return studentRepository.save(newStudent);
    }

    //get student by ID rest Api
    @GetMapping("/students/{id}")
    public ResponseEntity< Student > getStudentById(@PathVariable Long id){
        Student student = studentRepository.findById(id).orElseThrow(
            ()->new ResourceNotFoundException("Student not exists with id" + id) );
        return ResponseEntity.ok(student);
    }

    //Update student REST API
    @PutMapping("students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails){
        Student student = studentRepository.findById(id).orElseThrow(
            ()->new ResourceNotFoundException("Student not exists with id" + id) );
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setCounty(studentDetails.getCounty());
        student.setTown(studentDetails.getTown());
        student.setAddress(studentDetails.getAddress());
        student.setPhone(studentDetails.getPhone());
        student.setEmail(studentDetails.getEmail());

        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    //Delete Student
    @DeleteMapping("students/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id){
        Student student = studentRepository.findById(id)
            .orElseThrow( ()-> new ResourceNotFoundException("Student not exists with id " + id));

        studentRepository.delete(student);
        Map<String, Boolean>response = new HashMap<>();
        response.put("Deleted ", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
