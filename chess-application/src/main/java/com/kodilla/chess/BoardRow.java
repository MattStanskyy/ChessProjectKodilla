package com.kodilla.chess;

import com.kodilla.chess.functions.Piece;
import com.kodilla.chess.pieces.None;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {
    private List<Piece> cols = new ArrayList<>();

    public BoardRow() {
        for (int i = 0; i < 8; i++) {
            cols.add(new None());
        }
    }

    public List<Piece> getCols() {
        return cols;
    }
}