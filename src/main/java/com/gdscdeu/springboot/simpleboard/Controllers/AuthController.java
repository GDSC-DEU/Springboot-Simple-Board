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
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("")
    void AuthenticationUser(
            @RequestBody @Valid AuthDto authDto,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        Users user = authService.AuthenticationUser(authDto);

        if (user == null) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            HttpSession session = request.getSession();

            session.setAttribute("USER_ID", user.getId());
            session.setAttribute("USER_NAME", user.getUsername());
        }
    }

    @DeleteMapping("")
    void SignOut(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            session.invalidate();
        }
    }

    @GetMapping("")
    String CheckAuthentication(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return "FORBIDDEN";
        }

        return "username: " + session.getAttribute("USER_NAME");
    }

}
