package numeryx.fr.feedbackgraphql.repository;

import numeryx.fr.feedbackgraphql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
