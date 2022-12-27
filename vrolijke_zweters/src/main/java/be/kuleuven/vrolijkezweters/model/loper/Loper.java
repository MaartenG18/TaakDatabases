package be.kuleuven.vrolijkezweters.model.loper;

import be.kuleuven.vrolijkezweters.model.persoon.Persoon;

import java.time.LocalDate;
import java.util.Date;

public class Loper extends Persoon {

    private int fitheid;
    private int gewicht;

    public Loper(int persoonId, String naam, String voornaam, LocalDate geboorteDatum, String gender, String email, String wachtwoord, boolean admin, int fitheid, int gewicht) {
        super(persoonId, naam, voornaam, geboorteDatum, gender, email, wachtwoord, admin);
        this.fitheid = fitheid;
        this.gewicht = gewicht;
    }

    // ----- Getters -----

    public int getFitheid() {
        return fitheid;
    }

    public int getGewicht() {
        return gewicht;
    }


    // ----- Setters -----

    public void setFitheid(int fitheid) {
        this.fitheid = fitheid;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }


    @Override
    public String toString() {
        return "Loper{" +
                "fitheid=" + fitheid +
                ", gewicht=" + gewicht +
                '}';
    }
}