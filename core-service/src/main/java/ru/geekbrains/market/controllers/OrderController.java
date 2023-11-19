package ru.geekbrains.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.market.entities.User;
import ru.geekbrains.market.services.OrderService;
import ru.geekbrains.market.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@CrossOrigin("*")

public class OrderController {
    private final UserService userService;
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        orderService.createOrder(user);
    }

}

