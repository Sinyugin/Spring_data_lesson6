package ru.geekbrains.spring_framework.dtos;

import lombok.Data;
import ru.geekbrains.spring_framework.entities.Product;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private int price;

    public ProductDto(Product product){
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }

}
