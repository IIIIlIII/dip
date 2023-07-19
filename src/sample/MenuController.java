package sample;

import Dijkstra.die;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import static sample.ControllerAddCoor.coordinate;
import static sample.ControllerAddCoor.layerscoor;
import static sample.ControllerLoad.matrixSmLoad;
import static sample.ControllerLoadCoor.arr;
import static sample.ControllerTableWithAdresses.*;
public class MenuController {
    @FXML
    private WebView YandexWeb;
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
    @FXML
    private Button DijkstraButton;
    @FXML
    private ChoiceBox<String> ChooseBox;
    @FXML
    private TextField coorEdit;
    @FXML
    private TextField coorEdit1;
    public static Adress adress;
    static public CoorArr coorArr =  new CoorArr();
    Graph graph;
    public static MatrixSm matrixSmCoor = new MatrixSm(0);
    public static MatrixCost matrixCostCoor = new MatrixCost(0);
    public static MatrixSm matrixSmCoorB = new MatrixSm(0);
    public static MatrixCost matrixCostCoorB = new MatrixCost(0);
    public static MatrixSm matrixSm = new MatrixSm(0);
    public static MatrixCost matrixCost = new MatrixCost(0);
    static Model model;
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
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.fullScreenProperty();
            stage.showAndWait();
            //matrixSm.matrixShow();
        });
        GraphShowButton.setOnAction(event -> {
            //graph = new Graph();
            MapShowButton.getScene().getWindow();
            BorderPane root = new BorderPane();
            graph = new Graph();
            model = graph.getModel();
            root.setCenter(graph.getScrollPane());
            Scene scene = new Scene(root, 1024, 768);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            addGraphComponents(model);
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
            int m = 0;
            Iterator<Coor> iter = layerscoor.ListLayersCoor.iterator();
            while(iter.hasNext()) {
                coordinate = iter.next();
                Iterator<Float> iterat = coordinate.ArLongitudeCoor.iterator();
                int l = 0;
                while (iterat.hasNext()) {
                    iterat.next();
                    l++;
                    m++;
                }
                matrixCostCoor = new MatrixCost(l);
                matrixCostCoor.fill();
                layerscoor.ListMatrixCost.add(matrixCostCoor);
                matrixSmCoor = new MatrixSm(l);
                matrixSmCoor.fill();
                layerscoor.ListMatrixSm.add(matrixSmCoor);
                //matrixSmCoor.matrixShow();
                if(!iter.hasNext()){
                    matrixCostCoorB = new MatrixCost(m);
                    matrixSmCoorB = new MatrixSm(m);
                    Iterator<MatrixSm> iter1 = layerscoor.ListMatrixSm.iterator();
                    int k = 0;
                    while(iter1.hasNext()){
                        //System.out.println(i);
                        matrixSmCoor = iter1.next();
                        matrixSmCoorB.matrixFillOnArr(k,matrixSmCoor.matrixSize()+k);
                        k+=matrixSmCoor.matrixSize();
                    }

                }
            }
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
        ChooseBox.setOnAction(event -> selectSource());//вопросы
        DijkstraButton.setOnAction(event -> {
            die al = new die();
            al.DijkstraAlgoritm(ChooseBox.getValue());
            DijkstraButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("dijkstra.fxml"));
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
        coorEdit1.setOnAction(event -> {
            graph.beginUpdate();
            model.addEdge(coorEdit.getText(), coorEdit1.getText());
            String line = coorEdit.getText();
            String line1 = coorEdit1.getText();
            Float longitudeI, latitudeI;
            String [] masLine = line.split(" ");
            longitudeI = Float.valueOf(masLine[0]);
            latitudeI = Float.valueOf(masLine[1]);
            int i=0,j=0,k=0,d=0;
            Iterator<Coor> iter = layerscoor.ListLayersCoor.iterator();
            while(iter.hasNext()){
                coordinate = iter.next();
                Iterator<Float> iter1 = coordinate.ArLongitudeCoor.iterator();
                while (iter1.hasNext()){
                    if(longitudeI.equals(iter1.next())) {
                        System.out.println(k+" "+i);
                        k = i;

                        break;
                    }
                    i++;
                }
            }
            String []masLine1 = line1.split(" ");
            Float longitudeJ = Float.valueOf(masLine1[0]);
            Float latitudeJ = Float.valueOf(masLine1[1]);
            Iterator<Coor> iter3 = layerscoor.ListLayersCoor.iterator();
            while(iter3.hasNext()){
                coordinate = iter3.next();
                Iterator<Float> iter2 = coordinate.ArLongitudeCoor.iterator();
                while (iter2.hasNext()){
                    if(longitudeJ.equals(iter2.next())) {
                        System.out.println(d+" "+j);
                        d = j;
                        break;
                    }
                    j++;
                }
            }
            System.out.println(k+" "+d);
            matrixSmCoorB.setArr(k,d);
            matrixSmCoorB.setArr(d,k);
            matrixSmCoorB.matrixShow();
            matrixCostCoorB.setArr(k, d, coordinate.distanceAr2(longitudeI, latitudeI,longitudeJ,latitudeJ));
            matrixCostCoorB.setArr(d, k, coordinate.distanceAr2(longitudeJ,latitudeJ,longitudeI, latitudeI));
            graph.endUpdate();
        });
    }
    @FXML
    void  selectSource(){
//        System.out.println(coordinate!=null);
//        System.out.println((coordinate.isFlag()));
//        System.out.println(!adress.StrArr.isEmpty());
//        System.out.println(adress.isFlag());
        if((coordinate!=null)&&(coordinate.isFlag())) {
            if (matrixSmCoor.matrixSize() != 0) {
                Iterator<String> iter = coorArr.StrArr.iterator();
                //ChooseBox.getItems().add("");
                while (iter.hasNext()) {
                    ChooseBox.getItems().addAll(iter.next());
                }
            }
            coordinate.FlagOff();
        }
        if((adress!=null)&&(adress.isFlag())){
            if (matrixSm.matrixSize() != 0) {
                Iterator<String> iter = adress.StrArr.iterator();
                //ChooseBox.getItems().add("");
                while (iter.hasNext())
                    ChooseBox.getItems().addAll(iter.next());
            }
            adress.FlagOff();
        }
    }
    private void addGraphComponents(Model model) {
        if (adress != null) {
            graph.beginUpdate();
            Iterator<String> iter = adress.StrArr.iterator();
            while (iter.hasNext()){
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
            int k=0;
            graph.beginUpdate();
            Iterator<Coor> iter = layerscoor.ListLayersCoor.iterator();
            while(iter.hasNext()) {
                coordinate = iter.next();
                Iterator<Float> iter1 = coordinate.ArLatitudeCoor.iterator();
                Iterator<Float> iter2 = coordinate.ArLongitudeCoor.iterator();
                String nameAdress;
                while (iter1.hasNext()) {
                    nameAdress = String.valueOf(iter1.next()) + " " + String.valueOf(iter2.next());
                    coorArr.addAdress(nameAdress);
                    model.addCell(nameAdress, CellType.LABEL);
                }
                System.out.println(layerscoor.ListMatrixSm.get(k).matrixSize());
                for (int j = 0; j < layerscoor.ListMatrixSm.get(k).matrixSize(); j++) {
                    for (int i = 1 + j; i < layerscoor.ListMatrixSm.get(k).matrixSize(); i++) {
                        //System.out.println(coordinate.ArLatitudeCoor.get(j)+" "+coordinate.ArLatitudeCoor.get(j)+"  "+coordinate.ArLatitudeCoor.get(i)+" "+coordinate.ArLatitudeCoor.get(i));
                        layerscoor.ListMatrixCost.get(k).setArr(i, j, coordinate.distanceAr(i, j));
                        layerscoor.ListMatrixCost.get(k).setArr(j, i, coordinate.distanceAr(i, j));
                        matrixCostCoorB.setArr(i, j, coordinate.distanceAr(i, j));
                        matrixCostCoorB.setArr(j, i, coordinate.distanceAr(i, j));
                        matrixCostCoorB.matrixShow();
                        model.addEdge(coordinate.ArLatitudeCoor.get(j) + " " + coordinate.ArLongitudeCoor.get(j), coordinate.ArLatitudeCoor.get(i) + " " + coordinate.ArLongitudeCoor.get(i));
                        //ответственная за соединения точек рёбрами
                    }
                }
                k++;
            }
            graph.endUpdate();
        }
        //System.out.println(arr!=null);
        if (arr != null) {
            Iterator<Float> iterat = arr.ArLongitudeCoor.iterator();
            int l = 0;
            while (iterat.hasNext()) {
                iterat.next();
                l++;
            }
            MatrixCost matrixCostLoad = new MatrixCost(l);
            matrixCostLoad.fill();
            graph.beginUpdate();
            Iterator<Float> iter1 = arr.ArLatitudeCoor.iterator();
            Iterator<Float> iter2 = arr.ArLongitudeCoor.iterator();
            while (iter1.hasNext()){
                model.addCell(String.valueOf(iter1.next())+" "+String.valueOf(iter2.next()), CellType.LABEL);
                //System.out.println(String.valueOf(iter1.next())+" "+String.valueOf(iter2.next()));
            }
            for (int j = 0; j < matrixSmLoad.matrixSize(); j++) {
                for (int i = 1 + j; i < matrixSmLoad.matrixSize(); i++) {
                    matrixCostLoad.setArr(i,j,arr.distanceAr(i,j));
                    System.out.println(arr.ArLatitudeCoor.get(j)+" "+arr.ArLongitudeCoor.get(j)+"      "+arr.ArLatitudeCoor.get(i)+" "+arr.ArLongitudeCoor.get(i));
                    model.addEdge(arr.ArLatitudeCoor.get(j)+" "+arr.ArLongitudeCoor.get(j), arr.ArLatitudeCoor.get(i)+" "+arr.ArLongitudeCoor.get(i));
                }
            }
            matrixCostLoad.matrixShow();
            graph.endUpdate();
        }
    }
}
