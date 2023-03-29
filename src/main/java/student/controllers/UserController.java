package student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    //Find by User ID
    @GetMapping("{id}")
    public User getByID(@PathVariable("id")int  id){
        return userRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody User user){
        return userRepository.save(user);
    }

}
