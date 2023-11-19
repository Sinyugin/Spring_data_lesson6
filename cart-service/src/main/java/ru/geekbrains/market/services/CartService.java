package ru.geekbrains.market.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.ProductDto;
import ru.geekbrains.ResourceNotFoundException;
import ru.geekbrains.market.integrations.ProductServiceIntegration;
import ru.geekbrains.market.models.Cart;


@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductServiceIntegration productServiceIntegration;
    private Cart tempCart;

    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }

    public Cart getCurrentCart() {
        return tempCart;
    }

    public void addToCart(Long productId){
        ProductDto product = productServiceIntegration.getProductById(productId);
        tempCart.add(product);
    }

    public void crear() {
        tempCart.clear();
    }

    public void deleteById(Long productId) {
        tempCart.dellProduct(productId);
    }
}
