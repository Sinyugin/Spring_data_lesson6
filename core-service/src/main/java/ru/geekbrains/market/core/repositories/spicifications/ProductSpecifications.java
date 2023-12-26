package ru.geekbrains.market.core.repositories.spicifications;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.market.core.entities.Product;


public class ProductSpecifications {
    public static Specification<Product> priceGeaterOrEqualsThan(Integer min_price){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), min_price);
    }

    public static Specification<Product> priceLessThanOrEqualsThan(Integer max_price){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), max_price);
    }

    public static Specification<Product> titleLike(String titleLike){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titleLike));
    }
}
