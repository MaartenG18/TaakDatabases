package be.kuleuven.vrolijkezweters.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wedstrijden")
public class Wedstrijd {

    @Column(name = "wedstrijdId", nullable = false)
    @Id
    @GeneratedValue
    private int wedstrijdId;

    @Column(name = "inschrijvingsGeld", nullable = false)
    private int inschrijvingsGeld;

    @Column(name = "startLocatie", nullable = false)
    private String startLocatie;

    @Column(name = "eindLocatie", nullable = false)
    private String eindLocatie;

    @Column(name = "datum", nullable = false)
    private String datum;

    @OneToMany(mappedBy = "wedstrijd")
    private List<Loper> lopers;

    @OneToMany(mappedBy = "wedstrijd")
    private List<Vrijwilliger> vrijwilligers;

    public Wedstrijd() {

    }

    public Wedstrijd(int inschrijvingsGeld, String startLocatie, String eindLocatie, String datum) {
        lopers = new ArrayList<>();
        this.inschrijvingsGeld = inschrijvingsGeld;
        this.startLocatie = startLocatie;
        this.eindLocatie = eindLocatie;
        this.datum = datum;
    }

    public void voegLoperToe(Loper loper) {
        lopers.add(loper);
        loper.setWedstrijd(this);
    }

    public void voegVrijwilligerToe(Vrijwilliger vrijwilliger) {
        vrijwilligers.add(vrijwilliger);
        vrijwilliger.setWedstrijd(this);
    }


    // ----- Getters -----

    public List<Loper> getLopers() {
        return lopers;
    }

    public List<Vrijwilliger> getVrijwilligers() {
        return vrijwilligers;
    }

    public int getWedstrijdId() {
        return wedstrijdId;
    }

    public int getInschrijvingsGeld() {
        return inschrijvingsGeld;
    }

    public String getStartLocatie() {
        return startLocatie;
    }

    public String getEindLocatie() {
        return eindLocatie;
    }

    public String getDatum() {
        return datum;
    }


    // ----- Setters -----

    public void setInschrijvingsGeld(int inschrijvingsGeld) {
        this.inschrijvingsGeld = inschrijvingsGeld;
    }

    public void setStartLocatie(String startLocatie) {
        this.startLocatie = startLocatie;
    }

    public void setEindLocatie(String eindLocatie) {
        this.eindLocatie = eindLocatie;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Wedstrijd{" +
                "inschrijvingsgeld='" + inschrijvingsGeld +
                ", startLocatie='" + startLocatie +
                ", eindLocatie=" + eindLocatie +
                ", datum=" + datum +
                '}';
    }
}