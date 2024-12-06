package replicantregistry.controller;

import replicantregistry.model.Replicant;
import replicantregistry.service.ReplicantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/replicants")
public class ReplicantController {

    private final ReplicantService replicantService;

    public ReplicantController(ReplicantService replicantService) {
        this.replicantService = replicantService;
    }

    @GetMapping
    public List<Replicant> getAllReplicants() {
        return replicantService.getAllReplicants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Replicant> getReplicantById(@PathVariable Long id) {
        Optional<Replicant> replicant = replicantService.getReplicantById(id);
        return replicant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Replicant addReplicant(@RequestBody Replicant replicant) {
        return replicantService.addReplicant(replicant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Replicant> updateReplicant(@PathVariable Long id, @RequestBody Replicant replicant) {
        Optional<Replicant> updated = replicantService.updateReplicant(id, replicant);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReplicant(@PathVariable Long id) {
        boolean deleted = replicantService.deleteReplicant(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
