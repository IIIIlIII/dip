package sample;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static sample.ControllerAddCoor.coordinate;
import static sample.ControllerAddCoor.matrixSmCoor;
import static sample.ControllerTableWithAdresses.*;
import static sample.MenuController.matrixCostCoor;

public class ControllerSaveAs {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Way;

    @FXML
    private Button SaveButton;

    @FXML
    private TextField NameFile;

    String pathway = null;
    String namefile = null;

    @FXML
    void initialize() {
        SaveButton.setOnAction(event -> {
            Stage stage = (Stage) SaveButton.getScene().getWindow();
            stage.close();
            //writefile(matrixSm,coor,pathway+namefile);
            pathway = Way.getText();
            namefile = NameFile.getText();
            if(coor!=null)
                writefile(matrixSm,coor, matrixCost,pathway+namefile);
            if(coordinate!=null)
                writefile(matrixSmCoor,coordinate, matrixCostCoor,pathway+namefile);
        });
    }

    public void writefile(MatrixSm matrixS,Coor c,MatrixCost matrixC, String pathWay){
        ArrayList<int[][]> matrixList = new ArrayList<>();
        matrixList.add(matrixS.getArr());
        ArrayList<double[][]> matrixListCost = new ArrayList<>();
        matrixListCost.add(matrixC.getArr());
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(pathWay);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(matrixList);
            objectOutputStream.close();
            outputStream = new FileOutputStream(pathWay+"MatrixCost");
            ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(outputStream);
            objectOutputStream0.writeObject(matrixListCost);
            objectOutputStream0.close();
            outputStream = new FileOutputStream(pathWay+"lon");
            ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(outputStream);
            objectOutputStream1.writeObject(c.arLongitude);
            outputStream = new FileOutputStream(pathWay+"lat");
            objectOutputStream.close();
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(outputStream);
            objectOutputStream2.writeObject(c.arLatitude);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
