package ru.geekbrains.spring_framework.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartItem {
    private Long productId;
    private String productTitle;
    private int quantity;
    private int price;
    private int pricePerProduct;
}
