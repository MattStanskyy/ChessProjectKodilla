package com.kodilla.chess.functions;

public class Moves {
    private int col;
    private int row;
    private MoveKind moveKind;
    private boolean moveOver;

    public Moves(int col, int row, MoveKind moveKind, boolean moveOver) {
        this.col = col;
        this.row = row;
        this.moveKind = moveKind;
        this.moveOver = moveOver;
    }
    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public MoveKind getMoveKind() {
        return moveKind;
    }

    public boolean isMoveOver() {
        return moveOver;
    }

}
