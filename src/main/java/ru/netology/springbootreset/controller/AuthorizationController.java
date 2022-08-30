package ru.netology.springbootreset.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springbootreset.authorities.Authorities;
import ru.netology.springbootreset.service.AuthorizationService;

import java.util.List;

@AllArgsConstructor
@RestController
public class AuthorizationController {

    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAutorities(@RequestParam("user") String user,
                                           @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}