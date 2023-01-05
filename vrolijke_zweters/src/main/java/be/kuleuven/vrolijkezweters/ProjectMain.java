package be.kuleuven.vrolijkezweters;

import be.kuleuven.vrolijkezweters.controller.LoginController;
import be.kuleuven.vrolijkezweters.database.LoperDao;
import be.kuleuven.vrolijkezweters.database.PersoonDao;
import be.kuleuven.vrolijkezweters.database.VrijwilligerDao;
import be.kuleuven.vrolijkezweters.database.WedstrijdDao;
import be.kuleuven.vrolijkezweters.model.*;
import be.kuleuven.vrolijkezweters.view.LoginView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

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
        LoperDao loperDao = new LoperDao();
        VrijwilligerDao vrijwilligerDao = new VrijwilligerDao();
        WedstrijdDao wedstrijdDao = new WedstrijdDao();

        Persoon admin = new Persoon();
        admin.setNaam("Gielkens");
        admin.setVoornaam("Maarten");
        admin.setGeboorteDatum(LocalDate.of(2020, 1 , 8));
        admin.setGender("M");
        admin.setEmail("admin@vrolijkezweters.be");
        admin.setWachtwoord("Admin");
        admin.setAdmin(true);

        persoonDao.createPersoon(admin);

        Wedstrijd wedstrijd = new Wedstrijd();
        wedstrijd.setDatum("12/12/2012");
        wedstrijd.setStartLocatie("Genk");
        wedstrijd.setEindLocatie("Hasselt");
        wedstrijd.setInschrijvingsGeld(10);

        wedstrijdDao.createWedstrijd(wedstrijd);

        Loper loper = new Loper();
        loper.setGewicht(95);
        loper.setFitheid(70);
        loper.setPersoon(admin);
        loper.setWedstrijd(wedstrijd);

        loperDao.createLoper(loper);

        Loper loper1 = new Loper();
        loper1.setGewicht(105);
        loper1.setFitheid(50);
        loper1.setPersoon(admin);
        loper1.setWedstrijd(wedstrijd);

        loperDao.createLoper(loper1);

        Persoon persoon1 = new Persoon();
        persoon1.setNaam("Groeneveld");
        persoon1.setVoornaam("Wouter");
        persoon1.setGeboorteDatum(LocalDate.of(2020, 1 , 8));
        persoon1.setGender("M");
        persoon1.setEmail("wouter.groeneveld@kuleuven.be");
        persoon1.setWachtwoord("Admin");
        persoon1.setAdmin(false);

        persoonDao.createPersoon(persoon1);

        Loper loper2 = new Loper();
        loper2.setGewicht(70);
        loper2.setFitheid(85);
        loper2.setPersoon(persoon1);
        loper2.setWedstrijd(wedstrijd);

        loperDao.createLoper(loper2);

        Persoon persoon2 = new Persoon();
        persoon2.setNaam("Aerts");
        persoon2.setVoornaam("Kris");
        persoon2.setGeboorteDatum(LocalDate.of(2020, 1 , 8));
        persoon2.setGender("M");
        persoon2.setEmail("kris.aerts@kuleuven.be");
        persoon2.setWachtwoord("Admin");
        persoon2.setAdmin(false);

        persoonDao.createPersoon(persoon2);

        Vrijwilliger vrijwilliger = new Vrijwilliger();
        vrijwilliger.setTaak("Startschot geven");
        vrijwilliger.setPersoon(persoon2);
        vrijwilliger.voegWedstrijdToe(wedstrijd);
        wedstrijd.voegVrijwilligerToe(vrijwilliger);

        vrijwilligerDao.createVrijwilliger(vrijwilliger);

        wedstrijdDao.updateWedstrijd(wedstrijd);



    }
}
