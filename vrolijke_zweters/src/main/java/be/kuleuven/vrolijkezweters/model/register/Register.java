package be.kuleuven.vrolijkezweters.model.register;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Register {
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty password = new SimpleStringProperty("");
    private StringProperty voornaam = new SimpleStringProperty("");
    private StringProperty naam = new SimpleStringProperty("");
    private StringProperty gender = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> geboorteDatum = new SimpleObjectProperty<>();

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getVoornaam() {
        return voornaam.get();
    }

    public StringProperty voornaamProperty() {
        return voornaam;
    }

    public void setVoornaam (String voornaam) {
        this.voornaam.set(voornaam);
    }

    public String getNaam() {
        return naam.get();
    }

    public StringProperty naamProperty() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam.set(naam);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum.get();
    }

    public ObjectProperty<LocalDate> geboorteDatumProperty() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(LocalDate geboorteDatum) {
        this.geboorteDatum.set(geboorteDatum);
    }
}