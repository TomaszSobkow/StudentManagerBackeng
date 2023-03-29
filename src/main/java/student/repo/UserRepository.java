package student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import student.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}