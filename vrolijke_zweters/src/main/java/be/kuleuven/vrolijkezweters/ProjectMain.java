package be.kuleuven.vrolijkezweters;

import be.kuleuven.vrolijkezweters.controller.LoginController;
import be.kuleuven.vrolijkezweters.database.PersoonDao;
import be.kuleuven.vrolijkezweters.model.login.Login;
import be.kuleuven.vrolijkezweters.model.persoon.Persoon;
import be.kuleuven.vrolijkezweters.model.vrijwilliger.Vrijwilliger;
import be.kuleuven.vrolijkezweters.view.LoginView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;

import javax.persistence.Persistence;
import java.time.LocalDate;

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
        maakDummyData();

        Login model = new Login();
        LoginView view = new LoginView(stage, model);
        LoginController controller = new LoginController(model, view);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("login.fxml"));
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        view.setRoot(root);
        view.start();
    }

    public static void main(String[] args) {
        launch();
    }

    private void maakDummyData() {
        maakNieuwePersonen();
    }

    private void maakNieuwePersonen() {
        PersoonDao persoonDao = new PersoonDao();

        Persoon admin = new Persoon();
        admin.setNaam("Gielkens");
        admin.setVoornaam("Maarten");
        admin.setGeboorteDatum(LocalDate.of(2020, 1 , 8));
        admin.setGender("M");
        admin.setEmail("admin@vrolijkezweters.be");
        admin.setWachtwoord("Admin");
        admin.setAdmin(true);

        persoonDao.createPersoon(admin);

        Persoon persoon1 = new Persoon();
        persoon1.setNaam("Groeneveld");
        persoon1.setVoornaam("Wouter");
        persoon1.setGeboorteDatum(LocalDate.of(2020, 1 , 8));
        persoon1.setGender("M");
        persoon1.setEmail("wouter.groeneveld@kuleuven.be");
        persoon1.setWachtwoord("Admin");
        persoon1.setAdmin(false);

        persoonDao.createPersoon(persoon1);

        Persoon persoon2 = new Persoon();
        persoon2.setNaam("Aerts");
        persoon2.setVoornaam("Kris");
        persoon2.setGeboorteDatum(LocalDate.of(2020, 1 , 8));
        persoon2.setGender("M");
        persoon2.setEmail("kris.aerts@kuleuven.be");
        persoon2.setWachtwoord("Admin");
        persoon2.setAdmin(false);

        persoonDao.createPersoon(persoon2);
    }
}
