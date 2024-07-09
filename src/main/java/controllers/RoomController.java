package controllers;

import java.io.IOException;
import java.sql.SQLException;
import CodeAlpha.CodeAlpha_Hotel_Reservation_System.App;
import DAO.RoomDAO;
import DAO.RoomData;
import Entity.Room;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Callback;
import javafx.scene.control.cell.PropertyValueFactory;

public class RoomController {

    @FXML
    private TableView<Room> roomTableView;
    @FXML
    private TableColumn<Room, Integer> numberColumn;
    @FXML
    private TableColumn<Room, String> classColumn;
    @FXML
    private TableColumn<Room, String> priceColumn;
    @FXML
    private TableColumn<Room, String> availableColumn; // Kept as String
    @FXML
    private Button reserveButton;
    @FXML
    private Button backButton;
    private ObservableList<Room> list;

    @FXML
    public void initialize() {
        reserveButton.setDisable(true);
        roomTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                reserveButton.setDisable(false);
            } else {
                reserveButton.setDisable(true);
            }
        });

        numberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        classColumn.setCellValueFactory(new PropertyValueFactory<>("roomClass"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("pricePerNight"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        // Custom cell factory for the Availability column
        availableColumn.setCellFactory(new Callback<TableColumn<Room, String>, TableCell<Room, String>>() {
            @Override
            public TableCell<Room, String> call(TableColumn<Room, String> param) {
                return new TableCell<Room, String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.equals("0") ? "Available" : "Not Available");
                        }
                    }
                };
            }
        });

        try {
            list = RoomDAO.getAllRooms();
            roomTableView.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void reserveRoom() throws IOException {
        Room selectedRoom = roomTableView.getSelectionModel().getSelectedItem();
        if (selectedRoom != null) {
            if (selectedRoom.getAvailability().equals("0")) {
                RoomData roomFormData = RoomData.getInstance();
                roomFormData.setRoomNumber(selectedRoom.getRoomNumber());
                App.setRoot("Reservation");
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Room Not Available");
                alert.setHeaderText(null);
                alert.setContentText("This room is not available for reservation.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void back() throws IOException {
        App.setRoot("MainMenu");
    }
}
