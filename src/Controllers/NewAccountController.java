package Controllers;

import Core.*;
import gui_loaders.RegisterDriver;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;
import java.io.IOException;

public class NewAccountController {
    @FXML
    TextField userName;
    @FXML
    PasswordField password;
    @FXML
    PasswordField password2;

    public void createAccount() {
        if(password.getText().equals(password2.getText())) {
            User user = new User(userName.getText(),password.getText());
            AccountList.getUsers().add(user);
            try {
                AcctDataTracker.outputAccounts(AccountList.getUsers());
            } catch (IOException e) {
                System.err.println("Cannot write UserDB to binary file!");
                e.printStackTrace();
            }
        } else {
            password.setStyle("-fx-background-color: slateblue; -fx-text-fill: white; -fx-border-color: red");
            password2.setStyle("-fx-background-color: slateblue; -fx-text-fill: white; -fx-border-color: red");
        }
        System.out.println(AccountList.getUsers());
    }

    public void uploadProfilePic() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Picture");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(RegisterDriver.getRegisterStage());
        System.out.println(selectedFile.getPath());
    }
}

