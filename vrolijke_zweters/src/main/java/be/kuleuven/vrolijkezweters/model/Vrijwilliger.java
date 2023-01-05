package be.kuleuven.vrolijkezweters.model;

import be.kuleuven.vrolijkezweters.model.Persoon;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vrijwilliger")
public class Vrijwilliger {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_persoon_id")
    private Persoon persoon;

    @Column(name = "taak")
    private String taak;

    @Column(name = "vrijwilliger_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int vrijwilligerId;

    @ManyToMany(mappedBy = "vrijwilligers")
    private List<Wedstrijd> wedstrijden;

    public Vrijwilliger() {
        wedstrijden = new ArrayList<>();
    }

    public Vrijwilliger(Persoon persoon, String taak) {
        wedstrijden = new ArrayList<>();
        this.persoon = persoon;
        this.taak = taak;
    }

    public void voegWedstrijdToe(Wedstrijd wedstrijd) {
        wedstrijden.add(wedstrijd);
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public List<Wedstrijd> getWedstrijden(){
        return wedstrijden;
    }

    public String getTaak() {
        return taak;
    }

    public void setTaak(String taak) {
        this.taak = taak;
    }

    @Override
    public String toString() {
        return "Vrijwilliger{" +
                "taak=" + taak +
                '}';
    }
}