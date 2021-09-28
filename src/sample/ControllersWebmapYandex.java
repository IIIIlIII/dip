package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import static sample.ControllerAddCoor.coordinate;
import static sample.ControllerAddCoor.matrixSmCoor;
import static sample.ControllerLoad.arrMatixSmLoad;
import static sample.ControllerLoad.matrixSmLoad;
import static sample.ControllerLoadCoor.*;
import static sample.ControllerTableWithAdresses.coor;
import static sample.ControllerTableWithAdresses.matrixSm;

public class ControllersWebmapYandex {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private WebView YandexWeb;

    @FXML
    void initialize() {
        if(coordinate!=null)
            htmlPage(coordinate.ArLatitudeCoor,coordinate.ArLongitudeCoor,matrixSmCoor);
        if(coor!=null)
            htmlPage(coor.arLatitude,coor.arLongitude,matrixSm);
        if(arr!=null){
            htmlPage(arr.ArLatitudeCoor,arr.ArLongitudeCoor,matrixSmLoad);
        }
        if(arrMatixSmLoad!=null){
            Iterator iter1 = arrMatixSmLoad.iterator();
            Iterator iter2 = arrMatixLonLoad.iterator();
            Iterator iter3 = arrMatixLatLoad.iterator();
            int k=0;
            WebEngine webEngine = YandexWeb.getEngine();
            while (iter1.hasNext()){

                String html = "<!DOCTYPE html>\n" +
                        "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                        "<head>\n" +
                        "    <title></title>\n" +
                        "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                        "    <script src=\"https://api-maps.yandex.ru/2.1/?apikey=8a520284-9af4-4c0c-89b5-5cd53b11ae5b&lang=ru_RU\" type=\"text/javascript\"></script>\n" +
                        "    <script src=\"arrList.json\" type=\"text/javascript\"></script>\n" +
                        "\n" +
                        "    <script type=\"text/javascript\">\n" +
                        "        ymaps.ready(init);\n" +
                        "        function init()\n" +
                        "        {\n" +
                        "            var myMap = new ymaps.Map(\"map\", {\n" +
                        "                center: ["+arrMatixLonLoad.get(0)+","+ arrMatixLatLoad.get(0)+"],\n" +
                        "                zoom: 7\n" +
                        "            });\n" +
                        "            myMap.container.fitToViewport();\n";
                //html += htmlPageArr();
                String html5="}\n" +
                        "    </script>\n" +
                        "\n" +
                        "</head>\n" +
                        "\n" +
                        "<body onload=\"load()\">\n" +
                        "    <div id=\"map\" style=\"width: 600px; height: 400px\"></div>\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>";
                html+=html5;
                System.out.println(html);
                webEngine.loadContent(html);
                webEngine.loadContent(html,"text/html");
            }
        }
    }
    public void htmlPage(ArrayList<Float> arLat,ArrayList<Float> arLong,MatrixSm arrSm){
        int k=0;
        WebEngine webEngine = YandexWeb.getEngine();
        String html = "<!DOCTYPE html>\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "    <title></title>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "    <script src=\"https://api-maps.yandex.ru/2.1/?apikey=8a520284-9af4-4c0c-89b5-5cd53b11ae5b&lang=ru_RU\" type=\"text/javascript\"></script>\n" +
                "    <script src=\"arrList.json\" type=\"text/javascript\"></script>\n" +
                "\n" +
                "    <script type=\"text/javascript\">\n" +
                "        ymaps.ready(init);\n" +
                "        function init()\n" +
                "        {\n" +
                "            var myMap = new ymaps.Map(\"map\", {\n" +
                "                center: ["+arLat.get(0)+","+ arLong.get(0)+"],\n" +
                "                zoom: 7\n" +
                "            });\n" +
                "            myMap.container.fitToViewport();\n";


        String polyline = "myPolyline";
        String polylines = "";
        String html3 = "],},\n" +
                "properties:{\n " +
                    "       hintContent: \" \",\n" +
                    "                balloonContent: \" \"\n" +
                    "            }\n" +
                    "        }, {\n" +
                    "            draggable: true,\n" +
                    "            strokeColor: \"#ef98aa\",\n" +
                    "            strokeWidth: 1});\n";

        String html2;
        String html1;
        for(int i=0;i<arrSm.matrixSize();i++)
            for(int j=0+i;j<arrSm.matrixSize();j++) {
                if(arrSm.getElement(i,j)!=0) {
                    html2 = "[" + arLat.get(i) + "," + arLong.get(i) + "],\n" + "[" + arLat.get(j) + "," + arLong.get(j) + "]";
                    html1 ="var myPolyline"+k+" = new ymaps.GeoObject({\n" +
                            "geometry:{\n" +
                            "type: \"LineString\",\n" +
                            "coordinates:[\n";
                    polylines = polyline+k;
                    String html4 =
                            "myMap.geoObjects.add("+polylines +");\n";

                    String html123 = html1 + html2 + html3 + html4;
                    html+=html123;
                    k++;
                }
            }

        String html5="}\n" +
                "    </script>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body onload=\"load()\">\n" +
                "    <div id=\"map\" style=\"width: 600px; height: 400px\"></div>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        html+=html5;
        System.out.println(html);
        webEngine.loadContent(html);
        webEngine.loadContent(html,"text/html");
    }
    public String htmlPageArr(ArrayList<Float> arLat,ArrayList<Float> arLong,int [][] matrix) {
        int k = 0;
        String html0 = "";
        String polyline = "myPolyline";
        String polylines = "";
        String html3 = "],},\n" +
                "properties:{\n " +
                "       hintContent: \" \",\n" +
                "                balloonContent: \" \"\n" +
                "            }\n" +
                "        }, {\n" +
                "            draggable: true,\n" +
                "            strokeColor: \"#ef98aa\",\n" +
                "            strokeWidth: 1});\n";

        String html2;
        String html1;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0 + i; j < matrix.length; j++) {
                if (matrix[i][j] != 0) {
                    html2 = "[" + arLat.get(i) + "," + arLong.get(i) + "],\n" + "[" + arLat.get(j) + "," + arLong.get(j) + "]";
                    html1 = "var myPolyline" + k + " = new ymaps.GeoObject({\n" +
                            "geometry:{\n" +
                            "type: \"LineString\",\n" +
                            "coordinates:[\n";
                    polylines = polyline + k;
                    String html4 =
                            "myMap.geoObjects.add(" + polylines + ");\n";

                    String html123 = html1 + html2 + html3 + html4;
                    html0 += html123;
                    k++;
                }
            }
        return html0;
    }
}
