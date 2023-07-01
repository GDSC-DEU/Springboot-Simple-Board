package com.gdscdeu.springboot.simpleboard.Controllers;

import com.gdscdeu.springboot.simpleboard.DTOs.CreateTestPosts;
import com.gdscdeu.springboot.simpleboard.Services.TestBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/post")
public class TestBoardController {

    @Autowired
    TestBoardService testBoardService;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    void createPost(@RequestBody @Valid CreateTestPosts post) {
        testBoardService.create(post);
    }

//    String readPost() {}
//
//    void updatePost() {}
//
//    void deletePost() {}

}
