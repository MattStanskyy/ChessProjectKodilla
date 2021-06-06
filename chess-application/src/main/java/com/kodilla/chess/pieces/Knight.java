package com.kodilla.chess.pieces;

import com.kodilla.chess.functions.Color;
import com.kodilla.chess.functions.MoveKind;
import com.kodilla.chess.functions.Moves;
import com.kodilla.chess.functions.Piece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Knight implements Piece {
    private ImageView image;
    private Color color;
    private final Image whiteKnight = new Image("file:src/main/resources/WhiteKnight.png");
    private final Image blackKnight = new Image("file:src/main/resources/BlackKnight.png");
    private boolean firstMove = true;

    public Knight(Color color) {
        this.color = color;
        if (color == Color.WHITE) {
            image = new ImageView(whiteKnight);
        } else {
            image = new ImageView(blackKnight);
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
    public ImageView getImage() {
        return image;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public List<Moves> getMoves() {
        List<Moves> result = new ArrayList<>();
        result.add(new Moves(-1, -2, MoveKind.HIT, false));
        result.add(new Moves(-2,-1, MoveKind.HIT,false));
        result.add(new Moves(1, 2, MoveKind.HIT, false));
        result.add(new Moves(2, 1, MoveKind.HIT, false));
        result.add(new Moves(-1, 2, MoveKind.HIT, false));
        result.add(new Moves(-2,1, MoveKind.HIT,false));
        result.add(new Moves(1, -2, MoveKind.HIT, false));
        result.add(new Moves(2, -1, MoveKind.HIT, false));
        result.add(new Moves(-1, -2, MoveKind.WITHOUTHIT, false));
        result.add(new Moves(-2,-1, MoveKind.WITHOUTHIT,false));
        result.add(new Moves(1, 2, MoveKind.WITHOUTHIT, false));
        result.add(new Moves(2, 1, MoveKind.WITHOUTHIT, false));
        result.add(new Moves(-1, 2, MoveKind.WITHOUTHIT, false));
        result.add(new Moves(-2,1, MoveKind.WITHOUTHIT,false));
        result.add(new Moves(1, -2, MoveKind.WITHOUTHIT, false));
        result.add(new Moves(2, -1, MoveKind.WITHOUTHIT, false));
        return result;
    }
}