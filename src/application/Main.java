package application;

import chess.ChessMatch;

public class Main {
    public static void main(String[] args) {

        ChessMatch chessMatch= new ChessMatch();
        Ui.printBoard(chessMatch.getPiece());
    }
}