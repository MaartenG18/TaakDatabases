package be.kuleuven.vrolijkezweters.controller;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import be.kuleuven.vrolijkezweters.database.EtappeDao;
import be.kuleuven.vrolijkezweters.database.WedstrijdDao;
import be.kuleuven.vrolijkezweters.model.Etappe;
import be.kuleuven.vrolijkezweters.model.Wedstrijd;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BeheerWedstrijdToevoegenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_naam;

    @FXML
    private TextField txt_startlocatie;

    @FXML
    private Button btn_wedstrijdetappetoevoegen;

    @FXML
    private DatePicker txt_datum;

    @FXML
    private TextField txt_eindlocatie;

    @FXML
    private TextField txt_inschrijvingsgeld;

    @FXML
    private TextArea txt_lengtes;

    @FXML
    private TextArea txt_locaties;

    @FXML
    void initialize() {
        assert txt_naam != null : "fx:id=\"txt_naam\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert txt_startlocatie != null : "fx:id=\"txt_startlocatie\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert btn_wedstrijdetappetoevoegen != null : "fx:id=\"btn_wedstrijdetappetoevoegen\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert txt_datum != null : "fx:id=\"txt_datum\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert txt_eindlocatie != null : "fx:id=\"txt_eindlocatie\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert txt_inschrijvingsgeld != null : "fx:id=\"txt_inschrijvingsgeld\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert txt_lengtes != null : "fx:id=\"txt_lengtes\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";
        assert txt_locaties != null : "fx:id=\"txt_locaties\" was not injected: check your FXML file 'beheerwedstrijdtoevoegen.fxml'.";

        btn_wedstrijdetappetoevoegen.setOnAction(e -> wedstrijdToevoegen());
    }

    private void wedstrijdToevoegen() {
        if (txt_datum == null || txt_naam == null || txt_inschrijvingsgeld == null || txt_startlocatie == null || txt_eindlocatie == null
            || txt_lengtes == null || txt_locaties == null) {
            showAlert("Warning", "Niet alle velden zijn ingevuld");
        } else {
            WedstrijdDao wedstrijdDao = new WedstrijdDao();
            Wedstrijd wedstrijd = new Wedstrijd();
            EtappeDao etappeDao = new EtappeDao();

            wedstrijd.setDatum(txt_datum.getValue());
            wedstrijd.setNaam(txt_naam.getText());
            wedstrijd.setInschrijvingsgeld(Integer.parseInt(txt_inschrijvingsgeld.getText()));
            wedstrijd.setStartLocatie(txt_startlocatie.getText());
            wedstrijd.setEindLocatie(txt_eindlocatie.getText());

            wedstrijdDao.createWedstrijd(wedstrijd);

            String[] lengtes = txt_lengtes.getText().split("/");
            List<String> listLengtes = Arrays.asList(lengtes);

            String[] locaties = txt_locaties.getText().split("/");
            List<String> listLocaties = Arrays.asList(locaties);

            if (listLengtes.size() != listLocaties.size()) {
                showAlert("Warning", "Het aantal lengtes en locaties komt niet overeen");
            } else {
                for (int i = 0; i < listLengtes.size(); i++) {
                    Etappe etappe = new Etappe();

                    etappe.setLengte(Integer.parseInt(listLengtes.get(i)));
                    etappe.setLocatie(listLocaties.get(i));
                    etappe.setWedstrijd(wedstrijd);

                    etappeDao.createEtappe(etappe);
                    wedstrijd.voegEtappeToe(etappe);
                }
                wedstrijdDao.updateWedstrijd(wedstrijd);

                txt_datum.setValue(null);
                txt_naam.setText("");
                txt_startlocatie.setText("");
                txt_eindlocatie.setText("");
                txt_inschrijvingsgeld.setText("");
                txt_lengtes.setText("");
                txt_locaties.setText("");

                showAlertGelukt("Gelukt", "De wedstrijd en bijhorende etappe zijn succesvol toegevoegd");
            }
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
