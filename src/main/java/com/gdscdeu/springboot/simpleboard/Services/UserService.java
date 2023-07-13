package com.gdscdeu.springboot.simpleboard.Services;

import com.gdscdeu.springboot.simpleboard.DTOs.CreateUserDto;
import com.gdscdeu.springboot.simpleboard.Entites.Users;
import com.gdscdeu.springboot.simpleboard.Repositorys.UserRepository;
import com.gdscdeu.springboot.simpleboard.utils.HashGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public Users CreateNewUser(CreateUserDto userData){
        String encryptedPasssword = HashGenerator.SHA512(userData.getPassword());
        Users newUser = new Users(userData.getUsername(), encryptedPasssword);

        return userRepository.save(newUser);

    }

}
