package be.kuleuven.vrolijkezweters.database;

import be.kuleuven.vrolijkezweters.EntityManagerProvider;
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
        var testWedstrijd = new Wedstrijd(10, "Genk", "Hasselt", LocalDate.of(2022, 12, 12));
        var testVrijwilliger = new Vrijwilliger("Startschot geven");
        testVrijwilliger.voegWedstrijdToe(testWedstrijd);
        testWedstrijd.voegVrijwilligerToe(testVrijwilliger);
        testVrijwilliger.setPersoon(testPersoon);
        entityManager.persist(testPersoon);
        entityManager.persist(testVrijwilliger);
    }
}
