package be.kuleuven.vrolijkezweters.model.vrijwilliger;

import be.kuleuven.vrolijkezweters.model.vrijwilliger.Vrijwilliger;

import javax.persistence.EntityManager;
import java.util.List;

public class VrijwilligerRepositoryJpaImpl implements VrijwilligerRepository {

    private final EntityManager entityManager;

    public VrijwilligerRepositoryJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Vrijwilliger> getVrijwilligersByTaak(String taak) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Vrijwilliger.class);
        var root = query.from(Vrijwilliger.class);

        query.where(criteriaBuilder.equal(root.get("taak"), taak));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void saveNewVrijwilliger(Vrijwilliger vrijwilliger) {
        entityManager.getTransaction().begin();
        entityManager.persist(vrijwilliger);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateVrijwilliger(Vrijwilliger vrijwilliger) {
        entityManager.merge(vrijwilliger);
    }
}
