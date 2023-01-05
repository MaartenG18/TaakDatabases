package be.kuleuven.vrolijkezweters;

import be.kuleuven.vrolijkezweters.model.Loper;
import be.kuleuven.vrolijkezweters.model.Persoon;
import be.kuleuven.vrolijkezweters.model.Wedstrijd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class LoperPersistenceTest {

    private EntityManager entityManager;

    @BeforeEach
    public void setUp() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    @Test
    public void loperCanBePersisted() {
        var testPersoon = new Persoon("Gielkens", "Maarten", LocalDate.of(2020, 1 , 8), "M", "maarten.gielkens@student.uhasselt.be", "12345", false);
        var testWedstrijd = new Wedstrijd(10, "Genk", "Hasselt", "12/12/2022");
        var testLoper = new Loper(testWedstrijd, testPersoon, 70, 95);
        entityManager.persist(testLoper);
    }
}
