package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;

import java.util.ResourceBundle;

public class ControllerAddCoor {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AddCoorLong;

    @FXML
    private TextField AddCoorLat;

    @FXML
    private Button OkayButton;

    @FXML
    private Button AddButton;


    static Coor coordinate;
    public static MatrixSm matrixSmCoor;
    static Adress adressCoor;

    @FXML
    void initialize() {
        coordinate = new Coor();
        OkayButton.setOnAction(event -> {
            Stage stage = (Stage) OkayButton.getScene().getWindow();
            stage.close();
        });
        AddCoorLong.setOnAction(event -> {
            if (AddCoorLong.getText() != null) {
                coordinate.ArLongitudeCoor.add(Float.parseFloat(AddCoorLong.getText()));
            }
            AddCoorLong.setText("");
        });
        AddCoorLat.setOnAction(event -> {
            if (AddCoorLat.getText() != null) {
                coordinate.ArLatitudeCoor.add(Float.parseFloat(AddCoorLat.getText()));
            }
            AddCoorLat.setText("");
        });


    }
}
