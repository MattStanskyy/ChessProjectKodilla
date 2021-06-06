package com.kodilla.chess.functions;

import javafx.scene.image.ImageView;

import java.util.List;

public interface Piece {
    ImageView getImage();
    Color getColor();
    List<Moves> getMoves();
    boolean isFirstMove();
    void setFirstMove(boolean firstMove);
}
