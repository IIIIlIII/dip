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

import static sample.MenuController.adress;

public class ControllerGraphTable {
    addr a= new addr("a");
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<addr> TableView;

    @FXML
    private TableColumn<addr, String> AdressColumn;

    private ObservableList<addr> usersData = FXCollections.observableArrayList();


    @FXML
    void initialize() {
        initData();
        TableView.setItems(usersData);
        AdressColumn.setCellValueFactory(new PropertyValueFactory<>("Str"));
//    private void initData() {
//            usersData.add(adress);
//        TableView.setItems(usersData);
    }
    private void initData() {
        if(adress!=null) {
            Iterator<String> iter = adress.StrArr.iterator();
            while (iter.hasNext()) {
                usersData.add(new addr(iter.next()));
            }
        }
    }
}
