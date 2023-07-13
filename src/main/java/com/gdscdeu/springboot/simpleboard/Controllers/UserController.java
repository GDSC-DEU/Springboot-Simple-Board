package com.gdscdeu.springboot.simpleboard.Controllers;

import com.gdscdeu.springboot.simpleboard.DTOs.CreateUserDto;
import com.gdscdeu.springboot.simpleboard.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")

public class UserController

{
    @Autowired
    UserService userService;

    @PostMapping("")
    void CreateNewUser(@RequestBody CreateUserDto userData){
        userService.CreateNewUser(userData);
    }
}
