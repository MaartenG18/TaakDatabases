package be.kuleuven.vrolijkezweters;

import be.kuleuven.vrolijkezweters.controller.HomeController;
import be.kuleuven.vrolijkezweters.controller.LoginController;
import be.kuleuven.vrolijkezweters.controller.RegisterController;
import be.kuleuven.vrolijkezweters.model.login.Login;
import be.kuleuven.vrolijkezweters.model.register.Register;
import be.kuleuven.vrolijkezweters.view.HomeView;
import be.kuleuven.vrolijkezweters.view.LoginView;
import be.kuleuven.vrolijkezweters.view.RegisterView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenOpener {
    private String fileName;

    public ScreenOpener(String fileName) {
        this.fileName = fileName;

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
        }
    }

    private void openHomeScreen() {
        try {
            Stage stage = new Stage();
            HomeView homeView = new HomeView(stage);
            HomeController homeController = new HomeController(homeView);

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
}
