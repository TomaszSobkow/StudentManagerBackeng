package student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import student.model.User;
import student.repo.UserRepository;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public List<User> getAll(){
        return userRepository.findAll();
    }


    @GetMapping("ssl")
    public String getSSLUsers(){
        return "SSL Version USER Controller";
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

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody User userToUpdate){
        User user = userRepository.getById(id);
        if(user != null){
            user.setLogin(userToUpdate.getLogin());
            user.setPassword(userToUpdate.getPassword());
            user.setIsAdmin(userToUpdate.getIsAdmin());
            userRepository.update(user);
            return 1;
        }else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return userRepository.deleteUser(id);
    }
}
