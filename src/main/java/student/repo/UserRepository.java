package student.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import student.model.User;

import java.util.List;
@CrossOrigin
@Repository
public class UserRepository {

    private  String isAdmin;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM user",
        BeanPropertyRowMapper.newInstance(User.class));
    }

    public User getById(int id){
        return jdbcTemplate.queryForObject("SELECT id, login, password, is_admin FROM user WHERE id =?",
                BeanPropertyRowMapper.newInstance(User.class),id);
    }

    public int save(User newUser) {
        isAdmin = newUser.getIsAdmin();
        if (newUser.getIsAdmin().isEmpty()) isAdmin = "No";

        return jdbcTemplate.update("INSERT INTO user(login, password, is_admin) VALUES(?,?,?)",
                newUser.getLogin(), newUser.getPassword(), isAdmin);
    }

    public void update(User user) {
        isAdmin = user.getIsAdmin();
        if (user.getIsAdmin().isEmpty()) isAdmin = "No";
        jdbcTemplate.update("UPDATE user SET login=?, password=? , is_admin=? WHERE id=?",
                user.getLogin(), user.getPassword(), isAdmin,user.getId());
    }

    public int deleteUser(int id){
        return jdbcTemplate.update("DELETE from user WHERE id=?", id);
    }
}