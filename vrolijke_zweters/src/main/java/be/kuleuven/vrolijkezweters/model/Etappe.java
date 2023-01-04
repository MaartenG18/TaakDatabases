package be.kuleuven.vrolijkezweters.model;

public class Etappe {

    private int lengte;
    private String locatie;


    public Etappe(int lengte, String locatie) {
        this.lengte = lengte;
        this.locatie = locatie;
    }


    // ----- Getters -----

    public int getLengte() {
        return lengte;
    }

    public String getLocatie() {
        return locatie;
    }


    // ----- Setters -----

    public void setLengte(int lengte) {
        this.lengte = lengte;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }


    @Override
    public String toString() {
        return "Etappe{" +
                "lengte='" + lengte +
                ", locatie='" + locatie +
                '}';
    }
}