package be.kuleuven.vrolijkezweters.model;


import javax.persistence.*;

@Entity
@Table(name = "EtappeResultaat")
public class EtappeResultaat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EtappeResultaat_GEN")
    @SequenceGenerator(name = "EtappeResultaat_GEN", sequenceName = "EtappeResultaat_SEQ")
    @Column(name = "etappeResultaat_id", nullable = false)
    private Long etappeResultaat_id;

    @Column(name = "tijd", nullable = false)
    private int tijd;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "etappe_id", nullable = false)
    private Etappe etappe;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "loper_id", nullable = false)
    private Loper loper;


    // ----- Constructor -----

    public EtappeResultaat() {

    }

    public EtappeResultaat(int tijd) {
        this.tijd = tijd;
    }


    // ----- Getters & Setters -----

    public Long getEtappeResultaat_id() {
        return etappeResultaat_id;
    }

    public void setEtappeResultaat_id(Long etappeResultaat_id) {
        this.etappeResultaat_id = etappeResultaat_id;
    }

    public int getTijd() {
        return tijd;
    }

    public void setTijd(int tijd) {
        this.tijd = tijd;
    }

    public Etappe getEtappe() {
        return etappe;
    }

    public void setEtappe(Etappe etappe) {
        this.etappe = etappe;
    }

    public Loper getLoper() {
        return loper;
    }

    public void setLoper(Loper loper) {
        this.loper = loper;
    }


    // ----- ToString -----

    @Override
    public String toString() {
        return "EtappeResultaat{" +
                "etappeResultaat_id=" + etappeResultaat_id +
                ", tijd=" + tijd +
                ", etappe=" + etappe +
                //", loper=" + loper +
                '}';
    }
}
