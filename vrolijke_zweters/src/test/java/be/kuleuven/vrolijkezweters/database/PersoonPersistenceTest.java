package be.kuleuven.vrolijkezweters.database;

import be.kuleuven.vrolijkezweters.EntityManagerProvider;
import be.kuleuven.vrolijkezweters.model.Persoon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class PersoonPersistenceTest {

    private EntityManager entityManager;

    @BeforeEach
    public void setUp() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    @Test
    public void persoonCanBePersisted() {
        var testPersoon = new Persoon("Gielkens", "Maarten", LocalDate.of(2020, 1 , 8), "M", "maarten.gielkens@student.uhasselt.be", "12345", false);
        entityManager.persist(testPersoon);
    }
}
