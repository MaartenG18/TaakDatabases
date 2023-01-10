package be.kuleuven.vrolijkezweters.database;

import be.kuleuven.vrolijkezweters.EntityManagerProvider;
import be.kuleuven.vrolijkezweters.model.Vrijwilliger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class VrijwilligerDao {
    private final EntityManager entityManager;

    public VrijwilligerDao() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    public Vrijwilliger findVrijwilligerById(Long id) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Vrijwilliger.class);
        var root = query.from(Vrijwilliger.class);

        query.where(criteriaBuilder.equal(root.get("vrijwilliger_id"), id));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void createVrijwilliger(Vrijwilliger vrijwilliger) {
        entityManager.getTransaction().begin();
        entityManager.persist(vrijwilliger);
        entityManager.getTransaction().commit();
    }

    public void updateVrijwilliger(Vrijwilliger vrijwilliger) {
        entityManager.getTransaction().begin();
        entityManager.merge(vrijwilliger);
        entityManager.getTransaction().commit();
    }

    public void deleteVrijwilliger(Vrijwilliger vrijwilliger) {
        entityManager.getTransaction().begin();
        entityManager.remove(vrijwilliger);
        entityManager.getTransaction().commit();
    }
}
