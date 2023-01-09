package be.kuleuven.vrolijkezweters.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import be.kuleuven.vrolijkezweters.database.VrijwilligerDao;
import be.kuleuven.vrolijkezweters.database.WedstrijdDao;
import be.kuleuven.vrolijkezweters.model.Persoon;
import be.kuleuven.vrolijkezweters.model.Vrijwilliger;
import be.kuleuven.vrolijkezweters.model.Wedstrijd;
import be.kuleuven.vrolijkezweters.view.InschrijvenVrijwilligerView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class InschrijvenVrijwilligerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Wedstrijd> table_wedstrijden;

    @FXML
    private TableColumn<Wedstrijd, Integer> table_id;

    @FXML
    private TableColumn<Wedstrijd, LocalDate> table_datum;

    @FXML
    private TableColumn<Wedstrijd, String> table_naam;

    @FXML
    private TableColumn<Wedstrijd, String> table_startlocatie;

    @FXML
    private TableColumn<Wedstrijd, String> table_eindlocatie;

    @FXML
    private Button btn_inschrijven;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_taak;

    @FXML
    void initialize() {
        assert table_wedstrijden != null : "fx:id=\"table_wedstrijden\" was not injected: check your FXML file 'inschrijvenVrijwilliger.fxml'.";
        assert table_id != null : "fx:id=\"table_id\" was not injected: check your FXML file 'inschrijvenVrijwilliger.fxml'.";
        assert table_datum != null : "fx:id=\"table_datum\" was not injected: check your FXML file 'inschrijvenVrijwilliger.fxml'.";
        assert table_naam != null : "fx:id=\"table_naam\" was not injected: check your FXML file 'inschrijvenVrijwilliger.fxml'.";
        assert table_startlocatie != null : "fx:id=\"table_startlocatie\" was not injected: check your FXML file 'inschrijvenVrijwilliger.fxml'.";
        assert table_eindlocatie != null : "fx:id=\"table_eindlocatie\" was not injected: check your FXML file 'inschrijvenVrijwilliger.fxml'.";
        assert btn_inschrijven != null : "fx:id=\"btn_inschrijven\" was not injected: check your FXML file 'inschrijvenVrijwilliger.fxml'.";
        assert txt_id != null : "fx:id=\"txt_id\" was not injected: check your FXML file 'inschrijvenVrijwilliger.fxml'.";
        assert txt_taak != null : "fx:id=\"txt_taak\" was not injected: check your FXML file 'inschrijvenVrijwilliger.fxml'.";

        voegWedstrijdenToe();

        btn_inschrijven.setOnAction(e -> inschrijven());
    }

    private void voegWedstrijdenToe() {
        WedstrijdDao wedstrijdDao = new WedstrijdDao();
        List<Wedstrijd> wedstrijdList = wedstrijdDao.findAlleWedstrijden();
        LocalDate huidigeDatum = LocalDate.now();

        ObservableList<Wedstrijd> data = FXCollections.observableArrayList();
        table_id.setCellValueFactory(new PropertyValueFactory<Wedstrijd, Integer>("wedstrijd_id"));
        table_datum.setCellValueFactory(new PropertyValueFactory<Wedstrijd, LocalDate>("datum"));
        table_naam.setCellValueFactory(new PropertyValueFactory<Wedstrijd, String>("naam"));
        table_startlocatie.setCellValueFactory(new PropertyValueFactory<Wedstrijd, String>("startLocatie"));
        table_eindlocatie.setCellValueFactory(new PropertyValueFactory<Wedstrijd, String>("eindLocatie"));

        for (Wedstrijd wedstrijd : wedstrijdList) {
            if (wedstrijd.getDatum().isAfter(huidigeDatum)) {
                data.add(wedstrijd);
            }
        }
        table_wedstrijden.setItems(data);
    }

    private void inschrijven() {
        VrijwilligerDao vrijwilligerDao = new VrijwilligerDao();
        WedstrijdDao wedstrijdDao = new WedstrijdDao();

        if (txt_id.getText().isEmpty() || txt_taak.getText().isEmpty()) {
            showAlert("Warning!", "Er ontbreken gegevens in de verplichte velden");
        } else {
            int wedstrijdId = Integer.parseInt(txt_id.getText());
            Wedstrijd wedstrijd = wedstrijdDao.findWedstrijdById(wedstrijdId);

            if (wedstrijd == null) {
                showAlert("Warning!", "Het id staat niet in de lijst");
            } else {
                Vrijwilliger newVrijwilliger = new Vrijwilliger();
                newVrijwilliger.setTaak(txt_taak.getText());
                newVrijwilliger.setPersoon(user);
                newVrijwilliger.voegWedstrijdToe(wedstrijd);

                wedstrijd.voegVrijwilligerToe(newVrijwilliger);

                vrijwilligerDao.createVrijwilliger(newVrijwilliger);
                wedstrijdDao.updateWedstrijd(wedstrijd);

                showAlertGelukt("Gelukt", "De inschrijving is voltooid!");
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


    //moet de view hier ook nog bij? Daar ben ik nie zeker van
    private InschrijvenVrijwilligerView view;
    private Persoon user;

    public InschrijvenVrijwilligerController(InschrijvenVrijwilligerView view, Persoon user) {
        this.view = view;
        this.user = user;
    }
}