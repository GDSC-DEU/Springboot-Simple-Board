package com.gdscdeu.springboot.simpleboard.Entites;

import lombok.Builder;
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
    Users userID; // FK

    public Posts(String title, String content, long userID){
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
    }

}
