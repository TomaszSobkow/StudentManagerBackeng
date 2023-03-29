package student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import student.model.Student;
import student.model.User;
import student.repo.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    //getAllUsers
    @GetMapping("")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping("")
    public User addUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

}
