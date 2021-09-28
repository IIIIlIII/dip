package sample;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextField;
        import javafx.stage.Stage;

        import java.net.URL;
        import java.util.Iterator;
        import java.util.ResourceBundle;
import static sample.MenuController.adress;

import httpRequest.*;

public class ControllerTableWithAdresses {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adr;

    @FXML
    private Button OkayButton;

    @FXML
    private Button AddButton;


    static Coor coor;
    public static MatrixSm matrixSm;
    static MatrixCost matrixCost;

    @FXML
    void initialize() {
        coor = new Coor();
        HttpRequestSputnik httpRequest = new HttpRequestSputnik();
        HttpRequestYandex httpRequestYandex = new HttpRequestYandex();
        OkayButton.setOnAction(event -> {
            Stage stage = (Stage) OkayButton.getScene().getWindow();
            stage.close();
            Iterator<Float> iter = coor.arLongitude.iterator();
            int j = 0;
            while(iter.hasNext()){
                iter.next();
                j++;
            }
            matrixCost = new MatrixCost(j);
            matrixCost.fill();
            matrixSm = new MatrixSm(j);
            matrixSm.fill();
        });

        adr.setOnAction(event -> {
            if (adr.getText() != null) {
                adress.StrArr.add(adr.getText());
                if(((adr.getText().charAt(0)>'A')&&(adr.getText().charAt(0)<'Z'))||((adr.getText().charAt(0)>'a')&&(adr.getText().charAt(0)<'z')))
                    httpRequestYandex.httpRequestYandex(adr.getText(), coor.arLongitude, coor.arLatitude);
                else if(((adr.getText().charAt(0)>'А')&&(adr.getText().charAt(0)<'Я'))||((adr.getText().charAt(0)>'а')&&(adr.getText().charAt(0)<'я')))
                    httpRequest.httpRequestSputnik(adr.getText(), coor.arLongitude, coor.arLatitude);
                adr.setText("");
            }
        });
    }
    @FXML
    void pressed_enter(){
        HttpRequestSputnik httpRequest = new HttpRequestSputnik();
        if (adr.getText() != null) {
            adress.StrArr.add(adr.getText());
            httpRequest.httpRequestSputnik(adr.getText(), coor.arLongitude, coor.arLatitude);
        }
    }
}
