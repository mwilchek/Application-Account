package views;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ProfileController {

    @FXML
    ImageView profilePic;
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField gender;
    @FXML
    TextField dob;

    public void logOff(){
        System.exit(0);
    }

}
