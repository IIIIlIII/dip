package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

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
    @FXML
    private CheckBox Box1;

    @FXML
    private CheckBox Box2;

    private ObservableList<Coordinate> usersData = FXCollections.observableArrayList();

    public static MatrixSm matrixSmCoor;
    static MatrixCost matrixCostCoor;


    @FXML
    void initialize() {
        initData();
        TableView.setItems(usersData);
        LatColumn.setCellValueFactory(new PropertyValueFactory<>("Lat"));
        LonColumn.setCellValueFactory(new PropertyValueFactory<>("Lon"));
        Iterator<Float> iter = coordinate.arLongitude.iterator();
        int j = 0;
        while(iter.hasNext()){
            iter.next();
            j++;
        }
        matrixCostCoor = new MatrixCost(j);
        matrixCostCoor.fill();
        matrixSmCoor = new MatrixSm(j);
        matrixSmCoor.fill();
        matrixSmCoor.matrixShow();

    }
    private void initData() {
        Iterator<Float> iter1 = coordinate.ArLatitudeCoor.iterator();
        Iterator<Float> iter2 = coordinate.ArLongitudeCoor.iterator();
        while(iter1.hasNext() && iter2.hasNext()) {
            usersData.add(new Coordinate(iter2.next(),iter1.next()));
        }
    }
}
