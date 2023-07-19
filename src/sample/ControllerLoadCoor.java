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

public class ControllerLoadCoor {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adr;

    @FXML
    private TextField adr1;

    @FXML
    private Button OkayButton;

    static Coor arr;
    static ArrayList<ArrayList> arrMatixLonLoad;
    static ArrayList<Float> arrMatixLatLoad;

    @FXML
    void initialize() {
        arr = new Coor();
        OkayButton.setOnAction(event -> {
            readfilelat(adr1.getText());
            readfilelon(adr.getText());
            Stage stage = (Stage) OkayButton.getScene().getWindow();
            stage.close();
        });
    }

    public void readfilelat(String fileway){
        FileInputStream fileInputStream = null;
        ArrayList<Float> Matrixlist = null;
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
        arr.ArLatitudeCoor = Matrixlist;
        arrMatixLatLoad = Matrixlist;
        Iterator iter =arr.ArLatitudeCoor.iterator();
        {
                while (iter.hasNext()) {
                    System.out.println(iter.next());
                }
        }

    }
    public void readfilelon(String fileway){
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
        arr.ArLongitudeCoor = Matrixlist;
        arrMatixLonLoad = Matrixlist;
        Iterator iter =arr.ArLongitudeCoor.iterator();
        {
                while (iter.hasNext()) {
                    System.out.println(iter.next());
                }
        }

    }
}

