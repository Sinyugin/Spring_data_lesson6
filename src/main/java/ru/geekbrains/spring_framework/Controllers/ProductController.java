package ru.geekbrains.spring_framework.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_framework.dtos.ProductDto;
import ru.geekbrains.spring_framework.entities.Product;
import ru.geekbrains.spring_framework.services.ProductServices;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductServices productServices;

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productServices.findById(id);
    }

    @GetMapping
    public Page<ProductDto> getAllProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice,
            @RequestParam(name = "title_part", required = false) String titlePart) {
        if (page < 1)
            page = 1;
        return productServices.find(minPrice, maxPrice,titlePart,page).map(
                p -> new ProductDto(p)
        );
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productServices.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productServices.deleteProductById(id);
    }

}
