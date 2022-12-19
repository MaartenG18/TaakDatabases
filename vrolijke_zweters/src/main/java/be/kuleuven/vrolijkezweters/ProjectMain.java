package be.kuleuven.vrolijkezweters;

import be.kuleuven.vrolijkezweters.model.persoon.Persoon;
import be.kuleuven.vrolijkezweters.model.persoon.PersoonRepositoryJpaImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.Persistence;

/**
 * DB Taak 2022-2023: De Vrolijke Zweters
 * Zie https://kuleuven-diepenbeek.github.io/db-course/extra/project/ voor opgave details
 *
 * Deze code is slechts een quick-start om je op weg te helpen met de integratie van JavaFX tabellen en data!
 * Zie README.md voor meer informatie.
 */
public class ProjectMain extends Application {

    private static Stage rootStage;

    public static Stage getRootStage() {
        return rootStage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        werkendeKrijgen();
        rootStage = stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("De Vrolijke Zweters Administratie hoofdscherm");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private static void werkendeKrijgen() {
        System.out.println("Bootstrapping JPA/Hibernate...");
        var sessionFactory = Persistence.createEntityManagerFactory("be.kuleuven.vrolijkezweters.model");
        var entityManager = sessionFactory.createEntityManager();

        System.out.println("Bootstrapping Repository...");
        var repo = new PersoonRepositoryJpaImpl(entityManager);

        // TODO pruts hier om in 'productie' te testen - enkel NADAT testen in orde zijn!
        System.out.println("Persisting Jos Lowiemans, Truus Van Hooibergen...");
        var jos = new Persoon("Lowiemans", "Jos", "15011999", 'M');
        var truus = new Persoon("Van Hooibergen", "Truus", "01012001", 'V');

        repo.saveNewPersoon(truus);
        repo.saveNewPersoon(jos);

        isJosEr(repo);
    }

    private static void isJosEr(PersoonRepositoryJpaImpl repo) {
        System.out.println("Is Jos er?");
        var personen = repo.getPersonenByName("Lowiemans");
        for(var eenPersoon : personen) {
            System.out.println(eenPersoon);
        }
    }
}
