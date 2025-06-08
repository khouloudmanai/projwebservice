package numeryx.fr.freelancesoapservice.endpoint;



import numeryx.fr.freelancesoapservice.model.FreelanceProfile;
import numeryx.fr.freelancesoapservice.repository.FreelanceRepository;
import numeryx.fr.freelancesoapservice.GetFreelanceRequest;
import numeryx.fr.freelancesoapservice.GetFreelanceResponse;
import org.springframework.ws.server.endpoint.annotation.*;

import java.util.Optional;

@Endpoint
public class FreelanceEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/freelance";
    private final FreelanceRepository repository;

    public FreelanceEndpoint(FreelanceRepository repository) {
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFreelanceRequest")
    @ResponsePayload
    public GetFreelanceResponse getFreelance(@RequestPayload GetFreelanceRequest request) {
        GetFreelanceResponse response = new GetFreelanceResponse();
        FreelanceProfile entity = repository.findById(request.getId()).orElse(null);

        if (entity != null) {
            numeryx.fr.freelancesoapservice.FreelanceProfile profile = new numeryx.fr.freelancesoapservice.FreelanceProfile();
            profile.setId(entity.getId());
            profile.setNom(entity.getNom());
            profile.setPrenom(entity.getPrenom());
            profile.setEmail(entity.getEmail());
            profile.setTelephone(entity.getTelephone());
            profile.setSpecialites(entity.getSpecialites());
            profile.setLienLinkedIn(entity.getLienLinkedIn());
            profile.setLienPortfolio(entity.getLienPortfolio());

            response.setProfile(profile);
        }
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteFreelanceRequest")
    @ResponsePayload
    public DeleteFreelanceResponse deleteFreelance(@RequestPayload DeleteFreelanceRequest request) {
        DeleteFreelanceResponse response = new DeleteFreelanceResponse();
        if (repository.existsById(request.getId())) {
            repository.deleteById(request.getId());
            response.setSuccess(true);
        } else {
            response.setSuccess(false);
        }
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateFreelanceRequest")
    @ResponsePayload
    public UpdateFreelanceResponse updateFreelance(@RequestPayload UpdateFreelanceRequest request) {
        UpdateFreelanceResponse response = new UpdateFreelanceResponse();
        numeryx.fr.freelancesoapservice.FreelanceProfile input = request.getProfile();

        Optional<FreelanceProfile> optional = repository.findById(input.getId());
        if (optional.isPresent()) {
            FreelanceProfile entity = optional.get();
            entity.setNom(input.getNom());
            entity.setPrenom(input.getPrenom());
            entity.setEmail(input.getEmail());
            entity.setTelephone(input.getTelephone());
            entity.setSpecialites(input.getSpecialites());
            entity.setLienLinkedIn(input.getLienLinkedIn());
            entity.setLienPortfolio(input.getLienPortfolio());
            repository.save(entity);
            response.setSuccess(true);
        } else {
            response.setSuccess(false);
        }
        return response;
    }

}
