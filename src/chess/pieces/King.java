package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    // associação para O Roque
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    public Boolean testRockCastiling(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;

    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollunms()];

        Position p = new Position(0, 0);
        // above
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // bellow
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        // left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // sd
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        /********** // #Especial move Castiling *************/

        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // roque right
            Position ptRight = new Position(position.getRow(), position.getColumn() + 3);
            if (testRockCastiling(ptRight)) {
                Position home1 = new Position(position.getRow(), position.getColumn() + 1);
                Position home2 = new Position(position.getRow(), position.getColumn() + 2);

                if (getBoard().piece(home1) == null && getBoard().piece(home2) == null) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            // roque left
            Position ptLeft = new Position(position.getRow(), position.getColumn() - 4);
            if (testRockCastiling(ptLeft)) {
                Position home1 = new Position(position.getRow(), position.getColumn() - 1);
                Position home2 = new Position(position.getRow(), position.getColumn() - 2);
                Position home3 = new Position(position.getRow(), position.getColumn() - 3);

                if (getBoard().piece(home1) == null && getBoard().piece(home2) == null
                        && getBoard().piece(home3) == null) {
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }
}
