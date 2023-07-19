package com.fxgraph.graph;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

import static sample.MenuController.*;


public class Edge extends Group {

    protected Cell source;
    protected Cell target;

    Line line;

    public Edge(Cell source, Cell target) {

        this.source = source;
        this.target = target;

        source.addCellChild(target);
        target.addCellParent(source);

        line = new Line();

        line.startXProperty().bind( source.layoutXProperty().add(source.getBoundsInParent().getWidth() / 2.0));
        line.startYProperty().bind( source.layoutYProperty().add(source.getBoundsInParent().getHeight() / 2.0));

        line.endXProperty().bind( target.layoutXProperty().add( target.getBoundsInParent().getWidth() / 2.0));
        line.endYProperty().bind( target.layoutYProperty().add( target.getBoundsInParent().getHeight() / 2.0));


        getChildren().add(line);

        line.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0) {
                line.startXProperty().bind( source.layoutXProperty().add(source.getBoundsInParent().getWidth() / 2.0));
                line.startYProperty().bind( source.layoutYProperty().add(source.getBoundsInParent().getHeight() / 2.0));
                line.endXProperty().bind( source.layoutXProperty().add(source.getBoundsInParent().getWidth() / 2.0));
                line.endYProperty().bind( source.layoutYProperty().add(source.getBoundsInParent().getHeight() / 2.0));
                if(matrixSm.matrixSize() != 0) {
                    matrixSm.deleteLine(source.cellId, target.cellId);
                    //matrixCost.deleteLine(source.cellId, target.cellId);
                }
                if(matrixSmCoor.matrixSize() != 0) {
                    matrixSmCoor.deleteLineCoor(source.cellId, target.cellId);
                   // matrixCostCoor.deleteLine(source.cellId, target.cellId);
                }
                //else
                   matrixSm.matrixShow();
                   matrixSmCoor.matrixShow();
            }
        });
    }

    public Cell getSource() {
        return source;
    }

    public Cell getTarget() {
        return target;
    }

}
