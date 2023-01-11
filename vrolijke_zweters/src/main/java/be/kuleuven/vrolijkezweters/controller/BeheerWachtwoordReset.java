package be.kuleuven.vrolijkezweters.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import be.kuleuven.vrolijkezweters.database.PersoonDao;
import be.kuleuven.vrolijkezweters.model.Persoon;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BeheerWachtwoordReset {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_voornaam;

    @FXML
    private TextField txt_achternaam;

    @FXML
    private Button btn_reset;

    @FXML
    void initialize() {
        assert txt_voornaam != null : "fx:id=\"txt_voornaam\" was not injected: check your FXML file 'beheerwachtwoordreset.fxml'.";
        assert txt_achternaam != null : "fx:id=\"txt_achternaam\" was not injected: check your FXML file 'beheerwachtwoordreset.fxml'.";
        assert btn_reset != null : "fx:id=\"btn_reset\" was not injected: check your FXML file 'beheerwachtwoordreset.fxml'.";

        btn_reset.setOnAction(e -> resetWachtwoord());
    }


    private void resetWachtwoord() {
        PersoonDao persoonDao = new PersoonDao();

        String voornaam = txt_voornaam.getText();
        String achternaam = txt_achternaam.getText();

        List<Persoon> personenVoornaam = persoonDao.findPersoonByFirstName(voornaam);
        List<Persoon> personenAchternaam = persoonDao.findPersoonByName(achternaam);

        if (personenVoornaam == null || personenAchternaam == null) {
            showAlert("Warning", "Deze persoon bestaat niet");
        } else {
            personenVoornaam.retainAll(personenAchternaam);
            if (personenVoornaam.size() == 1) {
                txt_voornaam.setText("");
                txt_achternaam.setText("");

                personenVoornaam.get(0).setWachtwoord("vrolijkeZweter");
                persoonDao.updatePersoon(personenVoornaam.get(0));

                showAlertGelukt("Gelukt", "Het wachtwoord is gereset");
            } else {
                showAlert("Warning", "Deze persoon is geen gekende gebruiker. Kijk de spelling nog eens na");
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