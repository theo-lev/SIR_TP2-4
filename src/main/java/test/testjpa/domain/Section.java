package test.testjpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Tableau tableau;

    @ElementCollection(targetClass=Fiche.class)
    private List<Fiche> fiches = new ArrayList<>();

    public Section() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Tableau getTableau() { return tableau; }
    public void setTableau(Tableau tableau) { this.tableau = tableau; }

    @OneToMany(mappedBy = "section", cascade = CascadeType.PERSIST)
    public List<Fiche> getFiches() { return fiches; }
    public void setFiches(List<Fiche> fiches) { this.fiches = fiches; }

    public void addFiche(Fiche fiche) {
        this.fiches.add(fiche);
        fiche.setSection(this);
    }
}
