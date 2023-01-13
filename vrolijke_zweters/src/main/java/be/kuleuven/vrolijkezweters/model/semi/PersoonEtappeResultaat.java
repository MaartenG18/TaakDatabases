package be.kuleuven.vrolijkezweters.model.semi;


public class PersoonEtappeResultaat {

    private String naam;
    private String voornaam;

    private int tijd;


    public PersoonEtappeResultaat() {};


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

    public int getTijd() {
        return tijd;
    }
    public void setTijd(int tijd) {
        this.tijd = tijd;
    }
}
