package be.kuleuven.vrolijkezweters.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
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
    private Hyperlink link_signup;

    @FXML
    private TextField txt_input_password;

    @FXML
    private TextField txt_input_username;

    @FXML
    private Text txt_password;

    @FXML
    private Text txt_sign_in;

    @FXML
    private Text txt_username;

    @FXML
    void initialize() {
        assert anchr_background != null : "fx:id=\"anchr_background\" was not injected: check your FXML file 'login.fxml'.";
        assert anchr_right_side != null : "fx:id=\"anchr_right_side\" was not injected: check your FXML file 'login.fxml'.";
        assert btn_sign_in != null : "fx:id=\"btn_sign_in\" was not injected: check your FXML file 'login.fxml'.";
        assert img_background != null : "fx:id=\"img_background\" was not injected: check your FXML file 'login.fxml'.";
        assert link_signup != null : "fx:id=\"link_signup\" was not injected: check your FXML file 'login.fxml'.";
        assert txt_input_password != null : "fx:id=\"txt_input_password\" was not injected: check your FXML file 'login.fxml'.";
        assert txt_input_username != null : "fx:id=\"txt_input_username\" was not injected: check your FXML file 'login.fxml'.";
        assert txt_password != null : "fx:id=\"txt_password\" was not injected: check your FXML file 'login.fxml'.";
        assert txt_sign_in != null : "fx:id=\"txt_sign_in\" was not injected: check your FXML file 'login.fxml'.";
        assert txt_username != null : "fx:id=\"txt_username\" was not injected: check your FXML file 'login.fxml'.";

    }
}
