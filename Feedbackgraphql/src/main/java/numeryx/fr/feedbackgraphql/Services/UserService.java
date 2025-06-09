package numeryx.fr.feedbackgraphql.Services;
import numeryx.fr.feedbackgraphql.entity.User;
import numeryx.fr.feedbackgraphql.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}

