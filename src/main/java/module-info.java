module com.managment.hotels.hotels {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires java.sql;
    requires java.sql.rowset;
    requires org.controlsfx.controls;


    opens com.hotel.hoteli to javafx.fxml;
    opens com.managment.hotels.gui.components to javafx.base;
    opens com.managment.hotels.country.town.address to org.controlsfx.controls;
    opens com.managment.hotels.country.town to org.controlsfx.controls;
    opens com.managment.hotels.country to org.controlsfx.controls;
    opens com.managment.hotels.user to  javafx.base;
    opens com.managment.hotels.user.privilege to org.controlsfx.controls;
    opens com.managment.hotels.reservation to org.controlsfx.controls;
    opens com.managment.hotels.reservation.guest to org.controlsfx.controls;
    opens com.managment.hotels.reservation.room to org.controlsfx.controls, javafx.base;

    exports com.managment.hotels;
    opens com.hotelijerstvo.hoteli.user.service to org.controlsfx.controls;

}