package be.kuleuven.vrolijkezweters.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import be.kuleuven.vrolijkezweters.database.*;
import be.kuleuven.vrolijkezweters.model.*;
import be.kuleuven.vrolijkezweters.view.InschrijvenLoperView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class InschrijvenLoperController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Wedstrijd> table_wedstrijden;

    @FXML
    private TableColumn<Wedstrijd, LocalDate> table_datum;

    @FXML
    private TableColumn<Wedstrijd, String> table_naam;

    @FXML
    private TableColumn<Wedstrijd, String> table_startlocatie;

    @FXML
    private TableColumn<Wedstrijd, String> table_eindlocatie;

    @FXML
    private TableColumn<Wedstrijd, Integer> table_afstand;

    @FXML
    private TableColumn<Wedstrijd, Integer> table_inschrijvingsgeld;

    @FXML
    private Button btn_inschrijven;

    @FXML
    private TextField txt_fitheid;

    @FXML
    private TextField txt_gewicht;

    @FXML
    void initialize() {
        assert table_wedstrijden != null : "fx:id=\"table_wedstrijden\" was not injected: check your FXML file 'inschrijvenloper.fxml'.";
        assert table_datum != null : "fx:id=\"table_datum\" was not injected: check your FXML file 'inschrijvenloper.fxml'.";
        assert table_naam != null : "fx:id=\"table_naam\" was not injected: check your FXML file 'inschrijvenloper.fxml'.";
        assert table_startlocatie != null : "fx:id=\"table_startlocatie\" was not injected: check your FXML file 'inschrijvenloper.fxml'.";
        assert table_eindlocatie != null : "fx:id=\"table_eindlocatie\" was not injected: check your FXML file 'inschrijvenloper.fxml'.";
        assert table_afstand != null : "fx:id=\"table_afstand\" was not injected: check your FXML file 'inschrijvenloper.fxml'.";
        assert table_inschrijvingsgeld != null : "fx:id=\"table_inschrijvingsgeld\" was not injected: check your FXML file 'inschrijvenloper.fxml'.";
        assert btn_inschrijven != null : "fx:id=\"btn_inschrijven\" was not injected: check your FXML file 'inschrijvenloper.fxml'.";
        assert txt_fitheid != null : "fx:id=\"txt_fitheid\" was not injected: check your FXML file 'inschrijvenloper.fxml'.";
        assert txt_gewicht != null : "fx:id=\"txt_gewicht\" was not injected: check your FXML file 'inschrijvenloper.fxml'.";

        voegWedstrijdenToe();

        btn_inschrijven.setOnAction(e -> inschrijven());
    }


    private void voegWedstrijdenToe() {
        WedstrijdDao wedstrijdDao = new WedstrijdDao();
        List<Wedstrijd> wedstrijdList = wedstrijdDao.findAlleWedstrijden();

        for (Wedstrijd wedstrijd : wedstrijdList) {
            int afstand = 0;
            for (int j = 0; j < wedstrijd.getEtappes().size(); j++) {
                afstand += wedstrijd.getEtappes().get(j).getLengte();
            }
            wedstrijd.setAfstand(afstand);
        }

        LocalDate huidigeDatum = LocalDate.now();

        ObservableList<Wedstrijd> data = FXCollections.observableArrayList();
        table_datum.setCellValueFactory(new PropertyValueFactory<Wedstrijd, LocalDate>("datum"));
        table_naam.setCellValueFactory(new PropertyValueFactory<Wedstrijd, String>("naam"));
        table_startlocatie.setCellValueFactory(new PropertyValueFactory<Wedstrijd, String>("startLocatie"));
        table_eindlocatie.setCellValueFactory(new PropertyValueFactory<Wedstrijd, String>("eindLocatie"));
        table_afstand.setCellValueFactory(new PropertyValueFactory<Wedstrijd, Integer>("afstand"));
        table_inschrijvingsgeld.setCellValueFactory(new PropertyValueFactory<Wedstrijd, Integer>("inschrijvingsgeld"));

        Collections.sort(wedstrijdList, (object1, object2) -> object1.getDatum().compareTo(object2.getDatum()));

        for (Wedstrijd wedstrijd : wedstrijdList) {
            if (wedstrijd.getDatum().isAfter(huidigeDatum)) {
                data.add(wedstrijd);
            }
        }
        table_wedstrijden.setItems(data);
    }

    private void inschrijven() {
        LoperDao loperDao = new LoperDao();
        WedstrijdDao wedstrijdDao = new WedstrijdDao();
        EtappeResultaatDao etappeResultaatDao = new EtappeResultaatDao();

        if (table_wedstrijden.getSelectionModel().getSelectedItem() == null) {
            showAlert("Warning!", "U hebt geen wedstrijd aangeduid");
        } else {
            Wedstrijd wedstrijd = table_wedstrijden.getSelectionModel().getSelectedItem();

            Loper newLoper = new Loper();
            if (!txt_fitheid.getText().isEmpty())
                newLoper.setFitheid(Integer.parseInt(txt_fitheid.getText()));
            if (!txt_gewicht.getText().isEmpty())
                newLoper.setGewicht(Integer.parseInt(txt_gewicht.getText()));
            newLoper.setPersoon(user);

            loperDao.createLoper(newLoper);

            List<Etappe> etappeList = wedstrijd.getEtappes();
            for (Etappe etappe : etappeList) {
                EtappeResultaat etappeResultaat = new EtappeResultaat();
                etappeResultaat.setTijd(0);

                etappe.voegEtappeResultaatToe(etappeResultaat);
                newLoper.voegEtappeResultaatToe(etappeResultaat);
                etappeResultaatDao.createEtappeResultaat(etappeResultaat);
            }

            wedstrijdDao.updateWedstrijd(wedstrijd);

            txt_fitheid.setText("");
            txt_gewicht.setText("");
            showAlertGelukt("Gelukt", "De inschrijving is voltooid!");
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
    private InschrijvenLoperView view;
    private Persoon user;

    public InschrijvenLoperController(InschrijvenLoperView view, Persoon user) {
        this.view = view;
        this.user = user;
    }
}