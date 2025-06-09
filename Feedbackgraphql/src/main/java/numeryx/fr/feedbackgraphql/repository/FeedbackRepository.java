package numeryx.fr.feedbackgraphql.repository;

import numeryx.fr.feedbackgraphql.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByProductId(Long productId);
}
