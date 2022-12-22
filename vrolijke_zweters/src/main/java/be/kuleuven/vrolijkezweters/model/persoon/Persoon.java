package be.kuleuven.vrolijkezweters.model.persoon;

public class Persoon {

    private String naam;
    private String voornaam;
    private String geboorteDatum;
    private char gender;

    public Persoon(String naam, String voornaam, String geboorteDatum, char gender) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.geboorteDatum = geboorteDatum;
        this.gender = gender;
    }


    // ----- Getters -----

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


    // ----- Setters -----

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
                ", geboorteDatum=" + geboorteDatum +
                '}';
    }
}