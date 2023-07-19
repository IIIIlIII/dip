package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


import static Dijkstra.die.minimum;

public class ControllerDijkstra {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lable;

    @FXML
    void initialize() {
        lable.setText(minimum);
    }

}
