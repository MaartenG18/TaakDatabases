package be.kuleuven.vrolijkezweters.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Etappe")
public class Etappe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Etappe_GEN")
    @SequenceGenerator(name = "Etappe_GEN", sequenceName = "Etappe_SEQ")
    @Column(name = "etappe_id", nullable = false)
    private Long etappe_id;

    @Column(name = "lengte", nullable = false)
    private int lengte;

    @Column(name = "locatie", nullable = false)
    private String locatie;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "wedstrijd_id", nullable = false)
    private Wedstrijd wedstrijd;

    @OneToMany(mappedBy = "etappe", cascade = CascadeType.ALL)
    private List<EtappeResultaat> etappeResultaten;


    // ----- Constructors -----

    public Etappe() {
        etappeResultaten = new ArrayList<>();
    }

    public Etappe(int lengte, String locatie, Wedstrijd wedstrijd) {
        etappeResultaten = new ArrayList<>();
        this.lengte = lengte;
        this.locatie = locatie;
        this.wedstrijd = wedstrijd;
    }


    // ----- Methods -----

    public void voegEtappeResultaatToe(EtappeResultaat etappeResultaat) {
        etappeResultaten.add(etappeResultaat);
        etappeResultaat.setEtappe(this);
    }


    // ----- Getters & Setters -----

    public Long getEtappe_id() {
        return etappe_id;
    }

    public void setEtappe_id(Long etappe_id) {
        this.etappe_id = etappe_id;
    }

    public int getLengte() {
        return lengte;
    }

    public void setLengte(int lengte) {
        this.lengte = lengte;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public Wedstrijd getWedstrijd() {
        return wedstrijd;
    }

    public void setWedstrijd(Wedstrijd wedstrijd) {
        this.wedstrijd = wedstrijd;
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
        return "Etappe{" +
                "etappe_id=" + etappe_id +
                ", lengte=" + lengte +
                ", locatie='" + locatie + '\'' +
                '}';
    }
}