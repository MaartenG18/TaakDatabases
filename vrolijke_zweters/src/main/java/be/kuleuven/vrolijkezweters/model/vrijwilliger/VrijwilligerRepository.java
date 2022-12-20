package be.kuleuven.vrolijkezweters.model.vrijwilliger;

import be.kuleuven.vrolijkezweters.model.vrijwilliger.Vrijwilliger;

import java.util.List;

public interface VrijwilligerRepository {

    List<Vrijwilliger> getVrijwilligersByTaak(String taak);
    void saveNewVrijwilliger(Vrijwilliger vrijwilliger);
    void updateVrijwilliger(Vrijwilliger vrijwilliger);
}
