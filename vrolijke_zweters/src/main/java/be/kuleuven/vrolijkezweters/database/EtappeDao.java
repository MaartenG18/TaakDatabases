package be.kuleuven.vrolijkezweters.database;

import be.kuleuven.vrolijkezweters.EntityManagerProvider;
import be.kuleuven.vrolijkezweters.model.Etappe;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class EtappeDao {

    private final EntityManager entityManager;

    public EtappeDao() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    public Etappe findEtappeById(Long id) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Etappe.class);
        var root = query.from(Etappe.class);

        query.where(criteriaBuilder.equal(root.get("etappe_id"), id));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Etappe> findAllEtappesFromWedstrijdWithId(Long wedstrijd_id) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Etappe.class);
        var root = query.from(Etappe.class);

        query.where(criteriaBuilder.equal(root.get("wedstrijd").get("id"), wedstrijd_id));

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }


    public void createEtappe(Etappe etappe) {
        entityManager.getTransaction().begin();
        entityManager.persist(etappe);
        entityManager.getTransaction().commit();
    }

    public void updateEtappe(Etappe etappe) {
        entityManager.getTransaction().begin();
        entityManager.merge(etappe);
        entityManager.getTransaction().commit();
    }

    public void deleteEtappe(Etappe etappe) {
        entityManager.getTransaction().begin();
        entityManager.remove(etappe);
        entityManager.getTransaction().commit();
    }
}
