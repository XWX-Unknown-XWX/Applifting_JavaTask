package app.microservice.task.service;

import app.microservice.task.model.User;

public interface UserService {
    User findById(Long id);
}
