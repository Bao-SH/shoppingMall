package com.example.backend;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Product {
  private Long id;
  private String imageUrl;
  private String name;
  private double price;
  private int stock;
}
