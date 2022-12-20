package be.kuleuven.vrolijkezweters;

import be.kuleuven.vrolijkezweters.model.persoon.Persoon;
import be.kuleuven.vrolijkezweters.model.vrijwilliger.Vrijwilliger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VrijwilligerPersistenceTest {

    private EntityManagerFactory factory;
    private EntityManager entityManager;

    @BeforeEach
    public void setUp() {
        this.factory = Persistence.createEntityManagerFactory("be.kuleuven.vrolijkezweters.model");
        this.entityManager = factory.createEntityManager();
    }

    @AfterEach
    public void tearDown() {
        factory.close();
    }

    @Test
    public void vrijwilligerCanBePersisted() {
        var jos = new Persoon("Lowiemans", "Jos", "15011999", 'M');
        Vrijwilliger josZijnEersteTaak = new Vrijwilliger();
        josZijnEersteTaak.setTaak("Water geven");

        josZijnEersteTaak.setNaam(jos.getNaam());
        josZijnEersteTaak.setVoornaam(jos.getVoornaam());
        josZijnEersteTaak.setGender(jos.getGender());
        josZijnEersteTaak.setGeboorteDatum(jos.getGeboorteDatum());
        entityManager.persist(jos);
    }
}
