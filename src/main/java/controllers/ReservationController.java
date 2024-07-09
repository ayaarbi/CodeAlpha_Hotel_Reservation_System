package controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import CodeAlpha.CodeAlpha_Hotel_Reservation_System.App;
import DAO.BookingDAO;
import DAO.RoomDAO;
import DAO.RoomData;
import DAO.UserDAO;
import DAO.UserData;
import Entity.Booking;
import Entity.Room;
import Entity.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ReservationController {
    @FXML
    private TextField nighTextField;
    @FXML
    private TextField cardTextField;
    @FXML
    private Label nightLabel;
    @FXML
    private Label cardLabel;
    @FXML
    private Label startLabel;
    @FXML
    private Label endLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Button payButton;
    @FXML
    private Button backButton;

    private Room selectedRoom;

    @FXML
    public void initialize() throws SQLException {
        RoomData roomFormData = RoomData.getInstance();
        int roomNumber = roomFormData.getRoomNumber();
        selectedRoom = RoomDAO.selectionRoom(roomNumber);

        nighTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                updateLabels();
            }
        });
    }

    private void updateLabels() {
        try {
            int nightNumber = Integer.parseInt(nighTextField.getText());
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusDays(nightNumber);
            double price = selectedRoom.getPricePerNight() * nightNumber;

            priceLabel.setText(String.valueOf(price));
            startLabel.setText(startDate.toString());
            endLabel.setText(endDate.toString());
            nightLabel.setText("");
        } catch (NumberFormatException e) {
            priceLabel.setText("0.00");
            startLabel.setText("");
            endLabel.setText("");
            nightLabel.setText("Number of nights must be a numerical value");
        }
    }

    @FXML
    private void pay(ActionEvent event) throws SQLException, IOException {
        UserData userFormData = UserData.getInstance();
        String username = userFormData.getUsername();
        User user = UserDAO.selectionUser(username);

        RoomData roomFormData = RoomData.getInstance();
        int roomNumber = roomFormData.getRoomNumber();
        Room room = RoomDAO.selectionRoom(roomNumber);

        try {
            int nightNumber = Integer.parseInt(nighTextField.getText());
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusDays(nightNumber);
            double price = room.getPricePerNight() * nightNumber;

            try {
                int cardNumber = Integer.parseInt(cardTextField.getText());
                Booking booking = new Booking(user, room, Date.valueOf(startDate), Date.valueOf(endDate), price, cardNumber);
                BookingDAO.insertion(booking);

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Successful payment");
                alert.setHeaderText(null);
                alert.setContentText("You have paid $" + price + " successfully");
                alert.showAndWait();

                App.setRoot("MainMenu");
            } catch (NumberFormatException e) {
                cardLabel.setText("Card number must be a numerical value");
            }

        } catch (NumberFormatException e) {
            nightLabel.setText("Number of nights must be a numerical value");
        }
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        App.setRoot("Room");
    }
}
