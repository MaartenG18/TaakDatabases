package be.kuleuven.vrolijkezweters.model.vrijwilliger;

import be.kuleuven.vrolijkezweters.model.persoon.Persoon;

public class Vrijwilliger extends Persoon {

    private String taak;

    public Vrijwilliger(String naam, String voornaam, String geboorteDatum, char gender, String taak) {
        super(naam, voornaam, geboorteDatum, gender);
        this.taak = taak;
    }


    // ----- Getters -----

    public String getTaak() {
        return taak;
    }


    // ----- Setters -----

    public void setTaak(String taak) {
        this.taak = taak;
    }


    @Override
    public String toString() {
        return "Vrijwilliger{" +
                "taak=" + taak +
                '}';
    }
}