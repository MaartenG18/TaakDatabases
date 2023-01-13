package be.kuleuven.vrolijkezweters.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

import be.kuleuven.vrolijkezweters.model.Wedstrijd;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import be.kuleuven.vrolijkezweters.model.Persoon;

public class KlassementController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Wedstrijd> table_wedstrijd;

    @FXML
    private TableColumn<Wedstrijd, LocalDate> table_wedstrijddatum;

    @FXML
    private TableColumn<Wedstrijd, String> table_wedstrijdnaam;

    @FXML
    private TableColumn<Wedstrijd, String> table_wedstrijdstartlocatie;

    @FXML
    private TableColumn<Wedstrijd, String> table_wedstrijdeindlocatie;

    @FXML
    private TableView<?> table_klassement;

    @FXML
    private TableColumn<?, ?> table_klassementplaats;

    @FXML
    private TableColumn<?, ?> table_klassementtijd;

    @FXML
    private TableColumn<?, ?> table_klassementachternaam;

    @FXML
    private TableColumn<?, ?> table_klassementvoornaam;

    @FXML
    private Button btn_wedstrijdklassement;

    @FXML
    private TableView<?> table_etappe;

    @FXML
    private TableColumn<?, ?> table_etappelocatie;

    @FXML
    private TableColumn<?, ?> table_etappelengte;

    @FXML
    private Button btn_etappeklassement;

    @FXML
    void initialize() {
        assert table_wedstrijd != null : "fx:id=\"table_wedstrijd\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_wedstrijddatum != null : "fx:id=\"table_wedstrijddatum\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_wedstrijdnaam != null : "fx:id=\"table_wedstrijdnaam\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_wedstrijdstartlocatie != null : "fx:id=\"table_wedstrijdstartlocatie\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_wedstrijdeindlocatie != null : "fx:id=\"table_wedstrijdeindlocatie\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_klassement != null : "fx:id=\"table_klassement\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_klassementplaats != null : "fx:id=\"table_klassementplaats\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_klassementtijd != null : "fx:id=\"table_klassementtijd\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_klassementachternaam != null : "fx:id=\"table_klassementachternaam\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_klassementvoornaam != null : "fx:id=\"table_klassementvoornaam\" was not injected: check your FXML file 'klassement.fxml'.";
        assert btn_wedstrijdklassement != null : "fx:id=\"btn_wedstrijdklassement\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_etappe != null : "fx:id=\"table_etappe\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_etappelocatie != null : "fx:id=\"table_etappelocatie\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_etappelengte != null : "fx:id=\"table_etappelengte\" was not injected: check your FXML file 'klassement.fxml'.";
        assert btn_etappeklassement != null : "fx:id=\"btn_etappeklassement\" was not injected: check your FXML file 'klassement.fxml'.";

        voegWedstrijdenToe();

        btn_wedstrijdklassement.setOnAction(e -> toonWedstrijdKlassement());
        btn_etappeklassement.setOnAction(e -> toonEtappeKlassement());
    }

    private void voegWedstrijdenToe() {

    }

    private void toonWedstrijdKlassement() {

    }

    private void toonEtappeKlassement() {

    }


    private Persoon user;

    public KlassementController(Persoon user) {
        this.user = user;
    }
}
