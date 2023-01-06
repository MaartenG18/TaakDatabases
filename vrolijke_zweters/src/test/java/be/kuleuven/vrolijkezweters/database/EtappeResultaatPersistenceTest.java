package be.kuleuven.vrolijkezweters.database;

import be.kuleuven.vrolijkezweters.EntityManagerProvider;
import be.kuleuven.vrolijkezweters.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class EtappeResultaatPersistenceTest {

    private EntityManager entityManager;

    @BeforeEach
    public void setUp() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    @Test
    public void etappeResultaatCanBePersisted() {
        var testWedstrijd = new Wedstrijd(10, "Genk", "Hasselt", LocalDate.of(2022, 12, 12));
        var testEtappe = new Etappe(2, "Genk", testWedstrijd);
        var testPersoon = new Persoon("Gielkens", "Maarten", LocalDate.of(2020, 1 , 8), "M", "maarten.gielkens@student.uhasselt.be", "12345", false);
        var testLoper = new Loper(testPersoon, 70, 95);
        var testEtappeResultaat = new EtappeResultaat(1800);
        testEtappeResultaat.setLoper(testLoper);
        testEtappeResultaat.setEtappe(testEtappe);
        entityManager.persist(testPersoon);
        entityManager.persist(testLoper);
        entityManager.persist(testWedstrijd);
        entityManager.persist(testEtappe);
        entityManager.persist(testEtappeResultaat);
    }
}
