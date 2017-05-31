package Controllers;

import Core.*;
import gui_loaders.*;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import view.HospitalListJavaFXView;

import java.io.IOException;

public class LoginController {
    @FXML
    TextField userName;
    @FXML
    PasswordField password;

    boolean exist;

    {
        exist = false;
    }

    /* Check login credentials */
    public void authenticate() {
        /* Loop through AccountList to validate if it exists */
        for (int i = 0; i < AccountList.getUsers().size(); i++) {
            /* compare userName and password from user input to each username and password from AccountList */
            if (userName.getText().equals(AccountList.getUsers().get(i).getUserName()) && password.getText().equals(AccountList.getUsers().get(i).getPassword())) {
                System.out.println("Welcome " + userName.getText());
                try {
                    new HospitalListJavaFXView();
                } catch (IOException e) {
                    System.err.println("Error opening profile page.");
                    e.printStackTrace();
                }
                exist = true;
            }
        }

    }

    public void openRegister() throws IOException {
        System.out.println("Opening Registration...");
        new RegisterDriver();
    }
}