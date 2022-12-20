package be.kuleuven.vrolijkezweters.model.vrijwilliger;

import be.kuleuven.vrolijkezweters.model.persoon.Persoon;

import javax.persistence.*;

@Entity
@Table(name = "Vrijwilliger")
@PrimaryKeyJoinColumn(name = "ID")
public class Vrijwilliger extends Persoon {
    @Column
    private String taak;

    public Vrijwilliger() {

    }

    public Vrijwilliger(String taak) {
        this.taak = taak;
    }

    public String getTaak() {
        return taak;
    }


    public void setTaak(String taak) {
        this.taak = taak;
    }


    @Override
    public String toString() {
        return "Vrijwilliger{" +
                ", taak=" + taak +
                '}';
    }
}
