package com.project.Tasks.Controller;

import com.project.Tasks.Domain.view.UserRequest;
import com.project.Tasks.Services.UserService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/v1/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    //create user -> sign-up
    @PostMapping("/create")
    public void createUser(@NotNull @RequestBody final UserRequest userRequest){
        userService.createUser(userRequest);
    }

    //login
    @GetMapping("login")
    public Boolean loginUser(@NotNull @RequestBody final UserRequest userRequest){
        return userService.loginUser(userRequest);
    }
}
