package app.microservice.task.controller;

import app.microservice.task.dto.DTOMapper;
import app.microservice.task.dto.UserDTO;
import app.microservice.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    private final DTOMapper mapper;

    @Autowired
    public UserController(UserService userService, DTOMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return mapper.userToDTO(userService.findById(id));
    }
}
