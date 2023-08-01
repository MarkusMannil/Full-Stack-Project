package com.example.markus_00.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class for debugging
 */
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User0> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void RegisterNewUser(@RequestBody User0 user){
        userService.addNewUser(user);
    }
}
