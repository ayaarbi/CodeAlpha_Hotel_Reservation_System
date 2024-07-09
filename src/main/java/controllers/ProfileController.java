package controllers;

import java.io.IOException;
import CodeAlpha.CodeAlpha_Hotel_Reservation_System.App;
import DAO.UserDAO;
import DAO.UserData;
import Entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ProfileController {
    @FXML
    private VBox profileBox;
    @FXML
    private Button backButton;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label fullNameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label birthdayLabel;

    @FXML
    public void initialize() {
        displayProfile();
    }

    @FXML
    private void displayProfile() {
        UserData userFormData = UserData.getInstance();
        String username = userFormData.getUsername();
        User user = UserDAO.selectionUser(username);

        usernameLabel.setText("@" + username);
        fullNameLabel.setText(user.getFullName());
        emailLabel.setText(user.getEmail());
        phoneLabel.setText(user.getPhone());
        addressLabel.setText(user.getAddress());
        birthdayLabel.setText(user.getBirthday().toString());
    }

    @FXML
    public void back() throws IOException {
        App.setRoot("MainMenu");
    }
}
