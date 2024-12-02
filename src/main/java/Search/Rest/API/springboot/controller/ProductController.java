package Search.Rest.API.springboot.controller;

import Search.Rest.API.springboot.entity.Product;
import Search.Rest.API.springboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam("query") String query){
        return ResponseEntity.ok(productService.searchProducts(query));
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProducts(product), HttpStatus.CREATED);
    }

}
