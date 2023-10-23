package ru.geekbrains.spring_framework.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_framework.entities.Product;
import ru.geekbrains.spring_framework.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring_framework.models.Cart;

@Service
@RequiredArgsConstructor
public class CartService {
    private final  ProductServices productServices;
    private Cart tempCart;

    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }

    public Cart getCurrentCart() {
        return tempCart;
    }

    public void addToCart(Long productId){
        Product product = productServices.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Продукт с id: " + productId + " не найден"));
        tempCart.add(product);
    }

    public void crear() {
        tempCart.clear();
    }

    public void deleteById(Long productId) {
        tempCart.dellProduct(productId);
    }
}
