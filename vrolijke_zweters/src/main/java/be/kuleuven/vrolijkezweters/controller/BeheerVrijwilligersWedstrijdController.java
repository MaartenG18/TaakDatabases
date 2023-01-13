package be.kuleuven.vrolijkezweters.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import be.kuleuven.vrolijkezweters.database.WedstrijdDao;
import be.kuleuven.vrolijkezweters.model.Vrijwilliger;
import be.kuleuven.vrolijkezweters.model.Wedstrijd;
import be.kuleuven.vrolijkezweters.model.semi.PersoonVrijwilliger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class BeheerVrijwilligersWedstrijdController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Wedstrijd> table_wedstrijd;

    @FXML
    private TableColumn<Wedstrijd, LocalDate> table_wedstrijddatum;

    @FXML
    private TableColumn<Wedstrijd, String> table_wedstrijdnaam;

    @FXML
    private TableColumn<Wedstrijd, String> table_wedstrijdstartlocatie;

    @FXML
    private TableColumn<Wedstrijd, String> table_wedstrijdeindlocatie;

    @FXML
    private TableView<PersoonVrijwilliger> table_vrijwilligers;

    @FXML
    private TableColumn<PersoonVrijwilliger, String> table_vrijwilligersachternaam;

    @FXML
    private TableColumn<PersoonVrijwilliger, String> table_vrijwilligersvoornaam;

    @FXML
    private TableColumn<PersoonVrijwilliger, LocalDate> table_vrijwilligersgeboortedatum;

    @FXML
    private TableColumn<PersoonVrijwilliger, String> table_vrijwilligerstaak;

    @FXML
    private Button btn_bevestigen;

    @FXML
    void initialize() {
        assert table_wedstrijd != null : "fx:id=\"table_wedstrijd\" was not injected: check your FXML file 'beheervrijwilligerswedstrijd.fxml'.";
        assert table_wedstrijddatum != null : "fx:id=\"table_wedstrijddatum\" was not injected: check your FXML file 'beheervrijwilligerswedstrijd.fxml'.";
        assert table_wedstrijdnaam != null : "fx:id=\"table_wedstrijdnaam\" was not injected: check your FXML file 'beheervrijwilligerswedstrijd.fxml'.";
        assert table_wedstrijdstartlocatie != null : "fx:id=\"table_wedstrijdstartlocatie\" was not injected: check your FXML file 'beheervrijwilligerswedstrijd.fxml'.";
        assert table_wedstrijdeindlocatie != null : "fx:id=\"table_wedstrijdeindlocatie\" was not injected: check your FXML file 'beheervrijwilligerswedstrijd.fxml'.";
        assert table_vrijwilligers != null : "fx:id=\"table_vrijwilligers\" was not injected: check your FXML file 'beheervrijwilligerswedstrijd.fxml'.";
        assert table_vrijwilligersachternaam != null : "fx:id=\"table_vrijwilligersachternaam\" was not injected: check your FXML file 'beheervrijwilligerswedstrijd.fxml'.";
        assert table_vrijwilligersvoornaam != null : "fx:id=\"table_vrijwilligersvoornaam\" was not injected: check your FXML file 'beheervrijwilligerswedstrijd.fxml'.";
        assert table_vrijwilligersgeboortedatum != null : "fx:id=\"table_vrijwilligersgeboortedatum\" was not injected: check your FXML file 'beheervrijwilligerswedstrijd.fxml'.";
        assert table_vrijwilligerstaak != null : "fx:id=\"table_vrijwilligerstaak\" was not injected: check your FXML file 'beheervrijwilligerswedstrijd.fxml'.";
        assert btn_bevestigen != null : "fx:id=\"btn_bevestigen\" was not injected: check your FXML file 'beheervrijwilligerswedstrijd.fxml'.";

        voegWedstrijdenToe();

        btn_bevestigen.setOnAction(e -> voegVrijwilligersToe());
    }

    private void voegWedstrijdenToe() {
        WedstrijdDao wedstrijdDao = new WedstrijdDao();
        List<Wedstrijd> wedstrijdList = wedstrijdDao.findAlleWedstrijden();

        LocalDate huidigeDatum = LocalDate.now();

        ObservableList<Wedstrijd> data = FXCollections.observableArrayList();
        table_wedstrijddatum.setCellValueFactory(new PropertyValueFactory<Wedstrijd, LocalDate>("datum"));
        table_wedstrijdnaam.setCellValueFactory(new PropertyValueFactory<Wedstrijd, String>("naam"));
        table_wedstrijdstartlocatie.setCellValueFactory(new PropertyValueFactory<Wedstrijd, String>("startLocatie"));
        table_wedstrijdeindlocatie.setCellValueFactory(new PropertyValueFactory<Wedstrijd, String>("eindLocatie"));

        for (Wedstrijd wedstrijd : wedstrijdList) {
            if (wedstrijd.getDatum().isAfter(huidigeDatum)) {
                data.add(wedstrijd);
            }
        }
        table_wedstrijd.setItems(data);
    }

    private void voegVrijwilligersToe() {
        Wedstrijd wedstrijd = table_wedstrijd.getSelectionModel().getSelectedItem();

        if (wedstrijd == null) {
            showAlert("Warning", "U hebt geen wedstrijd geselecteerd");
        } else {
            List<Vrijwilliger> vrijwilligerList = wedstrijd.getVrijwilligers();

            ObservableList<PersoonVrijwilliger> data = FXCollections.observableArrayList();
            table_vrijwilligersachternaam.setCellValueFactory(new PropertyValueFactory<PersoonVrijwilliger, String>("naam"));
            table_vrijwilligersvoornaam.setCellValueFactory(new PropertyValueFactory<PersoonVrijwilliger, String>("voornaam"));
            table_vrijwilligersgeboortedatum.setCellValueFactory(new PropertyValueFactory<PersoonVrijwilliger, LocalDate>("geboorteDatum"));
            table_vrijwilligerstaak.setCellValueFactory(new PropertyValueFactory<PersoonVrijwilliger, String>("taak"));

            for (Vrijwilliger vrijwilliger : vrijwilligerList) {
                PersoonVrijwilliger persoonVrijwilliger = new PersoonVrijwilliger();

                persoonVrijwilliger.setNaam(vrijwilliger.getPersoon().getNaam());
                persoonVrijwilliger.setVoornaam(vrijwilliger.getPersoon().getVoornaam());
                persoonVrijwilliger.setGeboorteDatum(vrijwilliger.getPersoon().getGeboorteDatum());
                persoonVrijwilliger.setTaak(vrijwilliger.getTaak());

                data.add(persoonVrijwilliger);
            }
            table_vrijwilligers.setItems(data);
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