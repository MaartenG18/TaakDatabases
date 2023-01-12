package be.kuleuven.vrolijkezweters.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class BeheerWedstrijdToevoegenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_naam;

    @FXML
    private TextField txt_startlocatie;

    @FXML
    private Button btn_wedstrijdetappetoevoegen;

    @FXML
    private DatePicker txt_datum;

    @FXML
    private TextField txt_eindlocatie;

    @FXML
    private TextField txt_inschrijvingsgeld;

    @FXML
    private Button btn_etappetoevoegen;

    @FXML
    private TextField txt_lengte;

    @FXML
    private TextField txt_locatie;

    @FXML
    void initialize() {
        assert txt_naam != null : "fx:id=\"txt_naam\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert txt_startlocatie != null : "fx:id=\"txt_startlocatie\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert btn_wedstrijdetappetoevoegen != null : "fx:id=\"btn_wedstrijdetappetoevoegen\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert txt_datum != null : "fx:id=\"txt_datum\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert txt_eindlocatie != null : "fx:id=\"txt_eindlocatie\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert txt_inschrijvingsgeld != null : "fx:id=\"txt_inschrijvingsgeld\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert btn_etappetoevoegen != null : "fx:id=\"btn_etappetoevoegen\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert txt_lengte != null : "fx:id=\"txt_lengte\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert txt_locatie != null : "fx:id=\"txt_locatie\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";

        btn_wedstrijdetappetoevoegen.setOnAction(e -> wedstrijdToevoegen());
        btn_etappetoevoegen.setOnAction(e -> extraEtappeToevoegen());
    }

    private void wedstrijdToevoegen() {

    }

    private void extraEtappeToevoegen() {

    }
}
