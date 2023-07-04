package com.gdscdeu.springboot.simpleboard.Repositorys;

import com.gdscdeu.springboot.simpleboard.Entites.TestPosts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<TestPosts, Long> {
    List<TestPosts> findAll();
}
