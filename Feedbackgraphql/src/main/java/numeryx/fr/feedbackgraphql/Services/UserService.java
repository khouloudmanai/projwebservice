package numeryx.fr.feedbackgraphql.Services;

import numeryx.fr.feedbackgraphql.entity.app_user;
import numeryx.fr.feedbackgraphql.repository.app_userRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class app_userService {

    private final app_userRepository repo;

    public app_userService(app_userRepository repo) {
        this.repo = repo;
    }

    // Cette méthode doit être présente
    public app_user findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("User not found with id " + id));
    }

    // méthode d'ajout d'utilisateur
    public app_user addUser(UserInput input) {
        app_user user = new app_user();
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        return repo.save(user);
    }
}
