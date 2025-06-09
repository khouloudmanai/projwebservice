package numeryx.fr.feedbackgraphql.Services;

import numeryx.fr.feedbackgraphql.entity.Product;
import numeryx.fr.feedbackgraphql.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> findAll() {
        return repo.findAll();
    }
}
