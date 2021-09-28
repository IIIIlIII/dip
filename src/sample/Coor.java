package sample;

import java.util.ArrayList;


public class Coor {
    public  ArrayList<Float> arLongitude = new ArrayList<>();
    public  ArrayList<Float> arLatitude = new ArrayList<>();
    public ArrayList<Float> ArLatitudeCoor = new ArrayList<>();
    public ArrayList<Float> ArLongitudeCoor = new ArrayList<>();
    public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
    public int distanceAr(int i,int j) {

        double latDistance = Math.toRadians(ArLatitudeCoor.get(i) - ArLatitudeCoor.get(j));
        double lngDistance = Math.toRadians(ArLongitudeCoor.get(i) - ArLongitudeCoor.get(j));

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(ArLatitudeCoor.get(i))) * Math.cos(Math.toRadians(ArLatitudeCoor.get(j)))
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
