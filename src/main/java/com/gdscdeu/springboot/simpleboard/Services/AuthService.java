package com.gdscdeu.springboot.simpleboard.Services;

import com.gdscdeu.springboot.simpleboard.DTOs.AuthDto;
import com.gdscdeu.springboot.simpleboard.Entites.Users;
import com.gdscdeu.springboot.simpleboard.Repositorys.UserRepository;
import com.gdscdeu.springboot.simpleboard.utils.HashGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    public Users AuthenticationUser(AuthDto authDto) {
        String encryptedPassword = HashGenerator.SHA512(authDto.getPassword());
        Users user = userRepository.findByUsernameAndEncryptedPassword(authDto.getUsername(), encryptedPassword);

        return user;
    }

}
