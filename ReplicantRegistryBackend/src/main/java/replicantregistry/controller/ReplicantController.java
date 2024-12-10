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

    // GET endpoint to fetch all replicants
    @GetMapping
    public List<Replicant> getAllReplicants() {
        return replicantService.getAllReplicants();
    }

    // GET endpoint to fetch a replicant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Replicant> getReplicantById(@PathVariable Long id) {
        Optional<Replicant> replicant = replicantService.getReplicantById(id);
        return replicant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST endpoint to add a new replicant
    @PostMapping
    public Replicant addReplicant(@RequestBody Replicant replicant) {
        return replicantService.addReplicant(replicant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Replicant> updateReplicant(@PathVariable Long id, @RequestBody Replicant replicant) {
        Optional<Replicant> updated = replicantService.updateReplicant(id, replicant);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE endpoint to remove a replicant by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReplicant(@PathVariable Long id) {
        boolean deleted = replicantService.deleteReplicant(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
