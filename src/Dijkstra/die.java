package Dijkstra;

import java.util.ArrayList;
import java.util.Iterator;
import sample.MenuController;

import static sample.MenuController.*;


public class die {
    static public String minimum = "Calculating minimum distance:"+"\n";
    public void DijkstraAlgoritm(String value) {
        long start = System.currentTimeMillis();
        if(!coorArr.StrArr.isEmpty()) {
            Iterator<String> iter1 = coorArr.StrArr.iterator();
            String nameAdress;
            ArrayList<Vertex> VertexArr = new ArrayList<>();
            while (iter1.hasNext()) {
                nameAdress = iter1.next();
                Vertex v = new Vertex(nameAdress);
                VertexArr.add(v);
            }
            for (int i = 0; i < matrixSmCoorB.matrixSize(); i++) {
                for (int j = 1 + i; j < matrixSmCoorB.matrixSize(); j++) {
                    if (matrixSmCoorB.getElement(i, j) == 1) {
                        //System.out.println(matrixCostCoor.getElement(i,j)+" "+VertexArr.get(i)+" "+VertexArr.get(j));
                        VertexArr.get(i).addNeighbour(new Edge(matrixCostCoorB.getElement(i, j), VertexArr.get(i), VertexArr.get(j)));
                        VertexArr.get(j).addNeighbour(new Edge(matrixCostCoorB.getElement(i, j), VertexArr.get(j), VertexArr.get(i)));
                    }
                }
            }
            DijkstraShortestPath shortestPath = new DijkstraShortestPath();
            String j = "null-point";
            for (int i = 0; i < matrixSmCoorB.matrixSize(); i++) {
                if (value == VertexArr.get(i).getName()) {
                    shortestPath.computeShortestPaths(VertexArr.get(i));
                    System.out.println(VertexArr.get(i));
                    j = VertexArr.get(i).getName();
                    break;
                }
            }
            System.out.println("======================================");
            System.out.println("Calculating minimum distance");
            System.out.println("======================================");
            for (int i = 0; i < matrixSmCoorB.matrixSize(); i++) {
                minimum += "Minimum distance from " + j + " to " + VertexArr.get(i).getName() + ": " + VertexArr.get(i).getDistance()+"\n";
                System.out.println("Minimum distance from " + j + " to " + VertexArr.get(i).getName() + ": " + VertexArr.get(i).getDistance());
            }
            minimum+="======================================================="+"\n";
            minimum+="Calculating Paths"+"\n";
            System.out.println("=======================================================");
            System.out.println("Calculating Paths");
            System.out.println("======================================");
            for (int i = 0; i < matrixSmCoorB.matrixSize(); i++) {
                minimum+="Shortest Path from " + j + " to " + VertexArr.get(i).getName() + ": " + shortestPath.getShortestPathTo(VertexArr.get(i))+"\n";
                System.out.println("Shortest Path from " + j + " to " + VertexArr.get(i).getName() + ": " + shortestPath.getShortestPathTo(VertexArr.get(i)));
            }
        }
        else if(!adress.StrArr.isEmpty()){
            Iterator<String> iter1 = adress.StrArr.iterator();
            String nameAdress;
            ArrayList<Vertex> VertexArr = new ArrayList<>();
            while (iter1.hasNext()) {
                nameAdress = iter1.next();
                Vertex v = new Vertex(nameAdress);
                VertexArr.add(v);
            }
            for (int i = 0; i < matrixSm.matrixSize(); i++) {
                for (int j = 1 + i; j < matrixSm.matrixSize(); j++) {
                    if (matrixSm.getElement(i, j) == 1) {
                        //System.out.println(matrixCostCoor.getElement(i,j)+" "+VertexArr.get(i)+" "+VertexArr.get(j));
                        VertexArr.get(i).addNeighbour(new Edge(matrixCost.getElement(i, j), VertexArr.get(i), VertexArr.get(j)));
                        VertexArr.get(j).addNeighbour(new Edge(matrixCost.getElement(i, j), VertexArr.get(j), VertexArr.get(i)));
                    }
                }
            }
            DijkstraShortestPath shortestPath = new DijkstraShortestPath();
            String j = "null-point";
            for (int i = 0; i < matrixSm.matrixSize(); i++) {
                if (value == VertexArr.get(i).getName()) {
                    shortestPath.computeShortestPaths(VertexArr.get(i));
                    System.out.println(VertexArr.get(i));
                    j = VertexArr.get(i).getName();
                    break;
                }
            }
            System.out.println("======================================");
            System.out.println("Calculating minimum distance");
            System.out.println("======================================");
            for (int i = 0; i < matrixSm.matrixSize(); i++) {
                System.out.println("Minimum distance from " + j + " to " + VertexArr.get(i).getName() + ": " + VertexArr.get(i).getDistance());
            }
            System.out.println("=====================   =================");
            System.out.println("Calculating Paths");
            System.out.println("======================================");
            for (int i = 0; i < matrixSm.matrixSize(); i++) {
                System.out.println("Shortest Path from " + j + " to " + VertexArr.get(i).getName() + ": " + shortestPath.getShortestPathTo(VertexArr.get(i)));
            }
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println(elapsed + " ms");
    }
}