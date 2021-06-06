package com.kodilla.chess.pieces;

import com.kodilla.chess.functions.Color;
import com.kodilla.chess.functions.MoveKind;
import com.kodilla.chess.functions.Moves;
import com.kodilla.chess.functions.Piece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class King implements Piece {
    private ImageView image;
    private Color color;
    private final Image whiteKing = new Image("file:src/main/resources/WhiteKing.png");
    private final Image blackKing = new Image("file:src/main/resources/BlackKing.png");
    private boolean firstMove = true;

    public King(Color color) {
        this.color = color;
        if (color == Color.WHITE) {
            image = new ImageView(whiteKing);
        } else {
            image = new ImageView(blackKing);
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
        result.add(new Moves(0, -1, MoveKind.HIT, false));
        result.add(new Moves(-1,-1, MoveKind.HIT,false));
        result.add(new Moves(-1, 0, MoveKind.HIT, false));
        result.add(new Moves(0, 1, MoveKind.HIT, false));
        result.add(new Moves(1, 1, MoveKind.HIT, false));
        result.add(new Moves(1,0, MoveKind.HIT,false));
        result.add(new Moves(-1, 1, MoveKind.HIT, false));
        result.add(new Moves(1, -1, MoveKind.HIT, false));
        result.add(new Moves(0, -1, MoveKind.WITHOUTHIT, false));
        result.add(new Moves(-1,-1, MoveKind.WITHOUTHIT,false));
        result.add(new Moves(-1, 0, MoveKind.WITHOUTHIT, false));
        result.add(new Moves(0, 1, MoveKind.WITHOUTHIT, false));
        result.add(new Moves(1, 1, MoveKind.WITHOUTHIT, false));
        result.add(new Moves(1,0, MoveKind.WITHOUTHIT,false));
        result.add(new Moves(-1, 1, MoveKind.WITHOUTHIT, false));
        result.add(new Moves(1, -1, MoveKind.WITHOUTHIT, false));


        return result;
    }
}
