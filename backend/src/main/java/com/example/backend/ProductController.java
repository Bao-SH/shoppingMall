package com.example.backend;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/products")
  public List<Product> getProducts(@RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "15") int size) {
    return productService.getProducts(page, size);
  }

  @PostMapping("/products")
  public void addProduct(@RequestBody Product product) {
    productService.addProduct(product);
  }
}
