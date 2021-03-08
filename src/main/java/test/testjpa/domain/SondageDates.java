package test.testjpa.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class SondageDates extends Sondage{

    @OneToMany(mappedBy = "sondage")
    private List<DateSondage> choix_dates;

    public List<DateSondage> getChoix_dates() {
        return choix_dates;
    }

    public void setChoix_dates(List<DateSondage> choix_dates) {
        this.choix_dates = choix_dates;
    }
}
