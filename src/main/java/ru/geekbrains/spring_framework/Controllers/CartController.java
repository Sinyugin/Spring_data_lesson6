package ru.geekbrains.spring_framework.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring_framework.models.Cart;
import ru.geekbrains.spring_framework.services.CartService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.addToCart(id);
    }

    @GetMapping
    public Cart getCurrentCart() {
        return cartService.getCurrentCart();
    }

    @GetMapping("/clean")
    public void cleanCart() {
        cartService.crear();
    }

    @GetMapping("/delete/{id}")
    public void deleteProductsById(@PathVariable Long id) {
        cartService.deleteById(id);
    }
}
