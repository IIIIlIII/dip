package sample;

import java.util.ArrayList;


public class Coor {
    private int numberLayrs;
    public void setNumberLayers(int numberLayrs){
        this.numberLayrs = numberLayrs;
    }
    public int getNumberLayers(){
        return this.numberLayrs;
    }
    public  ArrayList<Float> arLongitude = new ArrayList<>();
    public ArrayList<Float> arLatitude = new ArrayList<>();
    public ArrayList<Float> ArLatitudeCoor = new ArrayList<>();
    public ArrayList<Float> ArLongitudeCoor = new ArrayList<>();
    public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
    private boolean flag = false;
    public boolean FlagOn(){return this.flag = true;}
    public boolean FlagOff(){return this.flag = false;}
    public boolean isFlag(){return  this.flag;}

    public int distanceAr(int i,int j) {

        double latDistance = Math.toRadians(ArLatitudeCoor.get(i) - ArLatitudeCoor.get(j));
        double lngDistance = Math.toRadians(ArLongitudeCoor.get(i) - ArLongitudeCoor.get(j));

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(ArLatitudeCoor.get(i))) * Math.cos(Math.toRadians(ArLatitudeCoor.get(j)))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c));
    }
    public int distanceAr2(Float longitudeI, Float latitudeI,Float longitudeJ, Float latitudeJ) {

        double latDistance = Math.toRadians(latitudeI - latitudeJ);
        double lngDistance = Math.toRadians(longitudeI - longitudeJ);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitudeI)) * Math.cos(Math.toRadians(latitudeJ))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c));
    }
    public int distancear(int i,int j) {

        double latDistance = Math.toRadians(arLatitude.get(i) - arLatitude.get(j));
        double lngDistance = Math.toRadians(arLongitude.get(i) - arLongitude.get(j));

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(arLatitude.get(i))) * Math.cos(Math.toRadians(arLatitude.get(j)))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c));
    }
}
