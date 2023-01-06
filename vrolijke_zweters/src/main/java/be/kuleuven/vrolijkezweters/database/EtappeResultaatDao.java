package be.kuleuven.vrolijkezweters.database;

import be.kuleuven.vrolijkezweters.EntityManagerProvider;
import be.kuleuven.vrolijkezweters.model.EtappeResultaat;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class EtappeResultaatDao {

    private final EntityManager entityManager;

    public EtappeResultaatDao() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    public EtappeResultaat findEtappeResultaatById(Long id) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(EtappeResultaat.class);
        var root = query.from(EtappeResultaat.class);

        query.where(criteriaBuilder.equal(root.get("etappeResultaat_id"), id));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void createEtappeResultaat(EtappeResultaat etappeResultaat) {
        entityManager.getTransaction().begin();
        entityManager.persist(etappeResultaat);
        entityManager.getTransaction().commit();
    }

    public void updateEtappeResultaat(EtappeResultaat etappeResultaat) {
        entityManager.getTransaction().begin();
        entityManager.merge(etappeResultaat);
        entityManager.getTransaction().commit();
    }

    public void deleteEtappeResultaat(EtappeResultaat etappeResultaat) {
        entityManager.getTransaction().begin();
        entityManager.remove(etappeResultaat);
        entityManager.getTransaction().commit();
    }
}
