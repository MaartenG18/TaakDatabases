package be.kuleuven.vrolijkezweters.controller;

import be.kuleuven.vrolijkezweters.database.PersoonDao;
import be.kuleuven.vrolijkezweters.model.Persoon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GegevensController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_voornaam;

    @FXML
    private Label label_achternaam;

    @FXML
    private Label label_geboortedatum;

    @FXML
    private Label label_gender;

    @FXML
    private Label label_email;

    @FXML
    private Label label_wachtwoord;

    @FXML
    private TextField txt_voornaam;

    @FXML
    private TextField txt_achternaam;

    @FXML
    private TextField txt_gender;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_wachtwoord;

    @FXML
    private Button btn_aanpassen;

    @FXML
    void initialize() {
        assert label_voornaam != null : "fx:id=\"label_voornaam\" was not injected: check your FXML file 'gegevens.fxml'.";
        assert label_achternaam != null : "fx:id=\"label_achternaam\" was not injected: check your FXML file 'gegevens.fxml'.";
        assert label_geboortedatum != null : "fx:id=\"label_geboortedatum\" was not injected: check your FXML file 'gegevens.fxml'.";
        assert label_gender != null : "fx:id=\"label_gender\" was not injected: check your FXML file 'gegevens.fxml'.";
        assert label_email != null : "fx:id=\"label_email\" was not injected: check your FXML file 'gegevens.fxml'.";
        assert label_wachtwoord != null : "fx:id=\"label_paswoord\" was not injected: check your FXML file 'gegevens.fxml'.";
        assert txt_voornaam != null : "fx:id=\"txt_voornaam\" was not injected: check your FXML file 'gegevens.fxml'.";
        assert txt_achternaam != null : "fx:id=\"txt_achternaam\" was not injected: check your FXML file 'gegevens.fxml'.";
        assert txt_gender != null : "fx:id=\"txt_gender\" was not injected: check your FXML file 'gegevens.fxml'.";
        assert txt_email != null : "fx:id=\"txt_email\" was not injected: check your FXML file 'gegevens.fxml'.";
        assert txt_wachtwoord != null : "fx:id=\"txt_paswoord\" was not injected: check your FXML file 'gegevens.fxml'.";
        assert btn_aanpassen != null : "fx:id=\"btn_aanpassen\" was not injected: check your FXML file 'gegevens.fxml'.";

        voegGegevensUserToe();

        btn_aanpassen.setOnAction(e -> gegevensWijzigen());
    }

    private void voegGegevensUserToe() {
        label_voornaam.setText(user.getVoornaam());
        label_achternaam.setText(user.getNaam());
        label_geboortedatum.setText(user.getGeboorteDatum().toString());
        label_gender.setText(user.getGender());
        label_email.setText(user.getEmail());
        label_wachtwoord.setText(user.getWachtwoord());
    }

    private void gegevensWijzigen() {
        if (!txt_voornaam.getText().isEmpty()) {
            user.setVoornaam(txt_voornaam.getText());
            txt_voornaam.setText("");
        }
        if (!txt_achternaam.getText().isEmpty()) {
            user.setNaam(txt_achternaam.getText());
            txt_achternaam.setText("");
        }
        if (!txt_gender.getText().isEmpty()) {
            user.setGender(txt_gender.getText());
            txt_gender.setText("");
        }
        if (!txt_email.getText().isEmpty()) {
            user.setEmail(txt_email.getText());
            txt_email.setText("");
        }
        if (!txt_wachtwoord.getText().isEmpty()) {
            user.setWachtwoord(txt_wachtwoord.getText());
            txt_wachtwoord.setText("");
        }

        PersoonDao persoonDao = new PersoonDao();
        persoonDao.updatePersoon(user);

        voegGegevensUserToe();
    }


    private Persoon user;

    public GegevensController(Persoon user) {
        this.user = user;
    }
}
