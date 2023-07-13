package com.gdscdeu.springboot.simpleboard.Entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotNull
    @Column(unique = true)
    String username;

    @NotNull
    String encryptedPassword; // SHA512

    @OneToMany
    List<Posts> posts = new ArrayList<Posts>();

    public Users(String username, String encryptedPassword) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

}