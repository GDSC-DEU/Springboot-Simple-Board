package com.gdscdeu.springboot.simpleboard.DTOs;

import com.gdscdeu.springboot.simpleboard.Entites.Posts;
import lombok.Builder;
import lombok.Data;

@Data
public class FindPostsDto {

    String title;

    String content;

}
