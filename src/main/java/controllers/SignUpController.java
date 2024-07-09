package controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Pattern;

import CodeAlpha.CodeAlpha_Hotel_Reservation_System.App;
import DAO.UserDAO;
import DAO.UserData;
import Entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SignUpController {
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
    private TextField fullnameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField addressField;
    @FXML
    private DatePicker birthdayDatePicker;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label emailLabel;

    @FXML
    private void login() throws IOException {
        App.setRoot("Login");
    }

    @FXML
    private void signUp() throws SQLException, IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String fullName = fullnameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        LocalDate birthday = birthdayDatePicker.getValue();

        if (!isValidEmail(email)) {
            emailLabel.setText("Invalid email, please verify it");
        } else if (UserDAO.isExistUsername(username)) {
            usernameLabel.setText("This username already exists, please choose another one");
        } else {
            User user = new User(username, password, fullName, email, phone, Date.valueOf(birthday), address);
            UserDAO.insertion(user);

            UserData userFormData = UserData.getInstance();
            userFormData.setUsername(username);
            App.setRoot("MainMenu");
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
