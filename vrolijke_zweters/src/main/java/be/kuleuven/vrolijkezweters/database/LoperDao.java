package be.kuleuven.vrolijkezweters.database;

import be.kuleuven.vrolijkezweters.EntityManagerProvider;
import be.kuleuven.vrolijkezweters.model.Loper;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class LoperDao {
    private final EntityManager entityManager;

    public LoperDao() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    public Loper findLoperById(Long id) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Loper.class);
        var root = query.from(Loper.class);

        query.where(criteriaBuilder.equal(root.get("loopNummer"), id));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void createLoper(Loper loper) {
        entityManager.getTransaction().begin();
        entityManager.persist(loper);
        entityManager.getTransaction().commit();
    }

    public void updateLoper(Loper loper) {
        entityManager.getTransaction().begin();
        entityManager.merge(loper);
        entityManager.getTransaction().commit();
    }

    public void deleteLoper(Loper loper) {
        entityManager.getTransaction().begin();
        entityManager.remove(loper);
        entityManager.getTransaction().commit();
    }
}
