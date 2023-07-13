package com.gdscdeu.springboot.simpleboard.Entites;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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
    @ManyToOne
    Users user; // FK

    public Posts(String title, String content, Users user){
        this.title = title;
        this.content = content;
        this.user = user;
        this.createdAt = new Date();
    }

}
