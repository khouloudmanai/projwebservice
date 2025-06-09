package numeryx.fr.feedbackgraphql.Controllers;


import numeryx.fr.feedbackgraphql.Services.FeedbackService;
import numeryx.fr.feedbackgraphql.Services.ProductService;
import numeryx.fr.feedbackgraphql.Services.UserService;
import numeryx.fr.feedbackgraphql.entity.Feedback;
import numeryx.fr.feedbackgraphql.entity.Product;
import numeryx.fr.feedbackgraphql.entity.User;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class GraphQLController {

    private final FeedbackService feedbackService;
    private final ProductService productService;
    private final UserService userService;

    public GraphQLController(FeedbackService feedbackService, ProductService productService, UserService userService) {
        this.feedbackService = feedbackService;
        this.productService = productService;
        this.userService = userService;
    }

    @QueryMapping
    public List<Feedback> feedbacksByProduct(@Argument Long productId) {
        return feedbackService.findByProductId(productId);
    }

    @QueryMapping
    public Double averageRating(@Argument Long productId) {
        return feedbackService.calculateAverageRating(productId);
    }

    @QueryMapping
    public List<Product> allProducts() {
        return productService.findAll();
    }

    public static class FeedbackInput {
        private Long userId;
        private Long productId;
        private int rating;
        private String comment;

        // getters & setters
        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
        public Long getProductId() { return productId; }
        public void setProductId(Long productId) { this.productId = productId; }
        public int getRating() { return rating; }
        public void setRating(int rating) { this.rating = rating; }
        public String getComment() { return comment; }
        public void setComment(String comment) { this.comment = comment; }
    }

    @MutationMapping
    public Feedback addFeedback(@Argument FeedbackInput feedback) {
        User user = userService.findById(feedback.getUserId());
        Product product = productService.findById(feedback.getProductId());

        Feedback fb = new Feedback();
        fb.setUser(user);
        fb.setProduct(product);
        fb.setRating(feedback.getRating());
        fb.setComment(feedback.getComment());
        fb.setDate(LocalDateTime.now());

        return feedbackService.save(fb);
    }
}

