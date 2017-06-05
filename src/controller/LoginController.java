package controller;

import Core.*;
import views.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LoginController {
    public static ProfileInfo profile;

    @FXML
    TextField userName;
    @FXML
    PasswordField password;
    @FXML
    Label failAuthentication;

    public void openRegister() throws IOException {
        System.out.println("Opening Registration...");
        new RegisterDriver();
    }
    

    /** Check login credentials */   
    public void authenticate() throws IOException {
    	/** Loop through AccountList to validate if it exists */

        for (int i = 0; i < AccountList.getUsers().size(); i++) {
        	/** compare userName and password from user input to each username and password from AccountList */

            if (userName.getText().equals(AccountList.getUsers().get(i).getUserName())
                    && password.getText().equals(AccountList.getUsers().get(i).getPassword())) {
                System.out.println("Account information accepted.");
                profile = new ProfileInfo(AccountList.getUsers().get(i).getFirstName(), AccountList.getUsers().get(i).getLastName(), AccountList.getUsers().get(i).getEmail(), AccountList.getUsers().get(i).getPhone(), AccountList.getUsers().get(i).getGender(), AccountList.getUsers().get(i).getDob(), AccountList.getUsers().get(i).getPhoto());
                new ProfileDriver();
                System.out.println("welcome" + " " + userName.getText() );
                break;
            } else {
                failAuthentication.setVisible(true);
            }
        }
    }

}