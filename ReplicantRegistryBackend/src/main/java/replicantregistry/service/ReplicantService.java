package replicantregistry.service;

import replicantregistry.model.Replicant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReplicantService {
    private final List<Replicant> replicants = new ArrayList<>();

    public ReplicantService() {
        replicants.add(new Replicant(1L, "Rachael", "Nexus-7", "2019-03-15", "active"));
        replicants.add(new Replicant(2L, "Roy Batty", "Nexus-6", "2017-01-08", "retired"));
    }

    public List<Replicant> getAllReplicants() {
        return replicants;
    }

    public Optional<Replicant> getReplicantById(Long id) {
        return replicants.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public Replicant addReplicant(Replicant replicant) {
        replicants.add(replicant);
        return replicant;
    }

    public boolean deleteReplicant(Long id) {
        return replicants.removeIf(r -> r.getId().equals(id));
    }

    public Optional<Replicant> updateReplicant(Long id, Replicant updatedReplicant) {
        Optional<Replicant> existing = getReplicantById(id);
        existing.ifPresent(r -> {
            r.setName(updatedReplicant.getName());
            r.setModel(updatedReplicant.getModel());
            r.setInceptionDate(updatedReplicant.getInceptionDate());
            r.setStatus(updatedReplicant.getStatus());
        });
        return existing;
    }
}