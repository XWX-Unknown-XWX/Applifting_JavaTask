package app.microservice.task.repository;

import app.microservice.task.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findById(int id);
}
