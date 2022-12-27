package be.kuleuven.vrolijkezweters.controller;

import java.net.URL;
import java.util.ResourceBundle;

import be.kuleuven.vrolijkezweters.ScreenOpener;
import be.kuleuven.vrolijkezweters.database.PersoonDao;
import be.kuleuven.vrolijkezweters.model.persoon.Persoon;
import be.kuleuven.vrolijkezweters.model.register.Register;
import be.kuleuven.vrolijkezweters.view.RegisterView;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class RegisterController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchr_background;

    @FXML
    private AnchorPane anchr_right_side;

    @FXML
    private Button btn_signup;

    @FXML
    private DatePicker datepicker;

    @FXML
    private ImageView img_background;

    @FXML
    private ChoiceBox<String> input_gender;

    @FXML
    private PasswordField input_psw;

    @FXML
    private Hyperlink link_signin;

    @FXML
    private Text txt_email;

    @FXML
    private Text txt_geboortedatum;

    @FXML
    private Text txt_gender;

    @FXML
    private TextField txt_input_email;

    @FXML
    private TextField txt_input_naam;

    @FXML
    private TextField txt_input_voornaam;

    @FXML
    private Text txt_naam;

    @FXML
    private Text txt_password;

    @FXML
    private Text txt_sign_in;

    @FXML
    private Text txt_voornaam;

    @FXML
    void initialize() {
        assert anchr_background != null : "fx:id=\"anchr_background\" was not injected: check your FXML file 'register.fxml'.";
        assert anchr_right_side != null : "fx:id=\"anchr_right_side\" was not injected: check your FXML file 'register.fxml'.";
        assert btn_signup != null : "fx:id=\"btn_signup\" was not injected: check your FXML file 'register.fxml'.";
        assert datepicker != null : "fx:id=\"datepicker\" was not injected: check your FXML file 'register.fxml'.";
        assert img_background != null : "fx:id=\"img_background\" was not injected: check your FXML file 'register.fxml'.";
        assert input_gender != null : "fx:id=\"input_gender\" was not injected: check your FXML file 'register.fxml'.";
        assert input_psw != null : "fx:id=\"input_psw\" was not injected: check your FXML file 'register.fxml'.";
        assert link_signin != null : "fx:id=\"link_signin\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_email != null : "fx:id=\"txt_email\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_geboortedatum != null : "fx:id=\"txt_geboortedatum\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_gender != null : "fx:id=\"txt_gender\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_input_email != null : "fx:id=\"txt_input_email\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_input_naam != null : "fx:id=\"txt_input_naam\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_input_voornaam != null : "fx:id=\"txt_input_voornaam\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_naam != null : "fx:id=\"txt_naam\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_password != null : "fx:id=\"txt_password\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_sign_in != null : "fx:id=\"txt_sign_in\" was not injected: check your FXML file 'register.fxml'.";
        assert txt_voornaam != null : "fx:id=\"txt_voornaam\" was not injected: check your FXML file 'register.fxml'.";

        txt_input_voornaam.textProperty().bindBidirectional(model.voornaamProperty());
        txt_input_naam.textProperty().bindBidirectional(model.naamProperty());
        datepicker.valueProperty().bindBidirectional(model.geboorteDatumProperty());
        txt_input_email.textProperty().bindBidirectional(model.emailProperty());
        input_psw.textProperty().bindBidirectional(model.passwordProperty());
        input_gender.valueProperty().bindBidirectional(model.genderProperty());

        btn_signup.setOnAction(event -> register());
        link_signin.setOnAction(event -> {
            new ScreenOpener("login");
            view.stop();
        });
    }

    private Register model;
    private RegisterView view;

    public RegisterController(Register model, RegisterView view) {
        this.model = model;
        this.view = view;
    }

    public Register getModel() {
        return model;
    }

    public void setModel(Register model) {
        this.model = model;
    }

    public RegisterView getView() {
        return view;
    }

    public void setView(RegisterView view) {
        this.view = view;
    }

    private void register() {
        PersoonDao persoonDao = new PersoonDao();

        if (persoonDao.findPersoonByEmail(model.getEmail()) == null) {
            Persoon newPersoon = new Persoon();
            newPersoon.setNaam(model.getNaam());
            newPersoon.setVoornaam(model.getVoornaam());
            newPersoon.setGeboorteDatum(model.getGeboorteDatum());
            newPersoon.setGender(model.getGender());
            newPersoon.setEmail(model.getEmail());
            newPersoon.setWachtwoord(model.getPassword());
            newPersoon.setAdmin(false);

            persoonDao.createPersoon(newPersoon);

            new ScreenOpener("home");
            view.stop();

        } else {
            showAlert("Warning!", "We hebben al een account gevonden met dit email adres, probeer in te loggen");
        }
    }
    public void showAlert(String title, String content) {
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
