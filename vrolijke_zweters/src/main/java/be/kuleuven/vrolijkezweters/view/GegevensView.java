package be.kuleuven.vrolijkezweters.view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GegevensView extends Stage {
    private Stage stage;
    private Scene scene;

    public GegevensView(Stage stage) {
        this.stage = stage;
    }

    public void start() {
        stage.setTitle("De Vrolijke Zweters - Mijn persoonlijke gegevens");
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

