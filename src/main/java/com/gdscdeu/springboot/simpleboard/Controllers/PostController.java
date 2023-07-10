package com.gdscdeu.springboot.simpleboard.Controllers;

import com.gdscdeu.springboot.simpleboard.DTOs.CreatePostDTO;
import com.gdscdeu.springboot.simpleboard.DTOs.FindPostsDto;
import com.gdscdeu.springboot.simpleboard.DTOs.UpdatePostsDto;
import com.gdscdeu.springboot.simpleboard.Entites.Posts;
import com.gdscdeu.springboot.simpleboard.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
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

    @PostMapping("")
    void createPost(@RequestBody @Valid CreatePostDTO createDTO){
        postService.create(createDTO);
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


    @PatchMapping("/{id}")
    public Posts update(@PathVariable long id, @RequestBody UpdatePostsDto requestDto, HttpServletResponse response) {
        try {
            return postService.update(id, requestDto); //수정 Posts 값 반환
        } catch (IllegalArgumentException exception) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
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
