package be.kuleuven.vrolijkezweters.controller;

import be.kuleuven.vrolijkezweters.ScreenOpener;
import be.kuleuven.vrolijkezweters.model.Persoon;
import be.kuleuven.vrolijkezweters.view.HomeView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnDeelnames;

    @FXML
    private Button btnInschrijvingen;

    @FXML
    private Button btnUitloggen;

    @FXML
    private Text txt_afstand;

    @FXML
    private Text txt_datum;

    @FXML
    private Text txt_eindlocatie;

    @FXML
    private Text txt_startlocatie;

    @FXML
    private Text txt_titel;

    @FXML
    void initialize() {
        assert btnAdmin != null : "fx:id=\"btnAdmin\" was not injected: check your FXML file 'main.fxml'.";
        assert btnDeelnames != null : "fx:id=\"btnDeelnames\" was not injected: check your FXML file 'main.fxml'.";
        assert btnInschrijvingen != null : "fx:id=\"btnInschrijvingen\" was not injected: check your FXML file 'main.fxml'.";
        assert btnUitloggen != null : "fx:id=\"btnUitloggen\" was not injected: check your FXML file 'main.fxml'.";
        assert txt_afstand != null : "fx:id=\"txt_afstand\" was not injected: check your FXML file 'main.fxml'.";
        assert txt_datum != null : "fx:id=\"txt_datum\" was not injected: check your FXML file 'main.fxml'.";
        assert txt_eindlocatie != null : "fx:id=\"txt_eindlocatie\" was not injected: check your FXML file 'main.fxml'.";
        assert txt_startlocatie != null : "fx:id=\"txt_startlocatie\" was not injected: check your FXML file 'main.fxml'.";
        assert txt_titel != null : "fx:id=\"txt_titel\" was not injected: check your FXML file 'main.fxml'.";

        if (user.isAdmin()) {
            btnAdmin.setVisible(true);
        }

        btnAdmin.setOnAction(e -> new ScreenOpener("admin"));

        btnUitloggen.setOnAction(e -> {
            new ScreenOpener("login");
            view.stop();
        });
    }

    private HomeView view;
    private Persoon user;

    public HomeController(HomeView view, Persoon user) {
        this.view = view;
        this.user = user;
    }
}
