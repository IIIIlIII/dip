package sample;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.fxgraph.graph.CellType;
import com.fxgraph.graph.Graph;
import com.fxgraph.graph.Model;
import com.fxgraph.layout.base.Layout;
import com.fxgraph.layout.random.RandomLayout;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import static sample.ControllerAddCoor.coordinate;
import static sample.ControllerAddCoor.matrixSmCoor;

import static sample.ControllerLoad.matrixSmLoad;

import static sample.ControllerLoadCoor.arr;
import static sample.ControllerTableWithAdresses.*;


public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ShowButtonTable;

    @FXML
    private Button ShowButtonTable1;

    @FXML
    private Button MapShowButton;

    @FXML
    private Button GraphShowButton;

    @FXML
    private Button ExportButton;

    @FXML
    private Button AddCoorButton;

    @FXML
    private Button ShowButtonTableCoor;

    @FXML
    private MenuItem SaveAsButton;

    @FXML
    private MenuItem LoadButton;

    @FXML
    private MenuItem LoadButtonCoor;

    static Adress adress;
    Graph graph;
    static MatrixCost matrixCostCoor;

    @FXML
    void initialize() {

        ShowButtonTable.setOnAction(event -> {
            ShowButtonTable.getScene().getWindow();
            adress = new Adress();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TableWithAdresses.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        MapShowButton.setOnAction(event -> {
            MapShowButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("WebMapYandex.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();

            stage.setScene(new Scene(root));
            stage.fullScreenProperty();
            stage.showAndWait();
            //matrixSm.matrixShow();
        });
        GraphShowButton.setOnAction(event -> {
            graph = new Graph();
            MapShowButton.getScene().getWindow();
            BorderPane root = new BorderPane();
            graph = new Graph();
            root.setCenter(graph.getScrollPane());
            Scene scene = new Scene(root, 1024, 768);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            addGraphComponents();
            Layout layout = new RandomLayout(graph);
            layout.execute();
        });
        ShowButtonTable1.setOnAction(event -> {
            ShowButtonTable1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("GraphTable.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        AddCoorButton.setOnAction(event -> {
            ShowButtonTable.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CoorAdd.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        ShowButtonTableCoor.setOnAction(event -> {
            ShowButtonTableCoor.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CoorTable.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        SaveAsButton.setOnAction(event -> {
            ShowButtonTable.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("SaveAs.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        LoadButton.setOnAction(event -> {
            ShowButtonTable.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Load.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        LoadButtonCoor.setOnAction(event -> {
            ShowButtonTable.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("LoadCoor.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void addGraphComponents() {

        if (adress != null) {
            Model model = graph.getModel();
            graph.beginUpdate();
            Iterator<String> iter = adress.StrArr.iterator();
            while (iter.hasNext()) {
                model.addCell(iter.next(), CellType.LABEL);
            }
            for (int j = 0; j < matrixSm.matrixSize(); j++) {
                for (int i = 1 + j; i < matrixSm.matrixSize(); i++) {
                    matrixCost.setArr(i,j, coor.distancear(i,j));
                    model.addEdge(adress.StrArr.get(j), adress.StrArr.get(i));
                }
            }
            matrixCost.matrixShow();
            graph.endUpdate();
        }
        if (coordinate != null) {
            Iterator<Float> iterat = coordinate.ArLongitudeCoor.iterator();
            int l = 0;
            while (iterat.hasNext()) {
                iterat.next();
                l++;
            }
            matrixCostCoor = new MatrixCost(l);
            matrixCostCoor.fill();
            matrixSmCoor = new MatrixSm(l);
            matrixSmCoor.fill();
            Model model1 = graph.getModel();
            graph.beginUpdate();
            Iterator<Float> iter1 = coordinate.ArLatitudeCoor.iterator();
            Iterator<Float> iter2 = coordinate.ArLongitudeCoor.iterator();
            while (iter1.hasNext()) {
                model1.addCell(String.valueOf(iter1.next()) + " " + String.valueOf(iter2.next()), CellType.LABEL);
                //System.out.println(String.valueOf(iter1.next())+" "+String.valueOf(iter2.next()));
            }
            for (int j = 0; j < matrixSmCoor.matrixSize(); j++) {
                for (int i = 1 + j; i < matrixSmCoor.matrixSize(); i++) {
                    //System.out.println(coordinate.ArLatitudeCoor.get(j)+" "+coordinate.ArLatitudeCoor.get(j)+"  "+coordinate.ArLatitudeCoor.get(i)+" "+coordinate.ArLatitudeCoor.get(i));
                    matrixCostCoor.setArr(i,j,coordinate.distanceAr(i,j));

                    model1.addEdge(coordinate.ArLatitudeCoor.get(j) + " " + coordinate.ArLongitudeCoor.get(j), coordinate.ArLatitudeCoor.get(i) + " " + coordinate.ArLongitudeCoor.get(i));
                }
            }
            matrixCostCoor.matrixShow();
            graph.endUpdate();
        }
        System.out.println(arr!=null);
        if(arr!=null) {
            Iterator<Float> iterat = arr.ArLongitudeCoor.iterator();
            int l = 0;
            while (iterat.hasNext()) {
                iterat.next();
                l++;
            }
            MatrixCost matrixCostLoad = new MatrixCost(l);
            matrixCostLoad.fill();
            Model model1 = graph.getModel();
            graph.beginUpdate();
            Iterator<Float> iter1 = arr.ArLatitudeCoor.iterator();
            Iterator<Float> iter2 = arr.ArLongitudeCoor.iterator();
            while (iter1.hasNext()) {
                model1.addCell(String.valueOf(iter1.next())+" "+String.valueOf(iter2.next()), CellType.LABEL);
                //System.out.println(String.valueOf(iter1.next())+" "+String.valueOf(iter2.next()));
            }
            for (int j = 0; j < matrixSmLoad.matrixSize(); j++) {
                for (int i = 1 + j; i < matrixSmLoad.matrixSize(); i++) {
                    matrixCostLoad.setArr(i,j,arr.distanceAr(i,j));
                    System.out.println(arr.ArLatitudeCoor.get(j)+" "+arr.ArLongitudeCoor.get(j)+"      "+arr.ArLatitudeCoor.get(i)+" "+arr.ArLongitudeCoor.get(i));
                    model1.addEdge(arr.ArLatitudeCoor.get(j)+" "+arr.ArLongitudeCoor.get(j), arr.ArLatitudeCoor.get(i)+" "+arr.ArLongitudeCoor.get(i));
                }
            }
            matrixCostLoad.matrixShow();
            graph.endUpdate();
        }

    }
}
