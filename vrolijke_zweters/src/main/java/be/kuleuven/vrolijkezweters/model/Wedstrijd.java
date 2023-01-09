package be.kuleuven.vrolijkezweters.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Wedstrijd")
public class Wedstrijd {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Wedstrijd_GEN")
    @SequenceGenerator(name = "Wedstrijd_GEN", sequenceName = "Wedstrijd_SEQ")
    @Column(name = "wedstrijd_id", nullable = false)
    private int wedstrijd_id;

    @Column(name = "naam", nullable = false)
    private String naam;

    @Column(name = "inschrijvingsgeld", nullable = false)
    private int inschrijvingsgeld;

    @Column(name = "startLocatie", nullable = false)
    private String startLocatie;

    @Column(name = "eindLocatie", nullable = false)
    private String eindLocatie;

    @Column(name = "datum", nullable = false)
    private LocalDate datum;

    private int afstand;

    @OneToMany(mappedBy = "wedstrijd", cascade = CascadeType.ALL)
    private List<Etappe> etappes;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Vrijwilliger> vrijwilligers;


    // ----- Constructors -----

    public Wedstrijd() {
        etappes = new ArrayList<>();
        vrijwilligers = new ArrayList<>();
    }

    public Wedstrijd(String naam, int inschrijvingsgeld, String startLocatie, String eindLocatie, LocalDate datum) {
        etappes = new ArrayList<>();
        vrijwilligers = new ArrayList<>();
        this.naam = naam;
        this.inschrijvingsgeld = inschrijvingsgeld;
        this.startLocatie = startLocatie;
        this.eindLocatie = eindLocatie;
        this.datum = datum;
    }


    // ----- Methods -----

    public void voegEtappeToe(Etappe etappe) {
        etappes.add(etappe);
        etappe.setWedstrijd(this);
    }

    public void voegVrijwilligerToe(Vrijwilliger vrijwilliger) {
        vrijwilligers.add(vrijwilliger);
    }


    // ----- Getters & Setters -----

    public int getWedstrijd_id() {
        return wedstrijd_id;
    }

    public void setWedstrijd_id(int wedstrijd_id) {
        this.wedstrijd_id = wedstrijd_id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getInschrijvingsgeld() {
        return inschrijvingsgeld;
    }

    public void setInschrijvingsgeld(int inschrijvingsgeld) {
        this.inschrijvingsgeld = inschrijvingsgeld;
    }

    public String getStartLocatie() {
        return startLocatie;
    }

    public void setStartLocatie(String startLocatie) {
        this.startLocatie = startLocatie;
    }

    public String getEindLocatie() {
        return eindLocatie;
    }

    public void setEindLocatie(String eindLocatie) {
        this.eindLocatie = eindLocatie;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public List<Etappe> getEtappes() {
        return etappes;
    }

    public void setEtappes(List<Etappe> etappes) {
        this.etappes = etappes;
    }

    public List<Vrijwilliger> getVrijwilligers() {
        return vrijwilligers;
    }

    public void setVrijwilligers(List<Vrijwilliger> vrijwilligers) {
        this.vrijwilligers = vrijwilligers;
    }

    public int getAfstand() {
        return afstand;
    }

    public void setAfstand(int afstand) {
        this.afstand = afstand;
    }

    @Override
    public String toString() {
        return "Wedstrijd{" +
                "wedstrijd_id=" + wedstrijd_id +
                ", naam=" + naam +  '\'' +
                ", inschrijvingsgeld=" + inschrijvingsgeld +  '\'' +
                ", startLocatie='" + startLocatie + '\'' +
                ", eindLocatie='" + eindLocatie + '\'' +
                ", datum='" + datum + '\'' +
                '}';
    }
}