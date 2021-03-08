package test.testjpa.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.List;

@Entity
public class SondageDatesLieux extends Sondage{

    @OneToMany(mappedBy = "sondage")
    private List<DateSondage> choix_dates;

    @OneToMany(mappedBy = "sondage")
    private List<Lieu> choix_lieux;

    public List<DateSondage> getChoix_dates() {
        return choix_dates;
    }

    public void setChoix_dates(List<DateSondage> choix_dates) {
        this.choix_dates = choix_dates;
    }

    public List<Lieu> getChoix_lieux() {
        return choix_lieux;
    }

    public void setChoix_lieux(List<Lieu> choix_lieux) {
        this.choix_lieux = choix_lieux;
    }
}
