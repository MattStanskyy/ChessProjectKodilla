package com.kodilla.chess.pieces;

import com.kodilla.chess.functions.Color;
import com.kodilla.chess.functions.MoveKind;
import com.kodilla.chess.functions.Moves;
import com.kodilla.chess.functions.Piece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece {
    private ImageView image;
    private Color color;
    private final Image whitePawn = new Image("file:src/main/resources/WhitePawn.png");
    private final Image blackPawn = new Image("file:src/main/resources/BlackPawn.png");
    private boolean firstMove = true;

    public Pawn(Color color) {
        this.color = color;
        if (color == Color.WHITE) {
            image = new ImageView(whitePawn);
        } else {
            image = new ImageView(blackPawn);
        }
    }

    @Override
    public boolean isFirstMove() {
        return firstMove;
    }

    @Override
    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public List<Moves> getMoves() {
        List<Moves> result = new ArrayList<>();
        if (color == Color.WHITE) {
            result.add(new Moves(0, -1, MoveKind.WITHOUTHIT, false));
            result.add(new Moves(0,-2, MoveKind.FIRST,false));
            result.add(new Moves(-1, -1, MoveKind.HIT, false));
            result.add(new Moves(1, -1, MoveKind.HIT, false));
        } else {
            result.add(new Moves(0, 1, MoveKind.WITHOUTHIT, false));
            result.add(new Moves(0, 2, MoveKind.FIRST, false));
            result.add(new Moves(-1, 1, MoveKind.HIT, false));
            result.add(new Moves(1, 1, MoveKind.HIT, false));
        }
        return result;
    }

    @Override
    public ImageView getImage() {
        return image;
    }
}

