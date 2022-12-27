package be.kuleuven.vrolijkezweters.model.vrijwilliger;

import be.kuleuven.vrolijkezweters.model.persoon.Persoon;

import java.time.LocalDate;
import java.util.Date;

public class Vrijwilliger extends Persoon {

    private String taak;

    public Vrijwilliger(int persoonId, String naam, String voornaam, LocalDate geboorteDatum, String gender, String email, String wachtwoord, boolean admin, String taak) {
        super(persoonId, naam, voornaam, geboorteDatum, gender, email, wachtwoord, admin);
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