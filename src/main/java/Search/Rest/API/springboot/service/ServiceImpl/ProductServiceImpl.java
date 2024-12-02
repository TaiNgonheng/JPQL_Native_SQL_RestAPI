package Search.Rest.API.springboot.service.ServiceImpl;

import Search.Rest.API.springboot.entity.Product;
import Search.Rest.API.springboot.repository.ProductRepository;
import Search.Rest.API.springboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = productRepository.searchProducts(query);
        return products;
    }

    @Override
    public Product createProducts(Product product) {
       Product create =  productRepository.save(product);
        return create;
    }
}
