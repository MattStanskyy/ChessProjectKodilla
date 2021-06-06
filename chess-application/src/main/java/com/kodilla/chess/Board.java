package com.kodilla.chess;

import com.kodilla.chess.functions.*;
import com.kodilla.chess.pieces.*;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();
    private GridPane grid;
    private Color whoMoves = Color.WHITE;

    public Board() {
        for (int n = 0; n < 8; n++)
            rows.add(new BoardRow());
    }
    public Piece getPiece(int col, int row){
        return rows.get(row).getCols().get(col);
    }

    public void setPiece(int col, int row, Piece piece){
        rows.get(row).getCols().add(col,piece);
        rows.get(row).getCols().remove(col+1);
    }

    public void setGrid(GridPane grid) {
        this.grid = grid;
    }

    public void refreshGrid() {
        grid.getChildren().clear();
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                Piece piece = getPiece(col,row);
                if(!(piece instanceof None)) {
                    grid.add(piece.getImage(), col, row);
                    GridPane.setHalignment(piece.getImage(), HPos.CENTER);
                    GridPane.setValignment(piece.getImage(), VPos.CENTER);
                }
            }
        }
    }

    public void move(int col1, int row1, int col2, int row2) {
        Piece piece = getPiece(col1, row1);
        int deltaCol = col2-col1;
        int deltaRow = row2-row1;
        if (piece.getColor() != whoMoves) {
            return;
        }
        if (getPiece(col2, row2).getColor() == opponentMove(whoMoves)) {
            if (piece.getMoves().iterator().next().isMoveOver()) {
                if(checkPossibleMoves(piece,deltaCol,deltaRow,true)){
                    makeAMove(col1,row1,col2,row2,piece);
                }
            } else {
                if(isMoveOverFalse(col1,row1,col2,row2,piece,deltaCol,deltaRow,true)){
                    makeAMove(col1,row1,col2,row2,piece);
                }
            }
        } else {
            if (piece.getMoves().iterator().next().isMoveOver()) {
                if(checkPossibleMoves(piece,deltaCol,deltaRow,false)){
                    makeAMove(col1,row1,col2,row2,piece);
                }
            } else {
                if(isMoveOverFalse(col1,row1,col2,row2,piece,deltaCol,deltaRow,false)){
                    makeAMove(col1,row1,col2,row2,piece);
                }
            }
        }
    }

    public boolean checkPossibleMoves(Piece piece, int deltaCol, int deltaRow, boolean isHit){
        for (int n = 0; n < piece.getMoves().size(); n++) {
            if (deltaCol == piece.getMoves().get(n).getCol() && deltaRow == piece.getMoves().get(n).getRow() && isHit==(piece.getMoves().get(n).getMoveKind()== MoveKind.HIT)) {
                return true;
            }
        }
        return false;
    }

    public boolean isMoveOverFalse(int col1, int row1, int col2, int row2, Piece piece, int deltaCol, int deltaRow, boolean isHit) {
        if (firstMove(col1, row1)) {
            if(pathIsClear(col1,row1,col2,row2)){
                return checkPossibleMoves(piece,deltaCol,deltaRow,isHit);
            }
        } else {
            for (int n = 0; n < piece.getMoves().size(); n++) {
                if (deltaCol == piece.getMoves().get(n).getCol() && deltaRow == piece.getMoves().get(n).getRow()&& isHit==(piece.getMoves().get(n).getMoveKind()==MoveKind.HIT)) {
                    if (pathIsClear(col1, row1, col2, row2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void makeAMove(int col1, int row1, int col2, int row2, Piece piece){
        setPiece(col2, row2, piece);
        setPiece(col1, row1, new None());
        whoMoves = opponentMove(whoMoves);
        System.out.println(whoMoves);
    }


    public boolean firstMove(int col1, int row1){
        if(getPiece(col1,row1).isFirstMove()){
            getPiece(col1, row1).setFirstMove(false);
            return true;
        }
        return false;
    }

    public Color opponentMove(Color whoMoves) {
        return (whoMoves==Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private boolean pathIsClear(int col1, int row1, int col2, int row2) {
        boolean result = true;
        int dCol = col2-col1;
        int dRow = row2-row1;
        int motions = (Math.abs(dCol)>Math.abs(dRow)) ? Math.abs(dCol) : Math.abs(dRow);
        for(int n = 1; n < motions; n++){
            int tCol = col1+(dCol/motions)*n;
            int tRow = row1+(dRow/motions)*n;
            if(!(getPiece(tCol,tRow) instanceof None)){
                result = false;
            }
        }
        return result;
    }



    public void initBoard() {
        setPiece(0, 6, new Pawn(Color.WHITE));
        setPiece(1, 6, new Pawn(Color.WHITE));
        setPiece(2, 6, new Pawn(Color.WHITE));
        setPiece(3, 6, new Pawn(Color.WHITE));
        setPiece(4, 6, new Pawn(Color.WHITE));
        setPiece(5, 6, new Pawn(Color.WHITE));
        setPiece(6, 6, new Pawn(Color.WHITE));
        setPiece(7, 6, new Pawn(Color.WHITE));
        setPiece(0, 7, new Rook(Color.WHITE));
        setPiece(7, 7, new Rook(Color.WHITE));
        setPiece(1, 7, new Knight(Color.WHITE));
        setPiece(6, 7, new Knight(Color.WHITE));
        setPiece(2, 7, new Bishop(Color.WHITE));
        setPiece(5, 7, new Bishop(Color.WHITE));
        setPiece(3, 7, new Queen(Color.WHITE));
        setPiece(4, 7, new King(Color.WHITE));



        setPiece(0, 1, new Pawn(Color.BLACK));
        setPiece(1, 1, new Pawn(Color.BLACK));
        setPiece(2, 1, new Pawn(Color.BLACK));
        setPiece(3, 1, new Pawn(Color.BLACK));
        setPiece(4, 1, new Pawn(Color.BLACK));
        setPiece(5, 1, new Pawn(Color.BLACK));
        setPiece(6, 1, new Pawn(Color.BLACK));
        setPiece(7, 1, new Pawn(Color.BLACK));
        setPiece(0, 0, new Rook(Color.BLACK));
        setPiece(7, 0, new Rook(Color.BLACK));
        setPiece(1, 0, new Knight(Color.BLACK));
        setPiece(6, 0, new Knight(Color.BLACK));
        setPiece(2, 0, new Bishop(Color.BLACK));
        setPiece(5, 0, new Bishop(Color.BLACK));
        setPiece(3, 0, new Queen(Color.BLACK));
        setPiece(4, 0, new King(Color.BLACK));
    }
}
