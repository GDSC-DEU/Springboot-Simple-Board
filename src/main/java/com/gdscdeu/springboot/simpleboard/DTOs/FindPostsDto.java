package com.gdscdeu.springboot.simpleboard.DTOs;

import com.gdscdeu.springboot.simpleboard.Entites.Posts;
import lombok.Builder;
import lombok.Data;

@Data
public class FindPostsDto {

    String title;
    String content;

    public FindPostsDto( String title, String content, String originalTitle, String originalContent) {

        this.title = title;
        this.content = content;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }



}
