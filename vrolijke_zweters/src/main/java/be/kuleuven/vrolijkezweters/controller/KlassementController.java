package be.kuleuven.vrolijkezweters.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

import be.kuleuven.vrolijkezweters.database.WedstrijdDao;
import be.kuleuven.vrolijkezweters.model.*;
import be.kuleuven.vrolijkezweters.model.semi.PersoonEtappeResultaat;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class KlassementController {

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
    private TableView<PersoonEtappeResultaat> table_klassement;

    @FXML
    private TableColumn<PersoonEtappeResultaat, Integer> table_klassementplaats;

    @FXML
    private TableColumn<PersoonEtappeResultaat, Integer> table_klassementtijd;

    @FXML
    private TableColumn<PersoonEtappeResultaat, String> table_klassementachternaam;

    @FXML
    private TableColumn<PersoonEtappeResultaat, String> table_klassementvoornaam;

    @FXML
    private Button btn_wedstrijdklassement;

    @FXML
    private TableView<Etappe> table_etappe;

    @FXML
    private TableColumn<Etappe, String> table_etappelocatie;

    @FXML
    private TableColumn<Etappe, Integer> table_etappelengte;

    @FXML
    private Button btn_etappeklassement;

    @FXML
    void initialize() {
        assert table_wedstrijd != null : "fx:id=\"table_wedstrijd\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_wedstrijddatum != null : "fx:id=\"table_wedstrijddatum\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_wedstrijdnaam != null : "fx:id=\"table_wedstrijdnaam\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_wedstrijdstartlocatie != null : "fx:id=\"table_wedstrijdstartlocatie\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_wedstrijdeindlocatie != null : "fx:id=\"table_wedstrijdeindlocatie\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_klassement != null : "fx:id=\"table_klassement\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_klassementplaats != null : "fx:id=\"table_klassementplaats\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_klassementtijd != null : "fx:id=\"table_klassementtijd\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_klassementachternaam != null : "fx:id=\"table_klassementachternaam\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_klassementvoornaam != null : "fx:id=\"table_klassementvoornaam\" was not injected: check your FXML file 'klassement.fxml'.";
        assert btn_wedstrijdklassement != null : "fx:id=\"btn_wedstrijdklassement\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_etappe != null : "fx:id=\"table_etappe\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_etappelocatie != null : "fx:id=\"table_etappelocatie\" was not injected: check your FXML file 'klassement.fxml'.";
        assert table_etappelengte != null : "fx:id=\"table_etappelengte\" was not injected: check your FXML file 'klassement.fxml'.";
        assert btn_etappeklassement != null : "fx:id=\"btn_etappeklassement\" was not injected: check your FXML file 'klassement.fxml'.";

        voegWedstrijdenToe();

        btn_wedstrijdklassement.setOnAction(e -> toonWedstrijdKlassement());
        btn_etappeklassement.setOnAction(e -> toonEtappeKlassement());
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

        Collections.sort(wedstrijdList, (object1, object2) -> object2.getDatum().compareTo(object1.getDatum()));

        for (Wedstrijd wedstrijd : wedstrijdList) {
            if (wedstrijd.getDatum().isBefore(huidigeDatum)) {
                data.add(wedstrijd);
            }
        }
        table_wedstrijd.setItems(data);
    }

    private void voegEtappesToe() {
        Wedstrijd wedstrijd = table_wedstrijd.getSelectionModel().getSelectedItem();

        if (wedstrijd == null) {
            showAlert("Warning", "Selecteer eerst een wedstrijd");
        } else {
            List<Etappe> etappeList = wedstrijd.getEtappes();

            ObservableList<Etappe> data = FXCollections.observableArrayList();
            table_etappelocatie.setCellValueFactory(new PropertyValueFactory<Etappe, String>("locatie"));
            table_etappelengte.setCellValueFactory(new PropertyValueFactory<Etappe, Integer>("lengte"));

            data.addAll(etappeList);

            table_etappe.setItems(data);
        }
    }

    private void toonWedstrijdKlassement() {
        voegEtappesToe();

        Wedstrijd wedstrijd = table_wedstrijd.getSelectionModel().getSelectedItem();
        List<Loper> deelgenomenLopers = new ArrayList<>();
        List<PersoonEtappeResultaat> klassement = new ArrayList<>();

        if (wedstrijd != null) {
            Etappe etappe = wedstrijd.getEtappes().get(0);
            List<EtappeResultaat> etappeResultaatList = etappe.getEtappeResultaten();

            for (EtappeResultaat etappeResultaat : etappeResultaatList) {
                deelgenomenLopers.add(etappeResultaat.getLoper());
            }

            for (Loper loper : deelgenomenLopers) {
                PersoonEtappeResultaat loperInKlassement = new PersoonEtappeResultaat();

                List<EtappeResultaat> gelopenEtappes = loper.getEtappeResultaten();
                int tijd = 0;

                for (EtappeResultaat gelopenEtappe : gelopenEtappes) {
                    tijd += gelopenEtappe.getTijd();
                }

                loperInKlassement.setNaam(loper.getPersoon().getNaam());
                loperInKlassement.setVoornaam(loper.getPersoon().getVoornaam());
                loperInKlassement.setTijd(tijd);

                klassement.add(loperInKlassement);
            }

            ObservableList<PersoonEtappeResultaat> data = FXCollections.observableArrayList();
            table_klassementachternaam.setCellValueFactory(new PropertyValueFactory<PersoonEtappeResultaat, String>("naam"));
            table_klassementvoornaam.setCellValueFactory(new PropertyValueFactory<PersoonEtappeResultaat, String>("voornaam"));
            table_klassementtijd.setCellValueFactory(new PropertyValueFactory<PersoonEtappeResultaat, Integer>("tijd"));
            table_klassementtijd.setSortType(TableColumn.SortType.ASCENDING);
            table_klassementplaats.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PersoonEtappeResultaat, Integer>, ObservableValue<Integer>>() {
                @Override
                public ObservableValue<Integer> call(TableColumn.CellDataFeatures<PersoonEtappeResultaat, Integer> param) {
                    return new SimpleIntegerProperty(data.indexOf(param.getValue()) + 1).asObject();
                }
            });

            data.addAll(klassement);
            data.sort((o1, o2) -> o1.getTijd() - o2.getTijd());
            table_klassement.setItems(data);
        }
    }

    private void toonEtappeKlassement() {
        Etappe etappe = table_etappe.getSelectionModel().getSelectedItem();
        List<Loper> deelgenomenLopers = new ArrayList<>();
        List<PersoonEtappeResultaat> klassement = new ArrayList<>();

        if (etappe == null) {
            showAlert("Warning", "Selecteer eerst een etappe");
        } else {
            List<EtappeResultaat> etappeResultaatList = etappe.getEtappeResultaten();

            for (EtappeResultaat etappeResultaat : etappeResultaatList) {
                deelgenomenLopers.add(etappeResultaat.getLoper());
            }

            for (Loper loper : deelgenomenLopers) {
                PersoonEtappeResultaat loperInKlassement = new PersoonEtappeResultaat();
                List<EtappeResultaat> gelopenEtappes = loper.getEtappeResultaten();
                int tijd = 0;

                for (EtappeResultaat resultaat : gelopenEtappes) {
                    if (resultaat.getEtappe().getEtappe_id() == etappe.getEtappe_id()) {
                        tijd = resultaat.getTijd();
                    }
                }

                loperInKlassement.setNaam(loper.getPersoon().getNaam());
                loperInKlassement.setVoornaam(loper.getPersoon().getVoornaam());
                loperInKlassement.setTijd(tijd);

                klassement.add(loperInKlassement);
            }

            ObservableList<PersoonEtappeResultaat> data = FXCollections.observableArrayList();
            table_klassementachternaam.setCellValueFactory(new PropertyValueFactory<PersoonEtappeResultaat, String>("naam"));
            table_klassementvoornaam.setCellValueFactory(new PropertyValueFactory<PersoonEtappeResultaat, String>("voornaam"));
            table_klassementtijd.setCellValueFactory(new PropertyValueFactory<PersoonEtappeResultaat, Integer>("tijd"));
            table_klassementtijd.setSortType(TableColumn.SortType.ASCENDING);
            table_klassementplaats.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PersoonEtappeResultaat, Integer>, ObservableValue<Integer>>() {
                @Override
                public ObservableValue<Integer> call(TableColumn.CellDataFeatures<PersoonEtappeResultaat, Integer> param) {
                    return new SimpleIntegerProperty(data.indexOf(param.getValue()) + 1).asObject();
                }
            });

            data.addAll(klassement);
            data.sort((o1, o2) -> o1.getTijd() - o2.getTijd());
            table_klassement.setItems(data);
        }
    }

    public void showAlert(String title, String content) {
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }


    private Persoon user;

    public KlassementController(Persoon user) {
        this.user = user;
    }
}
