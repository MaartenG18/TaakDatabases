package be.kuleuven.vrolijkezweters.view;

import be.kuleuven.vrolijkezweters.model.login.Login;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginView extends Stage {
    private Stage stage;
    private Login model;
    private Scene scene;
    private Parent root;

    public LoginView(Stage stage, Login model) {
        this.stage = stage;
        this.model = model;
    }

    public void start() {
        stage.setTitle("De Vrolijke Zweters - Login");
        stage.setResizable(false);
        stage.show();
    }

    public void stop() {
        stage.close();
    }

    public void setRoot(Parent root) {
        scene = new Scene(root);
        stage.setScene(scene);
    }
}

