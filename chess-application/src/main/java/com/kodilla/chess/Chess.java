package com.kodilla.chess;

import com.kodilla.chess.pieces.None;
//import com.kodilla.chess.functions.Color;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Chess extends Application {
    private Image backgroundChessBoard = new Image("file:src/main/resources/Board.png");
    private Board board = new Board();
    private int selCol = -1;
    private int selRow = -1;

    public  static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100,100,true,true,true, false);
        BackgroundImage backgroundImage = new BackgroundImage(backgroundChessBoard, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setBackground(background);
        for (int i = 0; i < 8; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(96));
            grid.getRowConstraints().add(new RowConstraints(96));
        }

        board.initBoard();
        board.setGrid(grid);
        board.refreshGrid();

        grid.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            int col = (int)e.getX()/96;
            int row = (int)e.getY()/96;
            click(grid, col, row);
        });
        
        Scene scene = new Scene(grid, 800, 800, Color.BLACK);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void click(GridPane grid, int col, int row) {
        if ((selCol == -1) && !(board.getPiece(col,row) instanceof None)) {
            selCol = col;
            selRow = row;
        } else {
            if(selCol != -1 && selRow != -1) {
                System.out.println(selCol + "," + selRow + "," + col + "," + row);
                board.move(selCol, selRow, col, row);
                selCol = -1;
                selRow = -1;
            }
        }
        board.refreshGrid();
    }

}