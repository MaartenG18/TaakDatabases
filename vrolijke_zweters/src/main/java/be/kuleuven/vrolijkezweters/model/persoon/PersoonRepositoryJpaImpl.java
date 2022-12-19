package be.kuleuven.vrolijkezweters.model.persoon;

import javax.persistence.EntityManager;
import java.util.List;

public class PersoonRepositoryJpaImpl implements PersoonRepository{

    private final EntityManager entityManager;

    public PersoonRepositoryJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Persoon> getPersonenByName(String persoon) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Persoon.class);
        var root = query.from(Persoon.class);

        query.where(criteriaBuilder.equal(root.get("naam"), persoon));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void saveNewPersoon(Persoon persoon) {
        entityManager.getTransaction().begin();
        entityManager.persist(persoon);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updatePersoon(Persoon persoon) {
        entityManager.merge(persoon);
    }
}
