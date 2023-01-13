package be.kuleuven.vrolijkezweters.model.semi;

import java.time.LocalDate;

public class PersoonVrijwilliger {

    private String naam;
    private String voornaam;
    private LocalDate geboorteDatum;

    private String taak;


    public PersoonVrijwilliger() {};


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

    public String getTaak() {
        return taak;
    }
    public void setTaak(String taak) {
        this.taak = taak;
    }
}
