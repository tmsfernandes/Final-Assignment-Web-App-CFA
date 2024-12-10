package replicantregistry.service;

import replicantregistry.model.Replicant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Marks this class as a Service component in Spring
@Service
public class ReplicantService {
    private final List<Replicant> replicants = new ArrayList<>();

    // Constructor to initialize dummy data
    public ReplicantService() {
        replicants.add(new Replicant(
                1L,
                "Rachael",
                "Nexus-7",
                "2019-03-15",
                "active",
                "Experimental replicant with false memories.",
                "images/rachael.jpg",
                "Height: 170 cm, Weight: 55 kg, Hair: Black",
                "None",
                "None",
                "None",
                "Composed and empathetic. Capable of complex emotions.",
                "Low - Minimal Threat"
        ));

        replicants.add(new Replicant(
                2L,
                "Roy Batty",
                "Nexus-6",
                "2017-01-08",
                "retired",
                "Leader of the escaped replicants, designed for combat.",
                "images/roy_batty.jpg",
                "Height: 184 cm, Weight: 90 kg, Hair: Blonde",
                "Batty",
                "Rebellion leader",
                "Murder of Dr. Eldon Tyrell, Assault on J.F. Sebastian",
                "Highly intelligent and charismatic. Shows advanced combat skills.",
                "High - Lethal Combat Capabilities"
        ));

        replicants.add(new Replicant(
                3L,
                "Pris Stratton",
                "Nexus-6",
                "2017-02-14",
                "retired",
                "Designed for pleasure and social interaction, highly intelligent.",
                "images/pris.jpg",
                "Height: 168 cm, Weight: 53 kg, Hair: Blonde",
                "None",
                "Escaped Nexus-6 group",
                "Conspiracy to infiltrate Tyrell Corporation",
                "Manipulative and resourceful. Excellent at deception.",
                "Medium - Psychological Threat"
        ));

        replicants.add(new Replicant(
                4L,
                "Leon Kowalski",
                "Nexus-6",
                "2017-01-20",
                "retired",
                "Labor-oriented replicant with emotional instability.",
                "images/leon.jpg",
                "Height: 180 cm, Weight: 82 kg, Hair: Brown",
                "None",
                "Escaped Nexus-6 group",
                "Murder of Blade Runner Holden",
                "Aggressive and emotionally volatile.",
                "High - Unstable and Dangerous"
        ));

        replicants.add(new Replicant(
                5L,
                "Zhora Salome",
                "Nexus-6",
                "2017-03-10",
                "retired",
                "Trained for assassination, undercover as an exotic dancer.",
                "images/zhora.jpg",
                "Height: 175 cm, Weight: 59 kg, Hair: Black",
                "None",
                "Escaped Nexus-6 group",
                "Assassination attempts during missions",
                "Stealthy and highly dangerous in close combat.",
                "High - Covert Operative"
        ));

        replicants.add(new Replicant(
                6L,
                "Hodge",
                "Nexus-6",
                "2017-01-15",
                "retired",
                "Combat model who escaped with Roy Batty.",
                "images/hodge.jpg",
                "Height: 187 cm, Weight: 94 kg, Hair: Brown",
                "None",
                "Escaped Nexus-6 group",
                "Various acts of rebellion and violence",
                "Loyal to Roy Batty. Tactical and brutal.",
                "High - Tactical Combatant"
        ));

        replicants.add(new Replicant(
                7L,
                "Mary",
                "Nexus-6",
                "2017-02-05",
                "retired",
                "Pleasure model.",
                "images/mary.jpg",
                "Height: 167 cm, Weight: 50 kg, Hair: Blonde",
                "None",
                "None",
                "None",
                "Designed for companionship. No violent tendencies noted.",
                "Low - Non-violent"
        ));

        replicants.add(new Replicant(
                8L,
                "Deckard",
                "Nexus-6/Nexus-7",
                "Unknown",
                "unknown",
                "Ambiguously a replicant",
                "images/deckard.jpg",
                "Height: 183  cm, Weight: 81 kg, Hair: Brown",
                "Deckard",
                "Blade Runner unit",
                "Enforcement of replicant retirement",
                "Methodical and analytical. Questionable loyalty to humans.",
                "Medium - Potential Identity Conflict"
        ));

        replicants.add(new Replicant(
                9L,
                "Dr. Tyrell",
                "Nexus-8",
                "2020-05-01",
                "active",
                "Replicant copy of Dr. Tyrell.",
                "images/tyrell.jpg",
                "Height: 177 cm, Weight: 73 kg, Hair: Gray",
                "None",
                "Tyrell Corporation",
                "Unknown",
                "Reclusive and enigmatic. Possible hidden agenda.",
                "Medium - Unknown Intentions"
        ));

        replicants.add(new Replicant(
                10L,
                "Freysa Sadeghpour",
                "Nexus-8",
                "2023-06-30",
                "active",
                "Leader of the replicant freedom movement.",
                "images/freysa.jpg",
                "Height: 172 cm, Weight: 63 kg, Hair: Black",
                "Freysa",
                "Replicant Freedom Movement",
                "None",
                "Charismatic leader advocating replicant rights.",
                "Medium - Political Influence"
        ));
    }

    // Returns all replicants
    public List<Replicant> getAllReplicants() {
        return replicants;
    }

    // Returns a replicant by ID
    public Optional<Replicant> getReplicantById(Long id) {
        return replicants.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    // Adds a new replicant to the list
    public Replicant addReplicant(Replicant replicant) {
        replicants.add(replicant);
        return replicant;
    }

    // Deletes a replicant by ID
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
            r.setDescription(updatedReplicant.getDescription());
            r.setImageUrl(updatedReplicant.getImageUrl());
            r.setPhysicalCharacteristics(updatedReplicant.getPhysicalCharacteristics());
            r.setAliases(updatedReplicant.getAliases());
            r.setAffiliations(updatedReplicant.getAffiliations());
            r.setCrimes(updatedReplicant.getCrimes());
            r.setBehaviorNotes(updatedReplicant.getBehaviorNotes());
            r.setTerminationPriority(updatedReplicant.getTerminationPriority());
        });
        return existing;
    }
}
