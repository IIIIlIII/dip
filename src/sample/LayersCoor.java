package sample;

import java.util.ArrayList;
import java.util.Iterator;

public class LayersCoor {
    public ArrayList<Coor> ListLayersCoor = new ArrayList<>();
    public ArrayList<MatrixSm> ListMatrixSm =new ArrayList<>();
    public ArrayList<MatrixCost> ListMatrixCost =new ArrayList<>();
    Coor coordinate;
    public int getNumber(int numberLayers){
        //System.out.println(numberLayers);
        coordinate = ListLayersCoor.get(numberLayers);
        return coordinate.getNumberLayers();
    }
//    public void setNumber(int numberLayers,int number){
//        Coor coordinate = layersCoor.get(numberLayers);
//        coordinate.setNumberLayers(number);
//
//    }
    public void setCoorLongitude(int numberLayers, float coor){
        Iterator<Coor> iter = ListLayersCoor.iterator();
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//        }
        coordinate = ListLayersCoor.get(numberLayers);
        coordinate.ArLongitudeCoor.add(coor);
        //ListLayersCoor.remove(numberLayers);
        //ListLayersCoor.add(numberLayers,coordinate);
    }
    public void setCoorLatitude(int numberLayers, float coor){
        Coor coordinate = ListLayersCoor.get(numberLayers);
        coordinate.ArLatitudeCoor.add(coor);
        ListLayersCoor.remove(numberLayers);
        ListLayersCoor.add(numberLayers,coordinate);
    }
}
