package ru.geekbrains.market.convertes;

import org.springframework.stereotype.Component;
import ru.geekbrains.CartItemDto;
import ru.geekbrains.market.models.CartItem;

@Component
public class CartItemConverter {
    public CartItemDto entityToDto(CartItem cartItem){
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setPrice(cartItem.getPrice());
        cartItemDto.setPricePerProduct(cartItem.getPricePerProduct());
        cartItemDto.setQuantity(cartItem.getQuantity());
        cartItemDto.setProductTitle(cartItem.getProductTitle());
        cartItemDto.setProductId(cartItem.getProductId());
        return cartItemDto;
    }
}
