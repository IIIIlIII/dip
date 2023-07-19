package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class ControllerLoad {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adr;

    @FXML
    private Button OkayButton;

    static MatrixSm matrixSmLoad;
    static ArrayList<int[][]> arrMatixSmLoad;

    @FXML
    void initialize() {

        OkayButton.setOnAction(event -> {
            readfileMatrix(adr.getText());//C:/Users/grigo/Desktop/file
            Stage stage = (Stage) OkayButton.getScene().getWindow();
            stage.close();
        });
    }
    public void readfileMatrix(String fileway) {
        FileInputStream fileInputStream = null;
        ArrayList Matrixlist = null;
        try {
            fileInputStream = new FileInputStream(fileway);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Matrixlist = (ArrayList) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Iterator iter = Matrixlist.iterator();

        int[][] mass = (int[][]) iter.next();
        arrMatixSmLoad.add(mass);
        matrixSmLoad = new MatrixSm(mass.length);
        for (int i = 0; i < mass.length; i++){
            for (int j = 0; j < mass.length; j++) {
                matrixSmLoad.WriteToArray(i, j, mass[i][j]);
                System.out.print(matrixSmLoad.getElement(i, j) + " ");
            }
            System.out.println();
        }
    }
}
