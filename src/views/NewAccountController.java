package views;

import Core.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class NewAccountController {
    File profilePic = null;
    boolean check1 = FALSE;
    boolean check2 = FALSE;
    ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");

    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField email;
    @FXML
    TextField phoneNum;
    @FXML
    TextField ssn;
    @FXML
    DatePicker dob;
    @FXML
    TextField userName;
    @FXML
    PasswordField password;
    @FXML
    PasswordField password2;
    @FXML
    ChoiceBox gender;
    @FXML
    TextField notice;

    @FXML
    private void initialize(){
        gender.setItems(genderList);
    }

    public void createAccount() {

        if(password.getText().equals(password2.getText())) {

            /* Clean input data */
            Image image = new Image(profilePic.toURI().toString());
            BufferedImage bimg = SwingFXUtils.fromFXImage(image, null);
            String ssn_string = ssn.getText();
            String phone_num = phoneNum.getText();
            phone_num = phone_num.replace("-","");
            Object genderO = gender.getValue();
            String gender = (String) genderO;
            int ssn = Integer.parseInt(ssn_string);
            int phoneNum = Integer.parseInt(phone_num);

            /*Assign account info */
            User user = new User(firstName.getText(), lastName.getText(), ssn, dob.getValue(), gender, userName.getText(), email.getText(), phoneNum, password.getText(), bimg);

            /* Validate email and Password */
            if (user.isValidEmailAddress(email.getText())){
                check1 = TRUE;
            }
            else {
                notice.setText("ERROR: YOU HAVE AN INVALID EMAIL ADDRESS");
            }

            if (user.validatePassword(password.getText())){
                check2 = TRUE;
            }
            else {
                notice.setText("ERROR: PASSWORD MUST BE 8+ CHARACTERS WITH 1 UPPERCASE, 1 LOWERCASE, 1 SPECIAL CHARACTER");
            }

            /* Create Account */
            if (check1 && check2){
            AccountList.getUsers().add(user);
            try {
                AcctDataTracker.outputAccounts(AccountList.getUsers());
                notice.setText("ACCOUNT CREATED");
            } catch (IOException e) {
                System.err.println("Cannot write Account to binary file!");
                notice.setText("ERROR: PASSWORDS DO NOT MATCH");
                e.printStackTrace();
            }
        }} else {
            notice.setText("ERROR: PASSWORDS DO NOT MATCH");
            password.setStyle("-fx-background-color: #3074cd; -fx-text-fill: white; -fx-border-color: red");
            password2.setStyle("-fx-background-color: #3074cd; -fx-text-fill: white; -fx-border-color: red");
        }
        System.out.println(AccountList.getUsers());
    }

    @FXML
    public File uploadProfilePic() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Picture");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File pic = fileChooser.showOpenDialog(RegisterDriver.getRegisterStage());
        File profilePic = pic.getAbsoluteFile();
        return profilePic;
    }
}

