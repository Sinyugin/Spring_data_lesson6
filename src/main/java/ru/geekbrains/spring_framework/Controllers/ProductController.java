package ru.geekbrains.spring_framework.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_framework.entities.Product;
import ru.geekbrains.spring_framework.services.ProductServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/app")
public class ProductController {
    private final ProductServices productServices;

    @GetMapping("/products/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productServices.findById(id);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productServices.findAll();
    }

    @PostMapping("/products")
    public void createProduct(@RequestBody Product product) {
        productServices.createProduct(product);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productServices.deleteProductById(id);
    }

}
