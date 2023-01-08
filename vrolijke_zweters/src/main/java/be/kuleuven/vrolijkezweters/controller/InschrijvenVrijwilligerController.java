package be.kuleuven.vrolijkezweters.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InschrijvenVrijwilligerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> table_wedstrijden;

    @FXML
    private TableColumn<?, ?> table_id;

    @FXML
    private TableColumn<?, ?> table_datum;

    @FXML
    private TableColumn<?, ?> table_startlocatie;

    @FXML
    private TableColumn<?, ?> table_eindlocatie;

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
        assert table_startlocatie != null : "fx:id=\"table_startlocatie\" was not injected: check your FXML file 'inschrijvenVrijwilliger.fxml'.";
        assert table_eindlocatie != null : "fx:id=\"table_eindlocatie\" was not injected: check your FXML file 'inschrijvenVrijwilliger.fxml'.";
        assert btn_inschrijven != null : "fx:id=\"btn_inschrijven\" was not injected: check your FXML file 'inschrijvenVrijwilliger.fxml'.";
        assert txt_id != null : "fx:id=\"txt_id\" was not injected: check your FXML file 'inschrijvenVrijwilliger.fxml'.";
        assert txt_taak != null : "fx:id=\"txt_taak\" was not injected: check your FXML file 'inschrijvenVrijwilliger.fxml'.";
    }
}
