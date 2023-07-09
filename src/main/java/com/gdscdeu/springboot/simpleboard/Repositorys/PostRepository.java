package com.gdscdeu.springboot.simpleboard.Repositorys;

import com.gdscdeu.springboot.simpleboard.Entites.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Posts, Long> {
    List<Posts> findAll();

    void deletePostsById(long id);
}
