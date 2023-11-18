package ru.geekbrains.market.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.ProductDto;
import ru.geekbrains.ResourceNotFoundException;
import ru.geekbrains.market.entities.Product;
import ru.geekbrains.market.repositories.ProductRepository;
import ru.geekbrains.market.repositories.spicifications.ProductSpecifications;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServices {
    private final ProductRepository productRepository;

    public Page<Product> find(Integer minPrice, Integer maxPrice, String titleLike, Integer page){
        Specification<Product> spec = Specification.where(null);
        if (minPrice != null){
            spec = spec.and(ProductSpecifications.priceGeaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null){
            spec = spec.and(ProductSpecifications.priceLessThanOrEqualsThan(maxPrice));
        }
        if (titleLike != null){
            spec = spec.and(ProductSpecifications.titleLike(titleLike));
        }
        return productRepository.findAll(spec, PageRequest.of(page -1,50));
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }
@Transactional
    public Product update(ProductDto productDto){
        Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Невозможно обновить продукт, не найден в базе, id: " + productDto.getId()));
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        return product;
    }
}
