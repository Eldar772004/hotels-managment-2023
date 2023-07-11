package com.managment.hotels.hotels.admin;

import com.managment.hotels.reservation.room.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableFloatArray;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Font;
import javafx.util.converter.IntegerStringConverter;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public class RoomAdminPanel {
    private final Label titleLabel = new Label("Administracija soba");

    private final TableView<Room> roomTableView = new TableView<>();

    private final TextField roomCodeTextField = new TextField();
    private final TextField numberOfBedsTextField = new TextField();
    private final TextField priceTextField = new TextField();
    private final Button addButton = new Button("Dodaj sobu");

    private final Button editButton = new Button("Ažuriraj sobu");
    private final Button deleteButton = new Button("Obriši sobu");

    private ObservableList<Room> observableRoomList;
    public RoomAdminPanel(){
        titleLabel.setFont(new Font("Arial", 20));
        setSpacing(5);
        setPadding(new Insets(10));
        bindTableWithData();
        configureTableView();
    }

    private Object getForm() {
        return null;
    }

    private void configureTableView() {
        roomTableView.setEditable(true);
        TableColumn<Room, String> roomCodeColumn = new TableColumn<>("Code");
        roomCodeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        roomCodeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    private void onRoomFieldChange(TableColumn.CellEditEvent<Room, String> event, Object o) {
    }

    private void bindTableWithData() {
        observableRoomList = FXCollections.observableList((List<Room>) RoomServiceLocal.ROOM_SERVICE.findAll());
        roomTableView.setItems(observableRoomList);
    }

    private void setPadding(Insets insets) {

    }

    private void setSpacing(int i) {

    }

    public <E> Collection<E> getChildren() {

        return null;
    }

    public void setChildren(Collection children) {

    }
}
