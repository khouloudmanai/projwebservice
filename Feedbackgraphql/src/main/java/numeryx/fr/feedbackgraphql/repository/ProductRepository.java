package numeryx.fr.feedbackgraphql.repository;


import numeryx.fr.feedbackgraphql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}