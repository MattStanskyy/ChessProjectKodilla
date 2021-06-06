package com.kodilla.chess.pieces;

import com.kodilla.chess.functions.Color;
import com.kodilla.chess.functions.MoveKind;
import com.kodilla.chess.functions.Moves;
import com.kodilla.chess.functions.Piece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Rook implements Piece {
    private ImageView image;
    private Color color;
    private final Image whiteRook = new Image("file:src/main/resources/WhiteRook.png");
    private final Image blackRook = new Image("file:src/main/resources/BlackRook.png");
    private boolean firstMove = true;

    public Rook(Color color) {
        this.color = color;
        if (color == Color.WHITE) {
            image = new ImageView(whiteRook);
        } else {
            image = new ImageView(blackRook);
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
            result.add(new Moves(0, n, MoveKind.HIT, false));
            result.add(new Moves(n,0, MoveKind.HIT,false));
            result.add(new Moves(0, n, MoveKind.WITHOUTHIT, false));
            result.add(new Moves(n, 0, MoveKind.WITHOUTHIT, false));
        }
        return result;
    }
}
