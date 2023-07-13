package com.gdscdeu.springboot.simpleboard.Repositorys;

import com.gdscdeu.springboot.simpleboard.Entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUsernameAndEncryptedPassword(String username, String encryptedPassword);

}
