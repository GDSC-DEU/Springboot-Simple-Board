package com.gdscdeu.springboot.simpleboard.Services;

import com.gdscdeu.springboot.simpleboard.Entites.TestPosts;
import com.gdscdeu.springboot.simpleboard.Repositorys.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<TestPosts> postRead(){
        return postRepository.findAll();
    }
}
