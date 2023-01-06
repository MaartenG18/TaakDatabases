package be.kuleuven.vrolijkezweters.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Loper")
public class Loper {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Loper_GEN")
    @SequenceGenerator(name = "Loper_GEN", sequenceName = "Loper_SEQ")
    @Column(name = "loopnr", nullable = false)
    private Long loopNummer;

    @Column(name = "fitheid")
    private int fitheid;

    @Column(name = "gewicht")
    private int gewicht;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "persoon_id", nullable = false)
    private Persoon persoon;

    @OneToMany(mappedBy = "loper", cascade = CascadeType.ALL)
    private List<EtappeResultaat> etappeResultaten;

    // ----- Constructors -----

    public Loper() {
        etappeResultaten = new ArrayList<>();
    }

    public Loper(Persoon persoon, int fitheid, int gewicht) {
        etappeResultaten = new ArrayList<>();
        this.persoon = persoon;
        this.fitheid = fitheid;
        this.gewicht = gewicht;
    }


    // ----- Methods -----

    public void voegEtappeResultaatToe(EtappeResultaat etappeResultaat) {
        etappeResultaten.add(etappeResultaat);
        etappeResultaat.setLoper(this);
    }


    // ----- Getters & Setters -----

    public Long getLoopNummer() {
        return loopNummer;
    }

    public void setLoopNummer(Long loopNummer) {
        this.loopNummer = loopNummer;
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

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public List<EtappeResultaat> getEtappeResultaten() {
        return etappeResultaten;
    }

    public void setEtappeResultaten(List<EtappeResultaat> etappeResultaten) {
        this.etappeResultaten = etappeResultaten;
    }


    // ----- ToString -----

    @Override
    public String toString() {
        return "Loper{" +
                "loopNummer=" + loopNummer +
                ", fitheid=" + fitheid +
                ", gewicht=" + gewicht +
                ", persoon=" + persoon +
                ", etappeResultaten=" + etappeResultaten +
                '}';
    }
}