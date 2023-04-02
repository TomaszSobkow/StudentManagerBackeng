package student.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import student.model.User;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users",
        BeanPropertyRowMapper.newInstance(User.class));
    }

    public User getById(int id){
        return jdbcTemplate.queryForObject("SELECT id, email, password, is_admin FROM users WHERE id =?",
                BeanPropertyRowMapper.newInstance(User.class),id);
    }

    public int save(User newUser) {
        String password = newUser.getPassword();
        if (newUser.getPassword() == null) password = "default";

        return jdbcTemplate.update("INSERT INTO users(email, password, is_admin) VALUES(?,?,?)",
                newUser.getEmail(), password, newUser.isAdmin());
    }

    public void update(User user) {
        jdbcTemplate.update("UPDATE users SET email=?, password=? WHERE id=?",
                user.getEmail(), user.getPassword(), user.getId());
    }

    public int deleteUser(int id){
        return jdbcTemplate.update("DELETE from users WHERE id=?", id);
    }
}