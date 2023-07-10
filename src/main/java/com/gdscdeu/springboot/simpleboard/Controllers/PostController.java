package com.gdscdeu.springboot.simpleboard.Controllers;

import com.gdscdeu.springboot.simpleboard.DTOs.CreatePostDTO;
import com.gdscdeu.springboot.simpleboard.DTOs.FindPostsDto;
import com.gdscdeu.springboot.simpleboard.Entites.Posts;
import com.gdscdeu.springboot.simpleboard.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("")
    List<Posts> readAllPost() {
        return postService.getAllPosts();
    }

    @PostMapping("/create")
    void createPost(@RequestBody @Valid CreatePostDTO createDTO){
        postService.create(createDTO);
    }

}
    @GetMapping("/{postID}")
    Posts readPost(@PathVariable long postID, HttpServletResponse response) {
        Posts post = postService.getPost(postID);

        if (post == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        return post;
    }

    @PostMapping("/find")
    List<Posts> findPosts(@RequestBody FindPostsDto filter) {
        return postService.findPosts(filter);
    }
    
    @DeleteMapping("/{postID}")
    void deletePost(@PathVariable long postID, HttpServletResponse response) {
        Posts post = postService.getPost(postID);

        if (post == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        postService.deletePost(postID);
    }

}
