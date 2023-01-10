package be.kuleuven.vrolijkezweters.controller;

import be.kuleuven.vrolijkezweters.database.LoperDao;
import be.kuleuven.vrolijkezweters.database.PersoonDao;
import be.kuleuven.vrolijkezweters.database.VrijwilligerDao;
import be.kuleuven.vrolijkezweters.model.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import be.kuleuven.vrolijkezweters.model.semi.LoperWedstrijd;
import be.kuleuven.vrolijkezweters.model.semi.VrijwilligerWedstrijd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class DeelnamesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<LoperWedstrijd> table_loper;

    @FXML
    private TableColumn<LoperWedstrijd, Long> table_loperid;

    @FXML
    private TableColumn<LoperWedstrijd, String> table_lopernaam;

    @FXML
    private TableColumn<LoperWedstrijd, LocalDate> table_loperdatum;

    @FXML
    private TableColumn<LoperWedstrijd, Integer> table_lopertijd;

    @FXML
    private TableView<VrijwilligerWedstrijd> table_vrijwilliger;

    @FXML
    private TableColumn<VrijwilligerWedstrijd, Integer> table_vrijwilligerid;

    @FXML
    private TableColumn<VrijwilligerWedstrijd, String> table_vrijwilligernaam;

    @FXML
    private TableColumn<VrijwilligerWedstrijd, LocalDate> table_vrijwilligerdatum;

    @FXML
    private TableColumn<VrijwilligerWedstrijd, String> table_vrijwilligertaak;

    @FXML
    private Button btn_verwijderenloper;

    @FXML
    private TextField txt_verwijderenloper;

    @FXML
    private Button btn_verwijderenvrijwilliger;

    @FXML
    private TextField txt_verwijderenvrijwilliger;

    @FXML
    void initialize() {
        assert table_loper != null : "fx:id=\"table_loper\" was not injected: check your FXML file 'deelnames.fxml'.";
        assert table_loperid != null : "fx:id=\"table_loperid\" was not injected: check your FXML file 'deelnames.fxml'.";
        assert table_lopernaam != null : "fx:id=\"table_lopernaam\" was not injected: check your FXML file 'deelnames.fxml'.";
        assert table_loperdatum != null : "fx:id=\"table_loperdatum\" was not injected: check your FXML file 'deelnames.fxml'.";
        assert table_lopertijd != null : "fx:id=\"table_loperresultaat\" was not injected: check your FXML file 'deelnames.fxml'.";
        assert table_vrijwilliger != null : "fx:id=\"table_vrijwilliger\" was not injected: check your FXML file 'deelnames.fxml'.";
        assert table_vrijwilligerid != null : "fx:id=\"table_vrijwilligerid\" was not injected: check your FXML file 'deelnames.fxml'.";
        assert table_vrijwilligernaam != null : "fx:id=\"table_vrijwilligernaam\" was not injected: check your FXML file 'deelnames.fxml'.";
        assert table_vrijwilligerdatum != null : "fx:id=\"table_vrijwilligerdatum\" was not injected: check your FXML file 'deelnames.fxml'.";
        assert table_vrijwilligertaak != null : "fx:id=\"table_vrijwilligertaak\" was not injected: check your FXML file 'deelnames.fxml'.";
        assert btn_verwijderenloper != null : "fx:id=\"btn_verwijderenloper\" was not injected: check your FXML file 'deelnames.fxml'.";
        assert txt_verwijderenloper != null : "fx:id=\"txt_verwijderenloper\" was not injected: check your FXML file 'deelnames.fxml'.";
        assert btn_verwijderenvrijwilliger != null : "fx:id=\"btn_verwijderenvrijwilliger\" was not injected: check your FXML file 'deelnames.fxml'.";
        assert txt_verwijderenvrijwilliger != null : "fx:id=\"txt_verwijderenvrijwilliger\" was not injected: check your FXML file 'deelnames.fxml'.";

        voegInschrijvingenLoperToe(user);
        voegInschrijvingenVrijwilligerToe(user);

        btn_verwijderenloper.setOnAction(e -> verwijderInschrijvingLoper());
        btn_verwijderenvrijwilliger.setOnAction(e -> verwijderInschrijvingVrijwilliger());
    }


    private void voegInschrijvingenLoperToe(Persoon user) {
        List<Loper> loperList = user.getLopers();
        List<LoperWedstrijd> newList = new ArrayList<>();

        for (Loper loper : loperList) {
            List<EtappeResultaat> etappeResultaatList = loper.getEtappeResultaten();

            int totaleTijd = 0;
            for (EtappeResultaat etappeResultaat : etappeResultaatList) {
                totaleTijd += etappeResultaat.getTijd();
            }

            LoperWedstrijd newElement = new LoperWedstrijd();
            newElement.setLoopNummer(loper.getLoopNummer());
            if (etappeResultaatList.size() > 0) {
                newElement.setDatum(etappeResultaatList.get(0).getEtappe().getWedstrijd().getDatum());
                newElement.setNaam(etappeResultaatList.get(0).getEtappe().getWedstrijd().getNaam());
            } else {
                newElement.setDatum(LocalDate.of(2000, 1, 1));
                newElement.setNaam("geen naam gevonden");
            }
            newElement.setTijd(totaleTijd);

            newList.add(newElement);
        }

        ObservableList<LoperWedstrijd> data = FXCollections.observableArrayList();
        table_loperid.setCellValueFactory(new PropertyValueFactory<LoperWedstrijd, Long>("loopNummer"));
        table_loperdatum.setCellValueFactory(new PropertyValueFactory<LoperWedstrijd, LocalDate>("datum"));
        table_lopernaam.setCellValueFactory(new PropertyValueFactory<LoperWedstrijd, String>("naam"));
        table_lopertijd.setCellValueFactory(new PropertyValueFactory<LoperWedstrijd, Integer>("tijd"));

        //Collections.sort(newList, (object1, object2) -> object1.getDatum().compareTo(object2.getDatum())); //op datum sorteren, later testen

        data.addAll(newList);
        table_loper.setItems(data);
    }

    private void voegInschrijvingenVrijwilligerToe(Persoon user) {
        List<Vrijwilliger> vrijwilligerList = user.getVrijwilligers();
        List<VrijwilligerWedstrijd> newList = new ArrayList<>();

        for (Vrijwilliger vrijwilliger : vrijwilligerList) {
            Wedstrijd wedstrijd = vrijwilliger.getWedstrijden().get(0);

            VrijwilligerWedstrijd newElement = new VrijwilligerWedstrijd();
            newElement.setVrijwilliger_id(vrijwilliger.getVrijwilliger_id());
            newElement.setDatum(wedstrijd.getDatum());
            newElement.setNaam(wedstrijd.getNaam());
            newElement.setTaak(vrijwilliger.getTaak());

            newList.add(newElement);
        }

        ObservableList<VrijwilligerWedstrijd> data = FXCollections.observableArrayList();
        table_vrijwilligerid.setCellValueFactory(new PropertyValueFactory<VrijwilligerWedstrijd, Integer>("vrijwilliger_id"));
        table_vrijwilligerdatum.setCellValueFactory(new PropertyValueFactory<VrijwilligerWedstrijd, LocalDate>("datum"));
        table_vrijwilligernaam.setCellValueFactory(new PropertyValueFactory<VrijwilligerWedstrijd, String>("naam"));
        table_vrijwilligertaak.setCellValueFactory(new PropertyValueFactory<VrijwilligerWedstrijd, String>("taak"));

        //Collections.sort(newList, (object1, object2) -> object1.getDatum().compareTo(object2.getDatum())); //op datum sorteren, later testen

        data.addAll(newList);
        table_vrijwilliger.setItems(data);
    }

    private void verwijderInschrijvingLoper() {
        PersoonDao persoonDao = new PersoonDao();
        LoperDao loperDao = new LoperDao();
        Long id = Long.valueOf(txt_verwijderenloper.getText());

        if (loperDao.findLoperById(id) == null) {
            showAlert("Warning!", "Het opgegeven id bestaat niet");
        } else {
            Loper loper = loperDao.findLoperById(id);
            Persoon persoon = loper.getPersoon();

            if (persoon.getPersoon_id() != user.getPersoon_id()) {
                showAlert("Warning!", "Het opgegeven id klopt niet");
            } else {
                loperDao.deleteLoper(loper);
                persoonDao.updatePersoon(persoon);

                voegInschrijvingenLoperToe(persoon);

                txt_verwijderenloper.setText("");
                showAlertGelukt("Gelukt", "Het uitschrijven is voltooid!");
            }
        }
    }

    private void verwijderInschrijvingVrijwilliger() {
        PersoonDao persoonDao = new PersoonDao();
        VrijwilligerDao vrijwilligerDao = new VrijwilligerDao();
        Long id = Long.valueOf(txt_verwijderenvrijwilliger.getText());

        if (vrijwilligerDao.findVrijwilligerById(id) == null) {
            showAlert("Warning!", "Het opgegeven id bestaat niet");
        } else {
            Vrijwilliger vrijwilliger = vrijwilligerDao.findVrijwilligerById(id);
            Persoon persoon = vrijwilliger.getPersoon();

            if (persoon.getPersoon_id() != user.getPersoon_id()) {
                showAlert("Warning!", "Het opgegeven id klopt niet");
            } else {
                vrijwilligerDao.deleteVrijwilliger(vrijwilliger);
                persoonDao.updatePersoon(persoon);

                voegInschrijvingenVrijwilligerToe(persoon);

                txt_verwijderenvrijwilliger.setText("");
                showAlertGelukt("Gelukt", "Het uitschrijven is voltooid!");
            }
        }
    }

    public void showAlert(String title, String content) {
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void showAlertGelukt(String title, String content) {
        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }


    private Persoon user;

    public DeelnamesController(Persoon user) {
        this.user = user;
    }
}
