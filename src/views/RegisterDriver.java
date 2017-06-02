package views;

/* Java class file that calls to show and load New Account GUI page */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

abstract class RegisterDriver extends Application {
    private static Stage registerStage = new Stage();

    RegisterDriver() throws IOException {

        Parent registerView = FXMLLoader.load(getClass().getResource("NewAccount.fxml"));
        registerStage.setTitle("New Account Page");
        Scene registerScene = new Scene(registerView, 600, 600);

        registerStage.setScene(registerScene);
        registerStage.show();
    }

    public static Stage getRegisterStage() {
        return registerStage;
    }


}
