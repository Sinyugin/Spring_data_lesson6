package ru.geekbrains.spring_framework.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_framework.converters.ProductConverter;
import ru.geekbrains.spring_framework.dtos.ProductDto;
import ru.geekbrains.spring_framework.entities.Product;
import ru.geekbrains.spring_framework.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring_framework.services.ProductServices;
import ru.geekbrains.spring_framework.validators.ProductValidator;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductServices productServices;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        Product product = productServices.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        return productConverter.entityToDto(product);
    }

    @GetMapping
    public Page<ProductDto> getAllProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice,
            @RequestParam(name = "title_part", required = false) String titlePart) {
        if (page < 1) {
            page = 1;
        }
        return productServices.find(minPrice, maxPrice,titlePart,page).map(
                p -> productConverter.entityToDto(p)
        );
    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productConverter.dtoToEntity(productDto);
        product = productServices.save(product);
        return productConverter.entityToDto(product);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        productValidator.validate(productDto);
        Product product = productServices.update(productDto);
        return productConverter.entityToDto(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productServices.deleteProductById(id);
    }

}
