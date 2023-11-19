package ru.geekbrains.market.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.CartDto;
import ru.geekbrains.CartItemDto;
import ru.geekbrains.ResourceNotFoundException;
import ru.geekbrains.market.entities.Order;
import ru.geekbrains.market.entities.OrderItem;
import ru.geekbrains.market.entities.User;
import ru.geekbrains.market.integrations.CartServiceIntegration;
import ru.geekbrains.market.repositories.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductServices productServices;
    private final OrderRepository orderRepository;
    private final CartServiceIntegration cartServiceIntegration;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public void createOrder(User user) {
        CartDto cartDto = cartServiceIntegration.getCurrentCart().orElseThrow(() -> new ResourceNotFoundException("Карзина не найдена"));

//        cartDto = new CartDto();
//        cartDto.setTotalPrice(100);
//        CartItemDto cartItemDto = new CartItemDto();
//        cartItemDto.setProductId(1L);
//        cartItemDto.setQuantity(1);
//        cartItemDto.setPricePerProduct(25);
//        cartItemDto.setPrice(25);
//        cartItemDto.setProductTitle("Bread");
//        cartDto.setItems(List.of(
//                cartItemDto
//        ));

        Order order = new Order();
        order.setUser(user);
        order.setTotalPrice(cartDto.getTotalPrice());
        order.setItems(cartDto.getItems().stream().map(
                cartItem -> new OrderItem(
                        productServices.findById(cartItem.getProductId()).get(),
                        order,
                        cartItem.getQuantity(),
                        cartItem.getPricePerProduct(),
                        cartItem.getPrice()
                )
        ).collect(Collectors.toList()));
        orderRepository.save(order);
        //cartServiceIntegration.cleat();
    }
}
