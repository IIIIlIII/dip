package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class ControllerAddCoor {

    @FXML
    private TextField NumberLayer;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField AddCoorLong;
    @FXML
    private TextField AddCoorLat;
    @FXML
    private ComboBox <Integer> ChooseNumberLayer;
    @FXML
    private Button OkayButton;
    @FXML
    private Button AddButton;

    public int Numberlayer;// количество слоёв
    static Coor coordinate;
    static int number;//текущий слой
    //static public ArrayList<Coor> LayersCoor = new ArrayList<>();
    static public LayersCoor layerscoor = new LayersCoor();//лист где хранятся слои
    static ObservableList<Integer> num = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        coordinate = new Coor();
        NumberLayer.setOnAction(event -> {
            if (NumberLayer.getText() != null) {
                Numberlayer = Integer.parseInt(NumberLayer.getText());
                //System.out.println(Numberlayer);
                Integer j;
                for(int i=0;i<Numberlayer;i++) {
                    coordinate = new Coor();
                    coordinate.setNumberLayers(i);
                    layerscoor.ListLayersCoor.add(coordinate);
                    //System.out.println(coordinate.getNumberLayers()+" "+layerscoor.getNumber(i));

                    j = i;
                    num.add(j);
                    ChooseNumberLayer.setItems(num);
                }
            }
        });
        ChooseNumberLayer.setOnAction(event -> {
            number = ChooseNumberLayer.getValue();
            //System.out.println(number);
        });
        OkayButton.setOnAction(event -> {
            coordinate.FlagOn();
            Stage stage = (Stage) OkayButton.getScene().getWindow();
            stage.close();
        });
        AddCoorLong.setOnAction(event -> {
            if (AddCoorLong.getText() != null) {
                        layerscoor.setCoorLongitude(number, Float.parseFloat(AddCoorLong.getText()));
                }
            AddCoorLong.setText("");
        });
        AddCoorLat.setOnAction(event -> {
            if (AddCoorLong.getText() != null)
                        layerscoor.setCoorLatitude(number, Float.parseFloat(AddCoorLat.getText()));
            AddCoorLat.setText("");
        });
    }
}
