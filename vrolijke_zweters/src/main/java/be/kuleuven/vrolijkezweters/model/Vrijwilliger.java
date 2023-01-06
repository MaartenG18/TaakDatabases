package be.kuleuven.vrolijkezweters.model;

import be.kuleuven.vrolijkezweters.model.Persoon;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Vrijwilliger")
public class Vrijwilliger {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Vrijwilliger_GEN")
    @SequenceGenerator(name = "Vrijwilliger_GEN", sequenceName = "Vrijwilliger_SEQ")
    @Column(name = "vrijwilliger_id", nullable = false)
    private Long vrijwilliger_id;

    @Column(name = "taak", nullable = false)
    private String taak;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "persoon_id", nullable = false)
    private Persoon persoon;

    @ManyToMany(mappedBy = "vrijwilligers", cascade = CascadeType.MERGE)
    private List<Wedstrijd> wedstrijden;


    // ----- Constructors -----

    public Vrijwilliger() {
        wedstrijden = new ArrayList<>();
    }

    public Vrijwilliger(String taak) {
        wedstrijden = new ArrayList<>();
        this.taak = taak;
    }


    // ----- Methods -----

    public void voegWedstrijdToe(Wedstrijd wedstrijd) {
        wedstrijden.add(wedstrijd);
    }


    // ----- Getters & Setters -----

    public Long getVrijwilliger_id() {
        return vrijwilliger_id;
    }

    public void setVrijwilliger_id(Long vrijwilliger_id) {
        this.vrijwilliger_id = vrijwilliger_id;
    }

    public String getTaak() {
        return taak;
    }

    public void setTaak(String taak) {
        this.taak = taak;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public List<Wedstrijd> getWedstrijden() {
        return wedstrijden;
    }

    public void setWedstrijden(List<Wedstrijd> wedstrijden) {
        this.wedstrijden = wedstrijden;
    }


    // ----- ToString -----

    @Override
    public String toString() {
        return "Vrijwilliger{" +
                "vrijwilliger_id=" + vrijwilliger_id +
                ", taak='" + taak + '\'' +
                ", persoon=" + persoon +
                ", wedstrijden=" + wedstrijden +
                '}';
    }
}