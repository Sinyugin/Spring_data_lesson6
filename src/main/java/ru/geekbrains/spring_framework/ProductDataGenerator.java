package ru.geekbrains.spring_framework;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring_framework.entities.Product;
import ru.geekbrains.spring_framework.repositories.ProductRepository;

@Component
public class ProductDataGenerator {
    @Autowired
    private ProductRepository productRepository;

//    @EventListener(ApplicationReadyEvent.class)
//    public void generateDataStartup() {
//        Faker faker = new Faker();
//
//        for (int i = 0; i < 20; i++){
//            Product product = new Product();
//            product.setTitle(faker.food().fruit());
//            product.setPrice(faker.number().randomDigit());
//            productRepository.save(product);
//
//        }
//    }
}
