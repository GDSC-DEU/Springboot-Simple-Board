package com.gdscdeu.springboot.simpleboard.DTOs;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AuthDto {

    @NotNull
    String username;

    @NotNull
    String password;

}
