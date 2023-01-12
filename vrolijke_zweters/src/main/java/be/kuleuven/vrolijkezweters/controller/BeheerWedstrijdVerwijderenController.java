package be.kuleuven.vrolijkezweters.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import be.kuleuven.vrolijkezweters.database.EtappeDao;
import be.kuleuven.vrolijkezweters.database.WedstrijdDao;
import be.kuleuven.vrolijkezweters.model.Wedstrijd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BeheerWedstrijdVerwijderenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_verwijderen;

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
    void initialize() {
        assert btn_verwijderen != null : "fx:id=\"btn_verwijderen\" was not injected: check your FXML file 'beheerwedstrijdverwijderen.fxml'.";
        assert table_wedstrijd != null : "fx:id=\"table_wedstrijd\" was not injected: check your FXML file 'beheerwedstrijdverwijderen.fxml'.";
        assert table_wedstrijddatum != null : "fx:id=\"table_wedstrijddatum\" was not injected: check your FXML file 'beheerwedstrijdverwijderen.fxml'.";
        assert table_wedstrijdnaam != null : "fx:id=\"table_wedstrijdnaam\" was not injected: check your FXML file 'beheerwedstrijdverwijderen.fxml'.";
        assert table_wedstrijdstartlocatie != null : "fx:id=\"table_wedstrijdstartlocatie\" was not injected: check your FXML file 'beheerwedstrijdverwijderen.fxml'.";
        assert table_wedstrijdeindlocatie != null : "fx:id=\"table_wedstrijdeindlocatie\" was not injected: check your FXML file 'beheerwedstrijdverwijderen.fxml'.";

        voegWedstrijdenToe();

        btn_verwijderen.setOnAction(e -> verwijderWedstrijd());
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
            if (wedstrijd.getDatum().isBefore(huidigeDatum)) {
                data.add(wedstrijd);
            }
        }
        table_wedstrijd.setItems(data);
    }

    private void verwijderWedstrijd() {
        WedstrijdDao wedstrijdDao = new WedstrijdDao();

        Wedstrijd wedstrijd = table_wedstrijd.getSelectionModel().getSelectedItem();
        if (wedstrijd == null) {
            showAlert("Warning", "U moet eerst een wedstrijd selecteren");
        } else {
            wedstrijdDao.deleteWedstrijd(wedstrijd); //werkt niet??
            showAlertGelukt("Gelukt", "De wedstrijd is succesvol verwijderd");
        }
    }

    public void showAlert(String title, String content) {
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void showAlertGelukt(String title, String content) {
        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}