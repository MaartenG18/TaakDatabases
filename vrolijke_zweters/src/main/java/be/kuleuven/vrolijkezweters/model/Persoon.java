package be.kuleuven.vrolijkezweters.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Persoon")
public class Persoon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Persoon_GEN")
    @SequenceGenerator(name = "Persoon_GEN", sequenceName = "Persoon_SEQ")
    @Column(name = "persoon_id", nullable = false)
    private Long persoon_id;

    @Column(name = "naam", nullable = false)
    private String naam;

    @Column(name = "voornaam", nullable = false)
    private String voornaam;

    @Column(name = "geboorteDatum", nullable = false)
    private LocalDate geboorteDatum;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "wachtwoord", nullable = false)
    private String wachtwoord;

    @Column(name = "admin", nullable = false)
    private boolean admin;

    @OneToMany(mappedBy = "persoon", cascade = CascadeType.ALL)
    private List<Loper> lopers;

    @OneToMany(mappedBy = "persoon", cascade = CascadeType.ALL)
    private List<Vrijwilliger> vrijwilligers;


    // ----- Constructors -----

    public Persoon() {
        lopers = new ArrayList<>();
        vrijwilligers = new ArrayList<>();
    }

    public Persoon(String naam, String voornaam, LocalDate geboorteDatum, String gender, String email, String wachtwoord, boolean admin) {
        lopers = new ArrayList<>();
        vrijwilligers = new ArrayList<>();
        this.naam = naam;
        this.voornaam = voornaam;
        this.geboorteDatum = geboorteDatum;
        this.gender = gender;
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.admin = admin;
    }


    // ----- Methods -----

    public void schrijfLoperIn(Loper loper) {
        lopers.add(loper);
        loper.setPersoon(this);
    }

    public void schrijfVrijwilligerIn(Vrijwilliger vrijwilliger) {
        vrijwilligers.add(vrijwilliger);
        vrijwilliger.setPersoon(this);
    }


    // ----- Getters & Setters -----

    public Long getPersoon_id() {
        return persoon_id;
    }

    public void setPersoon_id(Long persoon_id) {
        this.persoon_id = persoon_id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(LocalDate geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Loper> getLopers() {
        return lopers;
    }

    public void setLopers(List<Loper> lopers) {
        this.lopers = lopers;
    }

    public List<Vrijwilliger> getVrijwilligers() {
        return vrijwilligers;
    }

    public void setVrijwilligers(List<Vrijwilliger> vrijwilligers) {
        this.vrijwilligers = vrijwilligers;
    }


    // ----- ToString -----

    @Override
    public String toString() {
        return "Persoon{" +
                "persoon_id=" + persoon_id +
                ", naam='" + naam + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", geboorteDatum=" + geboorteDatum +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", wachtwoord='" + wachtwoord + '\'' +
                ", admin=" + admin +
                ", lopers=" + lopers +
                ", vrijwilligers=" + vrijwilligers +
                '}';
    }
}