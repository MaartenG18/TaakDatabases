package be.kuleuven.vrolijkezweters.controller;

import be.kuleuven.vrolijkezweters.model.Persoon;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class DeelnamesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> table_loper;

    @FXML
    private TableView<?> table_vrijwilliger;

    @FXML
    void initialize() {
        assert table_loper != null : "fx:id=\"table_loper\" was not injected: check your FXML file 'deelnames.fxml'.";
        assert table_vrijwilliger != null : "fx:id=\"table_vrijwilliger\" was not injected: check your FXML file 'deelnames.fxml'.";

    }

    private Persoon user;

    public DeelnamesController(Persoon user) {
        this.user = user;
    }
}
