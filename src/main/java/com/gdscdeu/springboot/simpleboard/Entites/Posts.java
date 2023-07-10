package com.gdscdeu.springboot.simpleboard.Entites;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotNull
    String title;

    @NotNull
    String content;

    @CreationTimestamp
    @NotNull
    Date createdAt;

    @NotNull
    long userID;


    @Builder
    public Posts(long id, String title, String content,  Date createdAt,long userID ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.userID = userID;
    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
