package com.gdscdeu.springboot.simpleboard.Controllers;

import com.gdscdeu.springboot.simpleboard.DTOs.AuthDto;
import com.gdscdeu.springboot.simpleboard.Entites.Users;
import com.gdscdeu.springboot.simpleboard.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@RestController
@RequestMapping
public class AutoController {

    @Autowired
    AuthService authService;

    @PostMapping("") //로그인은 무조건 포스트
    void AuthenticationUser(@RequestBody @Valid AuthDto authDto, HttpServletResponse response, HttpServletRequest request){
        Users user = authService.AuthenticationUser(authDto);

        if(user ==null){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
        else{
            HttpSession session = request.getSession();

            session.setAttribute("User_Id", user.getId());
            session.setAttribute("USER_NAME", user.getUsername());
        }
    }

    @DeleteMapping
    void SignOut(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);

        if(session == null){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }else{
            session.invalidate();
        }
    }
    @GetMapping("")
    String CheckAuthentication(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);

        if(session == null){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return "FORBIDDEN";
        }

        return "username : "+ session.getAttribute("USER_NAME");
    }
}
