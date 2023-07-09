package com.gdscdeu.springboot.simpleboard.Services;

import com.gdscdeu.springboot.simpleboard.DTOs.FindPostsDto;
import com.gdscdeu.springboot.simpleboard.Entites.Posts;
import com.gdscdeu.springboot.simpleboard.Repositorys.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Posts> getAllPosts() {
        return postRepository.findAll();
    }

    public Posts getPost(long postID) {
        return postRepository.findById(postID);
    }

    public List<Posts> findPosts(FindPostsDto filter) {
        return postRepository.findAllByTitleContainingOrContentContaining(filter.getTitle(), filter.getContent());
    }

    public void deletePost(long postID) {
        postRepository.deletePostsById(postID);
    }
}
