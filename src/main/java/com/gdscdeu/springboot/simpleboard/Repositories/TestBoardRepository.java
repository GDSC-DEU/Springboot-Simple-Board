package com.gdscdeu.springboot.simpleboard.Repositories;

import com.gdscdeu.springboot.simpleboard.Entities.TestPosts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestBoardRepository extends JpaRepository<TestPosts, Long> {
}
