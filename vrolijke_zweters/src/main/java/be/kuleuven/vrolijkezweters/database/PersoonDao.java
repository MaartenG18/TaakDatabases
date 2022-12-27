package be.kuleuven.vrolijkezweters.database;

import be.kuleuven.vrolijkezweters.EntityManagerProvider;
import be.kuleuven.vrolijkezweters.model.persoon.Persoon;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class PersoonDao {
    private final EntityManager entityManager;

    public PersoonDao() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    public Persoon findPersoonByName(String naam) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Persoon.class); // SELECT .... FROM PERSOON
        var root = query.from(Persoon.class); // SELECT *

        query.where(criteriaBuilder.equal(root.get("naam"), naam));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Persoon findPersoonByEmail(String email) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Persoon.class); // SELECT .... FROM PERSOON
        var root = query.from(Persoon.class); // SELECT *

        query.where(criteriaBuilder.equal(root.get("email"), email));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void createPersoon(Persoon persoon) {
        entityManager.getTransaction().begin();
        entityManager.persist(persoon);
        entityManager.getTransaction().commit();
    }

    public void updatePersoon(Persoon persoon) {
        entityManager.getTransaction().begin();
        entityManager.merge(persoon);
        entityManager.getTransaction().commit();
    }

    public void deletePersoon(Persoon persoon) {
        entityManager.getTransaction().begin();
        entityManager.remove(persoon);
        entityManager.getTransaction().commit();
    }
}
