package be.kuleuven.vrolijkezweters.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personen")
public class Persoon {

    @Column(name = "persoonId")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long persoonId;

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

    @OneToMany(mappedBy = "persoon")
    private List<Loper> lopers;

    @OneToMany(mappedBy = "persoon")
    private List<Vrijwilliger> vrijwilligers;

    public Persoon() {

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

    public void schrijfLoperIn(Loper loper) {
        lopers.add(loper);
        loper.setPersoon(this);
    }

    public void schrijfVrijwilligerIn(Vrijwilliger vrijwilliger) {
        vrijwilligers.add(vrijwilliger);
        vrijwilliger.setPersoon(this);
    }

    public Long getPersoonId() {
        return persoonId;
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

    @Override
    public String toString() {
        return "Persoon{" +
                "naam='" + naam + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", gender=" + gender +
                ", geboorteDatum=" + geboorteDatum +
                '}';
    }
}