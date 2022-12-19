package be.kuleuven.vrolijkezweters;

import be.kuleuven.vrolijkezweters.model.persoon.Persoon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersoonPersistenceTest {

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
    public void persoonCanBePersisted() {
        var jos = new Persoon("Lowiemans", "Jos", "15011999", 'M');
        entityManager.persist(jos);
    }
}
