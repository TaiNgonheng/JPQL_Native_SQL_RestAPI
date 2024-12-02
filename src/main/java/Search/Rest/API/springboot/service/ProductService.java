package Search.Rest.API.springboot.service;

import Search.Rest.API.springboot.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);
    Product createProducts(Product product);
}
