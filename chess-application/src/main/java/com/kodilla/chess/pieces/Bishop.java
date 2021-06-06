package com.kodilla.chess.pieces;

import com.kodilla.chess.functions.Color;
import com.kodilla.chess.functions.MoveKind;
import com.kodilla.chess.functions.Moves;
import com.kodilla.chess.functions.Piece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Bishop implements Piece {
    private ImageView image;
    private Color color;
    private final Image whiteBishop = new Image("file:src/main/resources/WhiteBishop.png");
    private final Image blackBishop = new Image("file:src/main/resources/BlackBishop.png");
    private boolean firstMove = true;

    public Bishop(Color color) {
        this.color = color;
        if (color == Color.WHITE) {
            image = new ImageView(whiteBishop);
        } else {
            image = new ImageView(blackBishop);
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
        for (int n = -8; n < 8; n++) {
            result.add(new Moves(n, n, MoveKind.HIT, false));
            result.add(new Moves(-n,n, MoveKind.HIT,false));
            result.add(new Moves(n, n, MoveKind.WITHOUTHIT, false));
            result.add(new Moves(-n, n, MoveKind.WITHOUTHIT, false));
        }
        return result;
    }
}
