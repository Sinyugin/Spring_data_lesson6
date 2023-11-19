package ru.geekbrains.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.market.entities.User;
import ru.geekbrains.market.services.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @GetMapping
    List<User> findAllUsers (){
        return userService.findAllUsers();
    }
}
