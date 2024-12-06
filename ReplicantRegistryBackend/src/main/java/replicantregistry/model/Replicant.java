package replicantregistry.model;


public class Replicant {
    private Long id;
    private String name;
    private String model;
    private String inceptionDate;
    private String status;

    public Replicant() {}

    public Replicant(Long id, String name, String model, String inceptionDate, String status) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.inceptionDate = inceptionDate;
        this.status = status;
    }

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
}