package sample;

import java.util.ArrayList;

public class Adress {
    public ArrayList<String> StrArr;
    public String Str;
    private int i=0;
    private boolean flag = false;
    Adress(){
        this.StrArr = new ArrayList<>();
    }
    public boolean isFlag(){return  this.flag;}
    public boolean FlagOn(){return this.flag = true;}
    public boolean FlagOff(){return this.flag = false;}
    public void addAdress(String addres){
        this.StrArr.add(addres);
    }
    public String getAdress(int index){
        return this.StrArr.get(index);
    }
    public void Arr() {
        this.Str=StrArr.get(i);
        i++;
    }
    public String getStr() {
        return this.Str;
    }
    public void setStr(String Str) {
        this.Str = Str;
    }
}
