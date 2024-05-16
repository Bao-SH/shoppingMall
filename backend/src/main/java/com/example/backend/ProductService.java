package com.example.backend;

import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
  private static final String PRODUCT_KEY = "products";

  private final RedisTemplate<String, Product> redisTemplate;

  public List<Product> getProducts(int page, int size) {
    // Calculate start and end indexes for pagination
    int startIndex = (page - 1) * size;
    int endIndex = startIndex + size - 1;

    // Retrieve products from Redis sorted set within the specified range
    Set<Product> products = redisTemplate.opsForZSet().range(PRODUCT_KEY, startIndex, endIndex);

    // Convert Set<Product> to List<Product> for easier manipulation
    return List.copyOf(products);
  }

  public void addProduct(Product product) {
    redisTemplate.opsForZSet().add(PRODUCT_KEY, product, product.getId());
  }
}
