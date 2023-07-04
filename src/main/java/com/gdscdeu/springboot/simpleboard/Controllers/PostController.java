package com.gdscdeu.springboot.simpleboard.Controllers;

import com.gdscdeu.springboot.simpleboard.Entites.Posts;
import com.gdscdeu.springboot.simpleboard.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("")
    List<Posts> readAllPost(){
        return postService.postRead();
    }

}


