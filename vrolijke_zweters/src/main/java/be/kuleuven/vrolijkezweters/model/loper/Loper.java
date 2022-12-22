package be.kuleuven.vrolijkezweters.model.loper;

import be.kuleuven.vrolijkezweters.model.persoon.Persoon;

public class Loper extends Persoon {

    private int fitheid;
    private int gewicht;

    public Loper(String naam, String voornaam, String geboorteDatum, char gender, int fitheid, int gewicht) {
        super(naam, voornaam, geboorteDatum, gender);
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