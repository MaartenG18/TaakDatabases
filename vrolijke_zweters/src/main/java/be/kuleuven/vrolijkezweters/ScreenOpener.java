package be.kuleuven.vrolijkezweters;

import be.kuleuven.vrolijkezweters.controller.AdminController;
import be.kuleuven.vrolijkezweters.controller.HomeController;
import be.kuleuven.vrolijkezweters.controller.LoginController;
import be.kuleuven.vrolijkezweters.controller.RegisterController;
import be.kuleuven.vrolijkezweters.model.Login;
import be.kuleuven.vrolijkezweters.model.Persoon;
import be.kuleuven.vrolijkezweters.model.Register;
import be.kuleuven.vrolijkezweters.view.HomeView;
import be.kuleuven.vrolijkezweters.view.LoginView;
import be.kuleuven.vrolijkezweters.view.RegisterView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenOpener {
    private String fileName;
    private Persoon persoon;

    public ScreenOpener(String fileName) {
        this.fileName = fileName;

        openScreen();
    }

    public ScreenOpener(String fileName, Persoon persoon) {
        this.fileName = fileName;
        this.persoon = persoon;

        openScreen();
    }

    private void openScreen() {
        switch (fileName) {
            case "login":
                openLoginScreen();
                break;
            case "register":
                openRegisterScreen();
                break;
            case "home":
                openHomeScreen();
                break;
            case "admin":
                openAdminScreen();
                break;
        }
    }

    private void openHomeScreen() {
        try {
            Stage stage = new Stage();
            HomeView homeView = new HomeView(stage);
            HomeController homeController = new HomeController(homeView, persoon);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("main.fxml"));
            fxmlLoader.setController(homeController);
            Parent root = fxmlLoader.load();
            homeView.setRoot(root);
            homeView.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openRegisterScreen() {
        try {
            Stage stage = new Stage();
            Register registerModel = new Register();
            RegisterView registerView = new RegisterView(stage, registerModel);
            RegisterController registerController = new RegisterController(registerModel, registerView);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("register.fxml"));
            fxmlLoader.setController(registerController);
            Parent root = fxmlLoader.load();
            registerView.setRoot(root);
            registerView.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openLoginScreen() {
        try {
            Stage stage = new Stage();
            Login loginModel = new Login();
            LoginView loginView = new LoginView(stage, loginModel);
            LoginController loginController = new LoginController(loginModel, loginView);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("login.fxml"));
            fxmlLoader.setController(loginController);
            Parent root = fxmlLoader.load();
            loginView.setRoot(root);
            loginView.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openAdminScreen() {
        try {
            Stage stage = new Stage();
            AdminController adminController = new AdminController();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("admin.fxml"));
            fxmlLoader.setController(adminController);
            Parent root = fxmlLoader.load();
            var scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("De Vrolijke Zweters - Admin");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
