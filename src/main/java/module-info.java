module CodeAlpha.CodeAlpha_Hotel_Reservation_System {
    requires javafx.controls;
    requires javafx.fxml;
	requires transitive java.sql;
	requires javafx.base;
	
    opens controllers to javafx.fxml;
    opens Entity to javafx.base; 

    exports CodeAlpha.CodeAlpha_Hotel_Reservation_System;
    exports Entity; 
}
