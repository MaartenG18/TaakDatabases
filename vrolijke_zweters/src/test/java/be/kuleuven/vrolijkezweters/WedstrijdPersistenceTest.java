package be.kuleuven.vrolijkezweters;

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
        var testWestrijd = new Wedstrijd(10, "Genk", "Hasselt", "12/12/2022");
        entityManager.persist(testWestrijd);
    }
}
