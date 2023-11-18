package ru.geekbrains.market.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.CartDto;
import ru.geekbrains.market.convertes.CartConverter;
import ru.geekbrains.market.services.CartService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
@CrossOrigin("*")
public class CartController {

    private final CartService cartService;
    private final CartConverter cartConverter;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.addToCart(id);
    }

    @GetMapping
    public CartDto getCurrentCart() {
        return cartConverter.entityToDto(cartService.getCurrentCart());
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
