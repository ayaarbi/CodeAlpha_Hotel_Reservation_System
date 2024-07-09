package controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import CodeAlpha.CodeAlpha_Hotel_Reservation_System.App;

public class MainMenuController {

    @FXML
    private VBox mainMenu;

    @FXML
    private Button profileButton;

    @FXML
    private Button bookingHistoryButton;

    @FXML
    private Button makeReservationButton;

    @FXML
    private Button exitButton;

    @FXML
    public void initialize() {
        profileButton.setOnAction(e -> loadView("Profile"));
        bookingHistoryButton.setOnAction(e -> loadView("BookingDetails"));
        makeReservationButton.setOnAction(e -> loadView("Room"));
        exitButton.setOnAction(e -> ((Stage) mainMenu.getScene().getWindow()).close());
    }

    private void loadView(String viewName) {
        try {
            App.setRoot(viewName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
