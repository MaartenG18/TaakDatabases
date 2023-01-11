package be.kuleuven.vrolijkezweters.model.semi;

import be.kuleuven.vrolijkezweters.model.EtappeResultaat;
import be.kuleuven.vrolijkezweters.model.Persoon;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class LoperWedstrijd {

    private Long loopNummer;

    private String tijd;

    private String naam;
    private LocalDate datum;


    public LoperWedstrijd() {};


    public Long getLoopNummer() {
        return loopNummer;
    }
    public void setLoopNummer(Long loopNummer) {
        this.loopNummer = loopNummer;
    }

    public String getTijd() {
        return tijd;
    }
    public void setTijd(String tijd) {
        this.tijd = tijd;
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
