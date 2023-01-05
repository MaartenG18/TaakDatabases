package be.kuleuven.vrolijkezweters.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Loper")
public class Loper {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "persoon_id")
    private Persoon persoon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wedstrijd_id")
    private Wedstrijd wedstrijd;

    @Column(name = "fitheid")
    private int fitheid;

    @Column(name = "gewicht")
    private int gewicht;

    @Column(name = "loopnr")
    @Id
    @GeneratedValue
    private int loopNummer;

    public Loper() {

    }

    public Loper(Wedstrijd wedstrijd, Persoon persoon, int fitheid, int gewicht) {
        this.wedstrijd = wedstrijd;
        this.persoon = persoon;
        this.fitheid = fitheid;
        this.gewicht = gewicht;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public Wedstrijd getWedstrijd() {
        return wedstrijd;
    }

    public void setWedstrijd(Wedstrijd wedstrijd) {
        this.wedstrijd = wedstrijd;
    }

    public int getFitheid() {
        return fitheid;
    }

    public void setFitheid(int fitheid) {
        this.fitheid = fitheid;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    @Override
    public String toString() {
        return "Loper{" +
                "fitheid=" + fitheid +
                ", gewicht=" + gewicht +
                '}';
    }
}