package be.kuleuven.vrolijkezweters.model;

import be.kuleuven.vrolijkezweters.model.Persoon;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vrijwilligers")
public class Vrijwilliger {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_spersoonId")
    private Persoon persoon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wedstrijdId")
    private Wedstrijd wedstrijd;

    @Column(name = "taak")
    private String taak;

    @Column(name = "vrijwilligerId")
    @Id
    @GeneratedValue
    private int vrijwilligerId;

    public Vrijwilliger() {

    }

    public Vrijwilliger(Wedstrijd wedstrijd, Persoon persoon, String taak) {
        this.wedstrijd = wedstrijd;
        this.persoon = persoon;
        this.taak = taak;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public Wedstrijd getWedstrijd(){
        return wedstrijd;
    }

    public void setWedstrijd(Wedstrijd wedstrijd) {
        this.wedstrijd = wedstrijd;
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