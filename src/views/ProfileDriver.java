package views;

/* Java class file that calls to show and load User Profile */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

abstract class ProfileDriver extends Application {
    private static Stage profileStage = new Stage();

    ProfileDriver() throws IOException {

        Parent profileView = FXMLLoader.load(getClass().getResource("ProfilePage.fxml"));
        profileStage.setTitle("Your Profile");
        Scene registerScene = new Scene(profileView, 600, 600);

        profileStage.setScene(registerScene);
        profileStage.show();
    }

    public static Stage getProfileStage() {
        return profileStage;
    }


}
