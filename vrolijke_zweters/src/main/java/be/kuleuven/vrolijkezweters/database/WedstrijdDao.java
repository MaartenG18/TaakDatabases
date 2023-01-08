package be.kuleuven.vrolijkezweters.database;

import be.kuleuven.vrolijkezweters.EntityManagerProvider;
import be.kuleuven.vrolijkezweters.model.Wedstrijd;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.net.http.WebSocket;
import java.time.LocalDate;
import java.util.List;

public class WedstrijdDao {
    private final EntityManager entityManager;

    public WedstrijdDao () {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    public Wedstrijd findWedstrijdByStartLocation(String location) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Wedstrijd.class);
        var root = query.from(Wedstrijd.class);

        query.where(criteriaBuilder.equal(root.get("startLocatie"), location));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Wedstrijd findWedstrijdByDate(LocalDate datum) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Wedstrijd.class);
        var root = query.from(Wedstrijd.class);

        query.where(criteriaBuilder.equal(root.get("datum"), datum));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Wedstrijd> findAlleWedstrijden() {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Wedstrijd.class);
        var root = query.from(Wedstrijd.class);

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void createWedstrijd(Wedstrijd wedstrijd) {
        entityManager.getTransaction().begin();
        entityManager.persist(wedstrijd);
        entityManager.getTransaction().commit();
    }

    public void updateWedstrijd(Wedstrijd wedstrijd) {
        entityManager.getTransaction().begin();
        entityManager.merge(wedstrijd);
        entityManager.getTransaction().commit();
    }

    public void deleteWedstrijd(Wedstrijd wedstrijd) {
        entityManager.getTransaction().begin();
        entityManager.remove(wedstrijd);
        entityManager.getTransaction().commit();
    }
}
