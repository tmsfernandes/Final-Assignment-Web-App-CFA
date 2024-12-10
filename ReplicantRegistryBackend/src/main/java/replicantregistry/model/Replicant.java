package replicantregistry.model;

public class Replicant {
    private Long id;
    private String name;
    private String model;
    private String inceptionDate;
    private String status;
    private String description;
    private String imageUrl;
    private String physicalCharacteristics;
    private String aliases;
    private String affiliations;
    private String crimes;
    private String behaviorNotes;
    private String terminationPriority;


    public Replicant(Long id, String name, String model, String inceptionDate, String status, String description, String imageUrl,
                     String physicalCharacteristics, String aliases, String affiliations, String crimes, String behaviorNotes, String terminationPriority) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.inceptionDate = inceptionDate;
        this.status = status;
        this.description = description;
        this.imageUrl = imageUrl;
        this.physicalCharacteristics = physicalCharacteristics;
        this.aliases = aliases;
        this.affiliations = affiliations;
        this.crimes = crimes;
        this.behaviorNotes = behaviorNotes;
        this.terminationPriority = terminationPriority;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getInceptionDate() {
        return inceptionDate;
    }

    public void setInceptionDate(String inceptionDate) {
        this.inceptionDate = inceptionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPhysicalCharacteristics() {
        return physicalCharacteristics;
    }

    public void setPhysicalCharacteristics(String physicalCharacteristics) {
        this.physicalCharacteristics = physicalCharacteristics;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public String getAffiliations() {
        return affiliations;
    }

    public void setAffiliations(String affiliations) {
        this.affiliations = affiliations;
    }

    public String getCrimes() {
        return crimes;
    }

    public void setCrimes(String crimes) {
        this.crimes = crimes;
    }

    public String getBehaviorNotes() {
        return behaviorNotes;
    }

    public void setBehaviorNotes(String behaviorNotes) {
        this.behaviorNotes = behaviorNotes;
    }

    public String getTerminationPriority() {
        return terminationPriority;
    }

    public void setTerminationPriority(String terminationPriority) {
        this.terminationPriority = terminationPriority;
    }
}
