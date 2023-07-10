package com.gdscdeu.springboot.simpleboard.Services;

import com.gdscdeu.springboot.simpleboard.DTOs.FindPostsDto;
import com.gdscdeu.springboot.simpleboard.DTOs.UpdatePostsDto;
import com.gdscdeu.springboot.simpleboard.Entites.Posts;
import com.gdscdeu.springboot.simpleboard.Repositorys.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    @Autowired //의존성 주입
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

    public Posts update(long id, UpdatePostsDto requestDto) {
        Posts entity = postRepository.findById(id); // id에 해당하는 게시글을 검색

        if (entity == null) {
            throw new IllegalArgumentException();
        }

        if (requestDto.getTitle() != null) {
            entity.setTitle(requestDto.getTitle());
        }

        if (requestDto.getContent() != null) {
            entity.setContent(requestDto.getContent());
        }

        return postRepository.save(entity);
    }

    @Transactional
    public void deletePost(long postID) {
        postRepository.deletePostsById(postID);
    }
}
