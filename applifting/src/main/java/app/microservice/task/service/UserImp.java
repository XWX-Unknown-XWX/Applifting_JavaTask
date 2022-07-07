package app.microservice.task.service;

import app.microservice.task.exception.NotFoundException;
import app.microservice.task.model.User;
import app.microservice.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImp implements UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        if (id == null) {
            throw new RuntimeException();
        }
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
    }
}
