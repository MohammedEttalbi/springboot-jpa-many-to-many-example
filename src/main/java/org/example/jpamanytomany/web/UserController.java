package org.example.jpamanytomany.web;

import org.example.jpamanytomany.entities.User;
import org.example.jpamanytomany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    @GetMapping({"/users/{username}"})
    public User user(@PathVariable String username) {
        User user = this.userService.findUserByUsername(username);
        return user;
    }
}