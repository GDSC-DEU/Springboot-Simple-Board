package com.gdscdeu.springboot.simpleboard.Services;

import com.gdscdeu.springboot.simpleboard.DTOs.CreateTestPosts;
import com.gdscdeu.springboot.simpleboard.Entities.TestPosts;
import com.gdscdeu.springboot.simpleboard.Repositories.TestBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestBoardService {

    @Autowired
    TestBoardRepository testBoardRepository;

    public TestPosts create(CreateTestPosts post) {
        TestPosts newPost = new TestPosts(post.getTitle(),  post.getContent(), post.getUserID());

        testBoardRepository.save(newPost);

        return newPost;
    }

}
