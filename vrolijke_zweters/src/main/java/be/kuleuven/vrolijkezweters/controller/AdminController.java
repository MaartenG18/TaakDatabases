package be.kuleuven.vrolijkezweters.controller;

import be.kuleuven.vrolijkezweters.ProjectMain;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_wedstrijdtoevoegen;

    @FXML
    private Button btn_tijdentoevoegen;

    @FXML
    private Button btn_wachtwoordresetten;

    @FXML
    private Button btn_accountverwijderen;

    @FXML
    private Button btn_vrijwilligerswedstrijd;

    @FXML
    void initialize() {
        assert btn_wedstrijdtoevoegen != null : "fx:id=\"btn_wedstrijdtoevoegen\" was not injected: check your FXML file 'admin.fxml'.";
        assert btn_tijdentoevoegen != null : "fx:id=\"btn_tijdentoevoegen\" was not injected: check your FXML file 'admin.fxml'.";
        assert btn_wachtwoordresetten != null : "fx:id=\"btn_wachtwoordresetten\" was not injected: check your FXML file 'admin.fxml'.";
        assert btn_accountverwijderen != null : "fx:id=\"btn_accountverwijderen\" was not injected: check your FXML file 'admin.fxml'.";
        assert btn_vrijwilligerswedstrijd != null : "fx:id=\"btn_vrijwilligerswedstrijd\" was not injected: check your FXML file 'admin.fxml'.";

        btn_wedstrijdtoevoegen.setOnAction(e -> showBeheerScherm("wedstrijdToevoegen"));
        btn_tijdentoevoegen.setOnAction(e -> showBeheerScherm("tijdenToevoegen"));
        btn_wachtwoordresetten.setOnAction(e -> showBeheerScherm("wachtwoordReset"));
        btn_accountverwijderen.setOnAction(e -> showBeheerScherm("accountVerwijderen"));
        btn_vrijwilligerswedstrijd.setOnAction(e -> showBeheerScherm("vrijwilligersWedstrijd"));
    }

    private void showBeheerScherm(String id) {
        var resourceName = "beheer" + id + ".fxml";
        try {
            var stage = new Stage();
            var root = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource(resourceName));
            var scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Admin - " + id);
            stage.initOwner(ProjectMain.getRootStage());
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();

        } catch (Exception e) {
            throw new RuntimeException("Kan beheerscherm " + resourceName + " niet vinden", e);
        }
    }
}