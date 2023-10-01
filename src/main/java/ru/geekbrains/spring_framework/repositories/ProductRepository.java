package ru.geekbrains.spring_framework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring_framework.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
