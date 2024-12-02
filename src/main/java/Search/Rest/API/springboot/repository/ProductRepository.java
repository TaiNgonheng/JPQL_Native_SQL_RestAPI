package Search.Rest.API.springboot.repository;

import Search.Rest.API.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // JPQL Query with UPPER for case-insensitive search
    @Query("SELECT p FROM Product p WHERE " +
            "UPPER(p.name) LIKE CONCAT('%', UPPER(:query), '%') OR " +
            "UPPER(p.description) LIKE CONCAT('%', UPPER(:query), '%')")
    List<Product> searchProducts(String query);

    // Native SQL Query with UPPER for case-insensitive search
    @Query(value = "SELECT * FROM products p WHERE " +
            "UPPER(p.name) LIKE CONCAT('%', UPPER(:query), '%') OR " +
            "UPPER(p.description) LIKE CONCAT('%', UPPER(:query), '%')",
            nativeQuery = true)
    List<Product> searchProductsSQL(String query);
}
