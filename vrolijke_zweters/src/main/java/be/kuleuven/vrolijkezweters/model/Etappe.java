package be.kuleuven.vrolijkezweters.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.awt.*;

@Entity
@Table(name = "Etappe")
public class Etappe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Etappe_GEN")
    @SequenceGenerator(name = "Etappe_GEN", sequenceName = "Etappe_SEQ")
    @Column(name = "etappe_id", nullable = false)
    private Long etappe_id;

    @Column(name = "lengte", nullable = false)
    private int lengte;

    @Column(name = "locatie", nullable = false)
    private String locatie;


    // ----- Constructors -----

    public Etappe() {

    }

    public Etappe(String locatie) {
        this.locatie = locatie;
    }


    // ----- Getters & Setters -----


    public Long getEtappe_id() {
        return etappe_id;
    }

    public void setEtappe_id(Long etappe_id) {
        this.etappe_id = etappe_id;
    }

    public int getLengte() {
        return lengte;
    }

    public void setLengte(int lengte) {
        this.lengte = lengte;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    @Override
    public String toString() {
        return "Etappe{" +
                "lengte='" + "lengte" +
                ", locatie='" + locatie +
                '}';
    }
}