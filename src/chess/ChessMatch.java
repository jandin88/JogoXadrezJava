package chess;

import boardgame.Board;

public class ChessMatch {
    private Board board;

    public ChessMatch(){
        board=new Board(8,8);
    }
    public ChessPiece[][] getPiece(){
        ChessPiece[][] mat=new ChessPiece[board.getRows()][board.getCollunms()];
        for(int i=0;i< board.getRows();i++){
            for(int j=0;j< board.getCollunms();j++){
                mat[i][j]=(ChessPiece) board.piece(i,j);
            }
        }
        return mat;
    }
}
