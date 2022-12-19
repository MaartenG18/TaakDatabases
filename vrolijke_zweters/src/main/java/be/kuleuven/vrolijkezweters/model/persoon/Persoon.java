package be.kuleuven.vrolijkezweters.model.persoon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Persoon {

    @Column
    private String naam;
    @Column
    private String voornaam;
    @Column
    private String geboorteDatum;
    @Column
    private char gender;

    @Column
    @Id
    @GeneratedValue
    private int persoonId;

    public Persoon() {

    }

    public int getPersoonId() {
        return persoonId;
    }

    public String getNaam() {
        return naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getGeboorteDatum() {
        return geboorteDatum;
    }

    public char getGender() {
        return gender;
    }


    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setGeboorteDatum(String geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "naam='" + naam + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", gender=" + gender +
                ", persoonId=" + persoonId +
                ", geboorteDatum=" + geboorteDatum +
                '}';
    }

    public Persoon(String naam, String voornaam, String geboorteDatum, char gender) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.geboorteDatum = geboorteDatum;
        this.gender = gender;
    }
}
