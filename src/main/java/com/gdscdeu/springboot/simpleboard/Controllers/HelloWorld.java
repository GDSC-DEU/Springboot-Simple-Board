package com.gdscdeu.springboot.simpleboard.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {

    @ResponseBody
    @GetMapping("/hello")
    String hello() {
        return "Hello, World";
    }

}
