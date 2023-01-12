package be.kuleuven.vrolijkezweters.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import be.kuleuven.vrolijkezweters.database.EtappeResultaatDao;
import be.kuleuven.vrolijkezweters.database.WedstrijdDao;
import be.kuleuven.vrolijkezweters.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class BeheerTijdenToevoegenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_tijd;

    @FXML
    private Button btn_toevoegen;

    @FXML
    private TableView<Wedstrijd> table_wedstrijd;

    @FXML
    private TableColumn<Wedstrijd, LocalDate> table_wedstrijddatum;

    @FXML
    private TableColumn<Wedstrijd, String> table_wedstrijdnaam;

    @FXML
    private TableView<Persoon> table_loper;

    @FXML
    private TableColumn<Persoon, String> table_loperachternaam;

    @FXML
    private TableColumn<Persoon, String> table_lopervoornaam;

    @FXML
    private TableColumn<Persoon, LocalDate> table_lopergeboortedatum;

    @FXML
    private TableView<Etappe> table_etappe;

    @FXML
    private TableColumn<Etappe, String> table_etappelocatie;

    @FXML
    private TableColumn<Etappe, Integer> table_etappelengte;

    @FXML
    private Button btn_selecteerwedstrijd;

    @FXML
    private Button btn_selecteerloper;

    @FXML
    private Button btn_selecteeretappe;

    @FXML
    void initialize() {
        assert txt_tijd != null : "fx:id=\"txt_tijd\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";
        assert btn_toevoegen != null : "fx:id=\"btn_toevoegen\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";
        assert table_wedstrijd != null : "fx:id=\"table_wedstrijd\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";
        assert table_wedstrijddatum != null : "fx:id=\"table_wedstrijddatum\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";
        assert table_wedstrijdnaam != null : "fx:id=\"table_wedstrijdnaam\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";
        assert table_loper != null : "fx:id=\"table_loper\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";
        assert table_loperachternaam != null : "fx:id=\"table_loperachternaam\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";
        assert table_lopervoornaam != null : "fx:id=\"table_lopervoornaam\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";
        assert table_lopergeboortedatum != null : "fx:id=\"table_lopergeboortedatum\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";
        assert table_etappe != null : "fx:id=\"table_etappe\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";
        assert table_etappelocatie != null : "fx:id=\"table_etappelocatie\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";
        assert table_etappelengte != null : "fx:id=\"table_etappelengte\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";
        assert btn_selecteerwedstrijd != null : "fx:id=\"btn_selecteerwedstrijd\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";
        assert btn_selecteerloper != null : "fx:id=\"btn_selecteerloper\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";
        assert btn_selecteeretappe != null : "fx:id=\"btn_selecteeretappe\" was not injected: check your FXML file 'beheertijdentoevoegen.fxml'.";

        zetWedstrijdenInTabel();

        table_etappe.setVisible(false);
        btn_selecteeretappe.setVisible(false);
        table_loper.setVisible(false);
        btn_selecteerloper.setVisible(false);

        btn_selecteerwedstrijd.setOnAction(e -> zetEtappesInTabel());
        btn_selecteeretappe.setOnAction(e -> zetLopersInTabel());
        //btn_selecteerloper.setOnAction(e -> );

        btn_toevoegen.setOnAction(e -> voegEtappeResultaatToe());
    }


    private void zetWedstrijdenInTabel() {
        WedstrijdDao wedstrijdDao = new WedstrijdDao();
        List<Wedstrijd> wedstrijdList = wedstrijdDao.findAlleWedstrijden();

        ObservableList<Wedstrijd> data = FXCollections.observableArrayList();
        table_wedstrijddatum.setCellValueFactory(new PropertyValueFactory<Wedstrijd, LocalDate>("datum"));
        table_wedstrijdnaam.setCellValueFactory(new PropertyValueFactory<Wedstrijd, String>("naam"));

        data.addAll(wedstrijdList);

        table_wedstrijd.setItems(data);
    }

    private void zetEtappesInTabel() {
        table_etappe.setVisible(true);
        btn_selecteeretappe.setVisible(true);

        Wedstrijd wedstrijd = table_wedstrijd.getSelectionModel().getSelectedItem();
        List<Etappe> etappeList = wedstrijd.getEtappes();

        ObservableList<Etappe> data = FXCollections.observableArrayList();
        table_etappelocatie.setCellValueFactory(new PropertyValueFactory<Etappe, String>("locatie"));
        table_etappelengte.setCellValueFactory(new PropertyValueFactory<Etappe, Integer>("lengte"));

        data.addAll(etappeList);

        table_etappe.setItems(data);
    }

    private void zetLopersInTabel() {
        table_loper.setVisible(true);
        btn_selecteerloper.setVisible(true);

        Etappe etappe = table_etappe.getSelectionModel().getSelectedItem();

        List<Loper> alleLopers = new ArrayList<>();
        List<EtappeResultaat> etappeResultaatList = etappe.getEtappeResultaten();

        for (EtappeResultaat etappeResultaat : etappeResultaatList) {
            alleLopers.add(etappeResultaat.getLoper());
        }

        ObservableList<Persoon> data = FXCollections.observableArrayList();
        table_loperachternaam.setCellValueFactory(new PropertyValueFactory<Persoon, String>("naam"));
        table_lopervoornaam.setCellValueFactory(new PropertyValueFactory<Persoon, String>("voornaam"));
        table_lopergeboortedatum.setCellValueFactory(new PropertyValueFactory<Persoon, LocalDate>("geboorteDatum"));

        for (Loper loper : alleLopers) {
            Persoon persoon = loper.getPersoon();
            data.add(persoon);
        }

        table_loper.setItems(data);
    }

    private void voegEtappeResultaatToe() {
        EtappeResultaatDao etappeResultaatDao = new EtappeResultaatDao();
        int tijd = 0;

        Wedstrijd wedstrijd = table_wedstrijd.getSelectionModel().getSelectedItem();
        Etappe etappe = table_etappe.getSelectionModel().getSelectedItem();
        Persoon persoon = table_loper.getSelectionModel().getSelectedItem();

        if (wedstrijd == null || etappe == null || persoon == null) {
            showAlert("Warning", "Je moet zowel een wedstrijd, etappe als persoon selecteren");
        }

        if (txt_tijd.getText() == "") {
            showAlert("Warning", "Je hebt geen tijd opgegeven");
        } else {
            tijd = Integer.parseInt(txt_tijd.getText());

            List<Loper> alleLopers = new ArrayList<>();
            Loper deLoper = new Loper();
            List<EtappeResultaat> etappeResultaatList = etappe.getEtappeResultaten();

            for (EtappeResultaat etappeResultaat : etappeResultaatList) {
                alleLopers.add(etappeResultaat.getLoper());
            }

            for (Loper loper : alleLopers) {
                if (loper.getPersoon().getPersoon_id() == persoon.getPersoon_id()) {
                    deLoper = loper;
                }
            }

            List<EtappeResultaat> etappeResultatenDeLoper = deLoper.getEtappeResultaten();

            for (EtappeResultaat etappeResultaat : etappeResultatenDeLoper) {
                if (etappe.getEtappe_id() == etappeResultaat.getEtappe().getEtappe_id()) {
                    etappeResultaat.setTijd(tijd);
                    etappeResultaatDao.updateEtappeResultaat(etappeResultaat);

                    txt_tijd.setText("");
                    showAlertGelukt("Gelukt", "Het etapperesultaat is gewijzigd naar: " + tijd + " seconden");
                }
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
}
