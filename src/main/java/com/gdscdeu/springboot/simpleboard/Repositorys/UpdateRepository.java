package com.gdscdeu.springboot.simpleboard.Repositorys;

import com.gdscdeu.springboot.simpleboard.Entites.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UpdateRepository extends JpaRepository<Posts, Long> {
    Optional<Posts> findById (Long id);
}
