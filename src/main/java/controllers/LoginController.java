package controllers;

import java.io.IOException;
import java.sql.SQLException;

import CodeAlpha.CodeAlpha_Hotel_Reservation_System.App;
import DAO.UserDAO;
import DAO.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginController {
    @FXML
    private VBox mainMenu;
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;

    @FXML
    private void login(ActionEvent event) throws SQLException, IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (UserDAO.validateLogin(username, password)) {
            UserData userFormData = UserData.getInstance();
            userFormData.setUsername(username);
            App.setRoot("MainMenu");
        } else {
            errorLabel.setText("Username and password don't match");
        }
    }

    @FXML
    private void signUp(ActionEvent event) throws IOException {
        App.setRoot("SignUp");
    }
}
