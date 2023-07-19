package sample;

import java.util.Iterator;

import static sample.MenuController.adress;

public class MatrixCost {
    private double arr[][];
    private int n;
    MatrixCost(int n){
        this.arr = new double[n][n];
        this.n = n;
    }
    public int getSize(){
        return n;
    }
    public void fill() {
        for (int i = 0; i < n; i++)
            for(int j=0; j < n; j++)
                    this.arr[i][j] = 0;
    }
//    public void deleteLine(String sourcePoint, String targetPoint){
//        Iterator<String> iter = adress.StrArr.iterator();
//        int j=0,i= 0;
//        int k=0,l=0;
//        while (iter.hasNext()) {
//            if(iter.next()==sourcePoint)
//                k=i;
//            i++;
//        }
//        iter = adress.StrArr.iterator();
//        while (iter.hasNext()){
//            if(iter.next()==targetPoint)
//                l=j;
//            j++;
//        }
//        this.arr[k][l] = 0;
//        this.arr[l][k] = 0;
//    }
    public void matrixShow(){
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(this.arr[i][j] + " ");
            System.out.println();
        }
    }
    public void matrixFillOnArr(int n, int m){
        for(int i=n;i<m;i++){
            for(int j=n;j<m;j++){
                if(i!=j)
                    arr[i][j] = 1;
            }
        }
    }
    public double[][] getArr(){
        return this.arr;
    }
    public void setArr(int i, int j,double elem){
        this.arr[i][j]=elem;
    }
    public double getElement(int i,int j){
        return this.arr[i][j];
    }
}
