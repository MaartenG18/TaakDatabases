package be.kuleuven.vrolijkezweters.controller;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import be.kuleuven.vrolijkezweters.ScreenOpener;
import be.kuleuven.vrolijkezweters.database.PersoonDao;
import be.kuleuven.vrolijkezweters.model.login.Login;
import be.kuleuven.vrolijkezweters.model.persoon.Persoon;
import be.kuleuven.vrolijkezweters.view.LoginView;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchr_background;

    @FXML
    private AnchorPane anchr_right_side;

    @FXML
    private Button btn_sign_in;

    @FXML
    private ImageView img_background;

    @FXML
    private PasswordField input_psw;

    @FXML
    private Hyperlink link_signup;

    @FXML
    private Text txt_email;

    @FXML
    private TextField txt_input_email;

    @FXML
    private Text txt_password;

    @FXML
    private Text txt_sign_in;

    @FXML
    void initialize() {
        assert anchr_background != null : "fx:id=\"anchr_background\" was not injected: check your FXML file 'login.fxml'.";
        assert anchr_right_side != null : "fx:id=\"anchr_right_side\" was not injected: check your FXML file 'login.fxml'.";
        assert btn_sign_in != null : "fx:id=\"btn_sign_in\" was not injected: check your FXML file 'login.fxml'.";
        assert img_background != null : "fx:id=\"img_background\" was not injected: check your FXML file 'login.fxml'.";
        assert input_psw != null : "fx:id=\"input_psw\" was not injected: check your FXML file 'login.fxml'.";
        assert link_signup != null : "fx:id=\"link_signup\" was not injected: check your FXML file 'login.fxml'.";
        assert txt_email != null : "fx:id=\"txt_email\" was not injected: check your FXML file 'login.fxml'.";
        assert txt_input_email != null : "fx:id=\"txt_input_email\" was not injected: check your FXML file 'login.fxml'.";
        assert txt_password != null : "fx:id=\"txt_password\" was not injected: check your FXML file 'login.fxml'.";
        assert txt_sign_in != null : "fx:id=\"txt_sign_in\" was not injected: check your FXML file 'login.fxml'.";

        txt_input_email.textProperty().bindBidirectional(model.emailProperty());
        input_psw.textProperty().bindBidirectional(model.passwordProperty());

        btn_sign_in.setOnAction(event -> login());
        link_signup.setOnAction(event -> {
            new ScreenOpener("register");
            view.stop();
        });
    }

    private final Login model;
    private final LoginView view;

    public LoginController(Login model, LoginView view) {
        this.model = model;
        this.view = view;
    }

    private void login() {
        PersoonDao persoonDao = new PersoonDao();

        Persoon persoon = persoonDao.findPersoonByEmail(model.getEmail());

        if (persoon == null) {
            showAlert("Warning!", "We hebben nog geen account gevonden met dit email adres, probeer te registeren");
        }
        else if(Objects.equals(persoon.getEmail(), model.getEmail()) && Objects.equals(persoon.getWachtwoord(), model.getPassword())) {
            new ScreenOpener("home");
            view.stop();
        }
        else {
            showAlert("Warning!", "De opgegeven combinatie bestaat niet, probeer opnieuw");
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

