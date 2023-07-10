package com.gdscdeu.springboot.simpleboard.Controllers;

import com.gdscdeu.springboot.simpleboard.DTOs.FindPostsDto;
import com.gdscdeu.springboot.simpleboard.Entites.Posts;
import com.gdscdeu.springboot.simpleboard.Services.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("api/{id}")
public class UpdateController {
        @Autowired
        UpdateService updateService;

        @PatchMapping  ("")
        public Posts update(@PathVariable long id, @RequestBody FindPostsDto requestDto) throws SQLException {
            //return updateService.update(id, requestDto);
            return updateService.update(id, requestDto); //수정 Posts 값 반환
        }

    }
