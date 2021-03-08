package test.testjpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Fiche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Section section;

    private String name;

    private Date date_butoir;

    private User user;

    private float heures_estime;

    private List<Tags> tags;

    private String lieu;

    private String url;

    private String note;

    @OneToOne
    private Sondage sondage;

    public Fiche(String name) {
        this.name = name;
    }
    public Fiche() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    public Section getSection() { return section; }
    public void setSection(Section section) { this.section = section; }

    @Temporal(TemporalType.DATE)
    public Date getDate_butoir() { return date_butoir; }
    public void setDate_butoir(Date date_butoir) { this.date_butoir = date_butoir; }

    @ManyToOne
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public float getHeures_estime() { return heures_estime; }
    public void setHeures_estime(float heures_estime) { this.heures_estime = heures_estime; }

    @ManyToMany
    public List<Tags> getTags() { return tags; }
    public void setTags(List<Tags> tags) { this.tags = tags; }

    public String getLieu() { return lieu; }
    public void setLieu(String lieu) { this.lieu = lieu; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    @Override
    public String toString() {
        return "Fiche{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", section=" + section +
                '}';
    }
}