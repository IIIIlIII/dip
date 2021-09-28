package sample;

import java.util.Iterator;
import static sample.MenuController.adress;

public class MatrixSm {
    private int arr[][];
    private int n;
    MatrixSm(int n){
        this.arr = new int[n][n];
        this.n = n;
    }
    public int[][] getArr(){
        return this.arr;
    }
    public void fill() {
        for (int i = 0; i < n; i++)
            for(int j=0; j < n; j++)
                if(i!=j)
                    this.arr[i][j] = 1;
    }
    public void WriteToArray(int i,int j,int elem){
        this.arr[i][j]=elem;
    }
    public void deleteLine(String sourcePoint, String targetPoint){
        Iterator<String> iter = adress.StrArr.iterator();
        int j=0,i= 0;
        int k=0,l=0;
        while (iter.hasNext()) {
            if(iter.next()==sourcePoint)
                k=i;
            i++;
        }
        iter = adress.StrArr.iterator();
        while (iter.hasNext()){
            if(iter.next()==targetPoint)
                l=j;
            j++;
        }
        this.arr[k][l] = 0;
        this.arr[l][k] = 0;
    }
    public int matrixSize(){
        return this.n;
    }
    public void matrixShow(){
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(this.arr[i][j] + " ");
            System.out.println();
        }
    }
    public int getElement(int i,int j){
        return this.arr[i][j];
    }
}
