package ru.geekbrains.spring_framework.converters;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring_framework.dtos.ProductDto;
import ru.geekbrains.spring_framework.entities.Product;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto){
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }
}
