package com.gdscdeu.springboot.simpleboard.DTOs;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreatePostDTO {
    @NotEmpty
    String title;

    @NotEmpty
    String content;

    @NotNull
    long userID;
}
