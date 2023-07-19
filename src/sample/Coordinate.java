package sample;

public class Coordinate {
    public Float lon;
    public Float lat;
    Coordinate(Float lon,Float lat){
            this.lon= lon;
            this.lat= lat;
    }
    public Float getLon() {
        return this.lon;
    }
    public void setLon(Float lon) {

        this.lon = lon;
    }
    public Float getLat() {
        return this.lat;
    }
    public void setLat(Float lat) {
        this.lat = lat;
    }
}
