package be.kuleuven.vrolijkezweters;

import be.kuleuven.vrolijkezweters.model.Loper;
import be.kuleuven.vrolijkezweters.model.Persoon;
import be.kuleuven.vrolijkezweters.model.Vrijwilliger;
import be.kuleuven.vrolijkezweters.model.Wedstrijd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class VrijwilligerPersistenceTest {

    private EntityManager entityManager;

    @BeforeEach
    public void setUp() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    @Test
    public void vrijwilligerCanBePersisted() {
        var testPersoon = new Persoon("Gielkens", "Maarten", LocalDate.of(2020, 1 , 8), "M", "maarten.gielkens@student.uhasselt.be", "12345", false);
        var testWedstrijd = new Wedstrijd(10, "Genk", "Hasselt", "12/12/2022");
        var testVrijwilliger = new Vrijwilliger(testPersoon, "Startschot geven");
        testVrijwilliger.voegWedstrijdToe(testWedstrijd);
        testWedstrijd.voegVrijwilligerToe(testVrijwilliger);
        entityManager.persist(testVrijwilliger);
    }
}
