package sample;

import java.net.URL;

import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import static sample.ControllerAddCoor.coordinate;


public class ControllerCoorTable {
    addr a= new addr("a");
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Coordinate> TableView;

    @FXML
    private TableColumn<Coordinate, String > LonColumn;

    @FXML
    private TableColumn<Coordinate, String> LatColumn;

    private ObservableList<Coordinate> usersData = FXCollections.observableArrayList();


    @FXML
    void initialize() {
        initData();
        TableView.setItems(usersData);
        LatColumn.setCellValueFactory(new PropertyValueFactory<>("Lat"));
        LonColumn.setCellValueFactory(new PropertyValueFactory<>("Lon"));
//    private void initData() {
//            usersData.add(adress);
//        TableView.setItems(usersData);
    }
    private void initData() {
        Iterator<Float> iter1 = coordinate.ArLatitudeCoor.iterator();
        Iterator<Float> iter2 = coordinate.ArLongitudeCoor.iterator();
        while(iter1.hasNext()) {
            usersData.add(new Coordinate(iter2.next(),iter1.next()));
        }
    }
}
