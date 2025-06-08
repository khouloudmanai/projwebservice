package numeryx.fr.freelancesoapservice.repository;


import numeryx.fr.freelancesoapservice.model.FreelanceProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelanceRepository extends JpaRepository<FreelanceProfile, Long> {
}