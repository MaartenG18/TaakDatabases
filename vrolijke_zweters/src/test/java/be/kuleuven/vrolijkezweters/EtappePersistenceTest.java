package be.kuleuven.vrolijkezweters;

import be.kuleuven.vrolijkezweters.model.Etappe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

public class EtappePersistenceTest {

    private EntityManager entityManager;

    @BeforeEach
    public void setUp() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    @Test
    public void etappeCanBePersisted() {
        var testEtappe = new Etappe(2, "Genk");
        entityManager.persist(testEtappe);
    }
}
