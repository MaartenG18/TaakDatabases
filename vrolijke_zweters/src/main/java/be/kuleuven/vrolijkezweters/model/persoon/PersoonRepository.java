package be.kuleuven.vrolijkezweters.model.persoon;

import java.util.List;

public interface PersoonRepository {

    List<Persoon> getPersonenByName(String persoon);
    void saveNewPersoon(Persoon persoon);
    void updatePersoon(Persoon persoon);
}
