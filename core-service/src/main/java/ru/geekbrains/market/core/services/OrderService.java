package ru.geekbrains.market.core.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.CartDto;
import ru.geekbrains.market.core.entities.Order;
import ru.geekbrains.market.core.entities.OrderItem;
import ru.geekbrains.market.core.integrations.CartServiceIntegration;
import ru.geekbrains.market.core.repositories.OrderRepository;

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
    public void createOrder(String username) {
        CartDto cartDto = cartServiceIntegration.getCurrentCart();

        Order order = new Order();
        order.setUsername(username);
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
        cartServiceIntegration.clear();

    }
}
