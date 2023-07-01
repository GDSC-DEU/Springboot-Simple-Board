package com.gdscdeu.springboot.simpleboard.Entities;

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
public class TestPosts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @CreationTimestamp
    @NotNull
    Date createdAt;

    @NotNull
    String title;

    @NotNull
    String content;

    @NotNull
    long userID;

    public TestPosts(String title, String content, long userID) {
        this.title = title;
        this.content = content;
        this.userID = userID;
        this.createdAt = new Date();
    }

}
