package be.kuleuven.vrolijkezweters.model.wedstrijd;

public class Wedstrijd {

    private int inschrijvingsGeld;
    private String startLocatie;
    private String eindLocatie;
    private String datum;

    public Wedstrijd(int inschrijvingsGeld, String startLocatie, String eindLocatie, String datum) {
        this.inschrijvingsGeld = inschrijvingsGeld;
        this.startLocatie = startLocatie;
        this.eindLocatie = eindLocatie;
        this.datum = datum;
    }


    // ----- Getters -----

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