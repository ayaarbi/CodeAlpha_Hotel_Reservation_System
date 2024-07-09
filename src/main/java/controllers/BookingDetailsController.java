package controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import CodeAlpha.CodeAlpha_Hotel_Reservation_System.App;
import DAO.BookingDAO;
import DAO.UserData;
import Entity.Booking;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookingDetailsController {

    @FXML
    private TableView<Booking> bookingTableView;
    @FXML
    private TableColumn<Booking, Integer> roomNumberColumn;
    @FXML
    private TableColumn<Booking, Date> startDateColumn;
    @FXML
    private TableColumn<Booking, Date> endDateColumn;
    @FXML
    private TableColumn<Booking, Double> priceColumn;
    @FXML
    private TableColumn<Booking, Integer> cardNumberColumn;
    @FXML
    private Button backButton;
    @FXML
    private ObservableList<Booking> list;

    @FXML
    public void initialize() {
        UserData userFormData = UserData.getInstance();
        String username = userFormData.getUsername();

        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        cardNumberColumn.setCellValueFactory(new PropertyValueFactory<>("cardNumber"));

        try {
            list = BookingDAO.getAllHistory(username);
            bookingTableView.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void back() throws IOException {
        App.setRoot("MainMenu");
    }
}
