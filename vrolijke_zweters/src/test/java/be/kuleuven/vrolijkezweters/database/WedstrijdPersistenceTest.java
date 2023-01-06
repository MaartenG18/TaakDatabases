package be.kuleuven.vrolijkezweters.database;

import be.kuleuven.vrolijkezweters.EntityManagerProvider;
import be.kuleuven.vrolijkezweters.model.Wedstrijd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class WedstrijdPersistenceTest {

    private EntityManager entityManager;

    @BeforeEach
    public void setUp() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    @Test
    public void wedstrijdCanBePersisted() {
        var testWedstrijd = new Wedstrijd(10, "Genk", "Hasselt", LocalDate.of(2022, 12, 12));
        entityManager.persist(testWedstrijd);
    }
}
