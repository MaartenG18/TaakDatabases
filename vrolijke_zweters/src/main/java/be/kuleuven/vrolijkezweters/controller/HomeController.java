package be.kuleuven.vrolijkezweters.controller;

import be.kuleuven.vrolijkezweters.ScreenOpener;
import be.kuleuven.vrolijkezweters.database.PersoonDao;
import be.kuleuven.vrolijkezweters.database.WedstrijdDao;
import be.kuleuven.vrolijkezweters.model.EtappeResultaat;
import be.kuleuven.vrolijkezweters.model.Loper;
import be.kuleuven.vrolijkezweters.model.Persoon;
import be.kuleuven.vrolijkezweters.model.Wedstrijd;
import be.kuleuven.vrolijkezweters.model.semi.PersoonEtappeResultaat;
import be.kuleuven.vrolijkezweters.view.HomeView;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Callback;

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
    private Button btn_klassement;

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
    private Text txt_naam;

    @FXML
    private Label label_naam;

    @FXML
    private Text txt_titel1;

    @FXML
    private TableView<Persoon> table_km;

    @FXML
    private TableColumn<Persoon, Integer> table_kmnr;

    @FXML
    private TableColumn<Persoon, String> table_kmachternaam;

    @FXML
    private TableColumn<Persoon, String> table_kmvoornaam;

    @FXML
    private TableColumn<Persoon, Integer> table_kmaantal;

    @FXML
    private TableView<Persoon> table_deelnames;

    @FXML
    private TableColumn<Persoon, Integer> table_deelnamesnr;

    @FXML
    private TableColumn<Persoon, String> table_deelnamesachternaam;

    @FXML
    private TableColumn<Persoon, String> table_deelnamesvoornaam;

    @FXML
    private TableColumn<Persoon, Integer> table_deelnamesaantal;

    @FXML
    private TableView<Persoon> table_vrijwilliger;

    @FXML
    private TableColumn<Persoon, Integer> table_vrijwilligernr;

    @FXML
    private TableColumn<Persoon, String> table_vrijwilligerachternaam;

    @FXML
    private TableColumn<Persoon, String> table_vrijwilligervoornaam;

    @FXML
    private TableColumn<Persoon, Integer> table_vrijwilligeraantal;

    @FXML
    private TableView<Persoon> table_tijd;

    @FXML
    private TableColumn<Persoon, Integer> table_tijdnr;

    @FXML
    private TableColumn<Persoon, String> table_tijdachternaam;

    @FXML
    private TableColumn<Persoon, String> table_tijdvoornaam;

    @FXML
    private TableColumn<Persoon, Integer> table_tijdaantal;

    @FXML
    void initialize() {
        assert btnInschrijvenLoper != null : "fx:id=\"btnInschrijvenLoper\" was not injected: check your FXML file 'main.fxml'.";
        assert btnInschrijvenVrijwilliger != null : "fx:id=\"btnInschrijvenVrijwilliger\" was not injected: check your FXML file 'main.fxml'.";
        assert btnDeelnames != null : "fx:id=\"btnDeelnames\" was not injected: check your FXML file 'main.fxml'.";
        assert btnGegevens != null : "fx:id=\"btnGegevens\" was not injected: check your FXML file 'main.fxml'.";
        assert btn_klassement != null : "fx:id=\"btn_klassement\" was not injected: check your FXML file 'main.fxml'.";
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
        assert txt_naam != null : "fx:id=\"txt_naam\" was not injected: check your FXML file 'main.fxml'.";
        assert label_naam != null : "fx:id=\"label_naam\" was not injected: check your FXML file 'main.fxml'.";
        assert txt_titel1 != null : "fx:id=\"txt_titel1\" was not injected: check your FXML file 'main.fxml'.";
        assert table_km != null : "fx:id=\"table_km\" was not injected: check your FXML file 'main.fxml'.";
        assert table_kmnr != null : "fx:id=\"table_kmnr\" was not injected: check your FXML file 'main.fxml'.";
        assert table_kmachternaam != null : "fx:id=\"table_kmachternaam\" was not injected: check your FXML file 'main.fxml'.";
        assert table_kmvoornaam != null : "fx:id=\"table_kmvoornaam\" was not injected: check your FXML file 'main.fxml'.";
        assert table_deelnames != null : "fx:id=\"table_deelnames\" was not injected: check your FXML file 'main.fxml'.";
        assert table_deelnamesnr != null : "fx:id=\"table_deelnamesnr\" was not injected: check your FXML file 'main.fxml'.";
        assert table_deelnamesachternaam != null : "fx:id=\"table_deelnamesachternaam\" was not injected: check your FXML file 'main.fxml'.";
        assert table_deelnamesvoornaam != null : "fx:id=\"table_deelnamesvoornaam\" was not injected: check your FXML file 'main.fxml'.";
        assert table_vrijwilliger != null : "fx:id=\"table_vrijwilliger\" was not injected: check your FXML file 'main.fxml'.";
        assert table_vrijwilligernr != null : "fx:id=\"table_vrijwilligernr\" was not injected: check your FXML file 'main.fxml'.";
        assert table_vrijwilligerachternaam != null : "fx:id=\"table_vrijwilligerachternaam\" was not injected: check your FXML file 'main.fxml'.";
        assert table_vrijwilligervoornaam != null : "fx:id=\"table_vrijwilligervoornaam\" was not injected: check your FXML file 'main.fxml'.";
        assert table_tijd != null : "fx:id=\"table_gewonnen\" was not injected: check your FXML file 'main.fxml'.";
        assert table_tijdnr != null : "fx:id=\"table_gewonnennr\" was not injected: check your FXML file 'main.fxml'.";
        assert table_tijdachternaam != null : "fx:id=\"table_gewonnenachternaam\" was not injected: check your FXML file 'main.fxml'.";
        assert table_tijdvoornaam != null : "fx:id=\"table_gewonnenvoornaam\" was not injected: check your FXML file 'main.fxml'.";


        if (user.isAdmin()) {
            btnAdmin.setVisible(true);
        }

        btnInschrijvenLoper.setOnAction(e -> new ScreenOpener("inschrijvenLoper", user));
        btnInschrijvenVrijwilliger.setOnAction(e -> new ScreenOpener("inschrijvenVrijwilliger", user));
        btnDeelnames.setOnAction(e -> new ScreenOpener("deelnames", user));
        btnGegevens.setOnAction(e -> new ScreenOpener("gegevens", user));
        btn_klassement.setOnAction(e -> new ScreenOpener("klassement", user));
        btnAdmin.setOnAction(e -> new ScreenOpener("admin", user));

        btnUitloggen.setOnAction(e -> {
            new ScreenOpener("login");
            view.stop();
        });

        toonResultatenKlassementen();
        toonVolgendeWedstrijd();
    }

    private void toonResultatenKlassementen() {
        toonKlassementKilometers();
        toonKlassementDeelnames();
        toonKlassementVrijwilliger();
        toonKlassementTijd();
    }

    private void toonKlassementKilometers() {
        PersoonDao persoonDao = new PersoonDao();
        List<Persoon> allePersonen = persoonDao.findAllPersonen();

        for (Persoon persoon : allePersonen) {
            List<Loper> alleLopers = persoon.getLopers();

            for (Loper loper : alleLopers) {
                List<EtappeResultaat> alleEtappeResultaten = loper.getEtappeResultaten();

                for (EtappeResultaat etappeResultaat : alleEtappeResultaten) {
                    persoon.setGelopenKilometers(persoon.getGelopenKilometers() + etappeResultaat.getEtappe().getLengte());
                }
            }
        }

        ObservableList<Persoon> data = FXCollections.observableArrayList();
        table_kmachternaam.setCellValueFactory(new PropertyValueFactory<Persoon, String>("naam"));
        table_kmvoornaam.setCellValueFactory(new PropertyValueFactory<Persoon, String>("voornaam"));
        table_kmaantal.setCellValueFactory(new PropertyValueFactory<Persoon, Integer>("gelopenKilometers"));
        table_kmaantal.setSortType(TableColumn.SortType.DESCENDING);
        table_kmnr.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Persoon, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Persoon, Integer> param) {
                return new SimpleIntegerProperty(data.indexOf(param.getValue()) + 1).asObject();
            }
        });

        for (Persoon persoon : allePersonen) {
            if (!persoon.isAdmin()) {
                data.add(persoon);
            }
        }

        data.sort((o1, o2) -> {
            if (o1.getGelopenKilometers() == o2.getGelopenKilometers()) {
                return o1.getNaam().compareTo(o2.getNaam());
            } else {
                return o2.getGelopenKilometers() - o1.getGelopenKilometers();
            }
        });
        table_km.setItems(data);
    }

    private void toonKlassementDeelnames() {
        PersoonDao persoonDao = new PersoonDao();
        List<Persoon> allePersonen = persoonDao.findAllPersonen();

        for (Persoon persoon : allePersonen) {
            persoon.setAantalDeelnames(persoon.getLopers().size());
        }

        ObservableList<Persoon> data = FXCollections.observableArrayList();
        table_deelnamesachternaam.setCellValueFactory(new PropertyValueFactory<Persoon, String>("naam"));
        table_deelnamesvoornaam.setCellValueFactory(new PropertyValueFactory<Persoon, String>("voornaam"));
        table_deelnamesaantal.setCellValueFactory(new PropertyValueFactory<Persoon, Integer>("aantalDeelnames"));
        table_deelnamesaantal.setSortType(TableColumn.SortType.DESCENDING);
        table_deelnamesnr.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Persoon, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Persoon, Integer> param) {
                return new SimpleIntegerProperty(data.indexOf(param.getValue()) + 1).asObject();
            }
        });

        for (Persoon persoon : allePersonen) {
            if (!persoon.isAdmin()) {
                data.add(persoon);
            }
        }

        data.sort((o1, o2) -> {
            if (o1.getAantalDeelnames() == o2.getAantalDeelnames()) {
                return o1.getNaam().compareTo(o2.getNaam());
            } else {
                return o2.getAantalDeelnames() - o1.getAantalDeelnames();
            }
        });
        table_deelnames.setItems(data);
    }

    private void toonKlassementVrijwilliger() {
        PersoonDao persoonDao = new PersoonDao();
        List<Persoon> allePersonen = persoonDao.findAllPersonen();

        for (Persoon persoon : allePersonen) {
            persoon.setAantalKerenVrijwilliger(persoon.getVrijwilligers().size());
        }

        ObservableList<Persoon> data = FXCollections.observableArrayList();
        table_vrijwilligerachternaam.setCellValueFactory(new PropertyValueFactory<Persoon, String>("naam"));
        table_vrijwilligervoornaam.setCellValueFactory(new PropertyValueFactory<Persoon, String>("voornaam"));
        table_vrijwilligeraantal.setCellValueFactory(new PropertyValueFactory<Persoon, Integer>("aantalKerenVrijwilliger"));
        table_vrijwilligeraantal.setSortType(TableColumn.SortType.DESCENDING);
        table_vrijwilligernr.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Persoon, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Persoon, Integer> param) {
                return new SimpleIntegerProperty(data.indexOf(param.getValue()) + 1).asObject();
            }
        });

        for (Persoon persoon : allePersonen) {
            if (!persoon.isAdmin()) {
                data.add(persoon);
            }
        }

        data.sort((o1, o2) -> {
            if (o1.getAantalKerenVrijwilliger() == o2.getAantalKerenVrijwilliger()) {
                return o1.getNaam().compareTo(o2.getNaam());
            } else {
                return o2.getAantalKerenVrijwilliger() - o1.getAantalKerenVrijwilliger();
            }
        });
        table_vrijwilliger.setItems(data);
    }

    private void toonKlassementTijd() {
        PersoonDao persoonDao = new PersoonDao();
        List<Persoon> allePersonen = persoonDao.findAllPersonen();

        for (Persoon persoon : allePersonen) {
            List<Loper> alleLopers = persoon.getLopers();

            for (Loper loper : alleLopers) {
                List<EtappeResultaat> alleEtappeResultaten = loper.getEtappeResultaten();

                for (EtappeResultaat etappeResultaat : alleEtappeResultaten) {
                    persoon.setGelopenSeconden(persoon.getGelopenSeconden() + etappeResultaat.getTijd());
                }
            }
        }

        ObservableList<Persoon> data = FXCollections.observableArrayList();
        table_tijdachternaam.setCellValueFactory(new PropertyValueFactory<Persoon, String>("naam"));
        table_tijdvoornaam.setCellValueFactory(new PropertyValueFactory<Persoon, String>("voornaam"));
        table_tijdaantal.setCellValueFactory(new PropertyValueFactory<Persoon, Integer>("gelopenSeconden"));
        table_tijdaantal.setSortType(TableColumn.SortType.DESCENDING);
        table_tijdnr.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Persoon, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Persoon, Integer> param) {
                return new SimpleIntegerProperty(data.indexOf(param.getValue()) + 1).asObject();
            }
        });

        for (Persoon persoon : allePersonen) {
            if (!persoon.isAdmin()) {
                data.add(persoon);
            }
        }

        data.sort((o1, o2) -> {
            if (o1.getGelopenSeconden() == o2.getGelopenSeconden()) {
                return o1.getNaam().compareTo(o2.getNaam());
            } else {
                return o2.getGelopenSeconden() - o1.getGelopenSeconden();
            }
        });
        table_tijd.setItems(data);
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
            label_naam.setText(wedstrijd.getNaam());
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