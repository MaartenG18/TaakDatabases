package be.kuleuven.vrolijkezweters.model.semi;

import java.time.LocalDate;
import java.util.ArrayList;

public class VrijwilligerWedstrijd {

    private Long vrijwilliger_id;
    private String taak;

    private int wedstrijd_id;
    private String naam;
    private LocalDate datum;


    public VrijwilligerWedstrijd() {}


    public Long getVrijwilliger_id() {
        return vrijwilliger_id;
    }
    public void setVrijwilliger_id(Long vrijwilliger_id) {
        this.vrijwilliger_id = vrijwilliger_id;
    }
    public String getTaak() {
        return taak;
    }
    public void setTaak(String taak) {
        this.taak = taak;
    }


    public int getWedstrijd_id() {
        return wedstrijd_id;
    }
    public void setWedstrijd_id(int wedstrijd_id) {
        this.wedstrijd_id = wedstrijd_id;
    }
    public String getNaam() {
        return naam;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public LocalDate getDatum() {
        return datum;
    }
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
