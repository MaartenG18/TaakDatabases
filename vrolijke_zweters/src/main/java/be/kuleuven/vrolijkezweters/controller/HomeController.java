package be.kuleuven.vrolijkezweters.controller;

import be.kuleuven.vrolijkezweters.ProjectMain;
import be.kuleuven.vrolijkezweters.ScreenOpener;
import be.kuleuven.vrolijkezweters.database.WedstrijdDao;
import be.kuleuven.vrolijkezweters.model.Persoon;
import be.kuleuven.vrolijkezweters.model.Wedstrijd;
import be.kuleuven.vrolijkezweters.view.HomeView;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInschrijvenLoper;

    @FXML
    private Button btnInschrijvenVrijwilliger;

    @FXML
    private Button btnDeelnames;

    @FXML
    private Button btnGegevens;

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnUitloggen;

    @FXML
    private Text txt_titel;

    @FXML
    private Text txt_datum;

    @FXML
    private Text txt_startlocatie;

    @FXML
    private Text txt_eindlocatie;

    @FXML
    private Text txt_afstand;

    @FXML
    private Label label_datum;

    @FXML
    private Label label_startlocatie;

    @FXML
    private Label label_eindlocatie;

    @FXML
    private Label label_afstand;

    @FXML
    void initialize() {
        assert btnInschrijvenLoper != null : "fx:id=\"btnInschrijvenLoper\" was not injected: check your FXML file 'main.fxml'.";
        assert btnInschrijvenVrijwilliger != null : "fx:id=\"btnInschrijvenVrijwilliger\" was not injected: check your FXML file 'main.fxml'.";
        assert btnDeelnames != null : "fx:id=\"btnDeelnames\" was not injected: check your FXML file 'main.fxml'.";
        assert btnGegevens != null : "fx:id=\"btnGegevens\" was not injected: check your FXML file 'main.fxml'.";
        assert btnAdmin != null : "fx:id=\"btnAdmin\" was not injected: check your FXML file 'main.fxml'.";
        assert btnUitloggen != null : "fx:id=\"btnUitloggen\" was not injected: check your FXML file 'main.fxml'.";
        assert txt_titel != null : "fx:id=\"txt_titel\" was not injected: check your FXML file 'main.fxml'.";
        assert txt_datum != null : "fx:id=\"txt_datum\" was not injected: check your FXML file 'main.fxml'.";
        assert txt_startlocatie != null : "fx:id=\"txt_startlocatie\" was not injected: check your FXML file 'main.fxml'.";
        assert txt_eindlocatie != null : "fx:id=\"txt_eindlocatie\" was not injected: check your FXML file 'main.fxml'.";
        assert txt_afstand != null : "fx:id=\"txt_afstand\" was not injected: check your FXML file 'main.fxml'.";
        assert label_datum != null : "fx:id=\"label_datum\" was not injected: check your FXML file 'main.fxml'.";
        assert label_startlocatie != null : "fx:id=\"label_startlocatie\" was not injected: check your FXML file 'main.fxml'.";
        assert label_eindlocatie != null : "fx:id=\"label_eindlocatie\" was not injected: check your FXML file 'main.fxml'.";
        assert label_afstand != null : "fx:id=\"label_afstand\" was not injected: check your FXML file 'main.fxml'.";

        if (user.isAdmin()) {
            btnAdmin.setVisible(true);
        }

        btnAdmin.setOnAction(e -> new ScreenOpener("admin", user));
        btnInschrijvenLoper.setOnAction(e -> new ScreenOpener("inschrijvenLoper", user));
        btnInschrijvenVrijwilliger.setOnAction(e -> new ScreenOpener("inschrijvenVrijwilliger", user));
        btnDeelnames.setOnAction(e -> new ScreenOpener("deelnames", user));
        btnGegevens.setOnAction(e -> new ScreenOpener("gegevens", user));

        btnUitloggen.setOnAction(e -> {
            new ScreenOpener("login");
            view.stop();
        });

        toonVolgendeWedstrijd();
    }

    private void toonVolgendeWedstrijd() {
        WedstrijdDao wedstrijdDao = new WedstrijdDao();

        List<Wedstrijd> wedstrijdList = wedstrijdDao.findAlleWedstrijden();
        LocalDate huidigeDatum = LocalDate.now();
        LocalDate eerstvolgendeDatum = null;

        for (Wedstrijd wedstrijd : wedstrijdList) {
            if (wedstrijd.getDatum().isAfter(huidigeDatum) && (eerstvolgendeDatum == null || wedstrijd.getDatum().isBefore(eerstvolgendeDatum))) {
                eerstvolgendeDatum = wedstrijd.getDatum();
            }
        }

        if (eerstvolgendeDatum != null) {
            Wedstrijd wedstrijd = wedstrijdDao.findWedstrijdByDate(eerstvolgendeDatum);

            int afstand = 0;
            for (int j = 0; j < wedstrijd.getEtappes().size(); j++) {
                afstand += wedstrijd.getEtappes().get(j).getLengte();
            }

            label_datum.setText(wedstrijd.getDatum().toString());
            label_startlocatie.setText(wedstrijd.getStartLocatie());
            label_eindlocatie.setText(wedstrijd.getEindLocatie());
            label_afstand.setText(afstand + " km");
        }
    }

    private HomeView view;
    private Persoon user;

    public HomeController(HomeView view, Persoon user) {
        this.view = view;
        this.user = user;
    }

}