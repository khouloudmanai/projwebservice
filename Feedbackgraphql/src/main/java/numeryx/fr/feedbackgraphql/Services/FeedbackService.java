package numeryx.fr.feedbackgraphql.Services;


import numeryx.fr.feedbackgraphql.entity.Feedback;
import numeryx.fr.feedbackgraphql.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository repo;

    public FeedbackService(FeedbackRepository repo) {
        this.repo = repo;
    }
    public List<Feedback> getFeedbacksByProductId(Long productId) {
        return repo.findByProductId(productId);
    }
    public Feedback save(Feedback feedback) {
        return repo.save(feedback);
    }

    public List<Feedback> findByProductId(Long productId) {
        return repo.findByProductId(productId);
    }

    public double calculateAverageRating(Long productId) {
        List<Feedback> feedbacks = repo.findByProductId(productId);
        return feedbacks.stream()
                .mapToInt(Feedback::getRating)
                .average()
                .orElse(0);
    }
}

