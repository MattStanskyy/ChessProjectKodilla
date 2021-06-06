package com.kodilla.chess.pieces;

import com.kodilla.chess.functions.Color;
import com.kodilla.chess.functions.Moves;
import com.kodilla.chess.functions.Piece;
import javafx.scene.image.ImageView;

import java.util.List;

public class None implements Piece {

    @Override
    public ImageView getImage() {
        return null;
    }

    @Override
    public Color getColor() {
        return Color.NONE;
    }

    @Override
    public List<Moves> getMoves() {
        return null;
    }

    @Override
    public boolean isFirstMove() {
        return false;
    }

    @Override
    public void setFirstMove(boolean firstMove) {
    }
}
