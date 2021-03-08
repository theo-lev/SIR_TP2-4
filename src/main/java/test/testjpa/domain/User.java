package test.testjpa.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection(targetClass=Fiche.class)
    private List<Fiche> fiches_attrib;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    public List<Fiche> getFiches_attrib() { return fiches_attrib; }
    public void setFiches_attrib(List<Fiche> fiches_attrib) { this.fiches_attrib = fiches_attrib; }
}
