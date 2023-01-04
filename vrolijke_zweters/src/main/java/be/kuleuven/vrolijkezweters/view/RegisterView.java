package be.kuleuven.vrolijkezweters.view;

import be.kuleuven.vrolijkezweters.model.Register;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterView extends Stage {
    private Stage stage;
    private Register model;
    private Scene scene;

    public RegisterView(Stage stage, Register model) {
        this.stage = stage;
        this.model = model;
    }

    public void start() {
        stage.setTitle("De Vrolijke Zweters - Register");
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
