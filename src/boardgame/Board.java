package boardgame;

public class Board {

    private int rows;
    private int collunms;
    private Piece[][] pieces;

    public Board(int rows, int collunms){
        if(rows<1||collunms<1){
            throw new BoardException("Error creating board: There must be at least 1 row and 1 column");
        }
        this.rows=rows;
        this.collunms=collunms;
        pieces=new Piece[rows][collunms];
    }

    public Piece piece(int row,int collunm){
        if(!positionExists(row,collunm)){
            throw new BoardException("Position not on the board");
        }
        return pieces[row][collunm];
    }
    //fazendo uma sobrecagar no metodo para ele retorna as colluns e rows do position
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("There is already a piece on postion "+position);
        }
        pieces[position.getRow()][position.getColumn()]=piece;
        piece.position=position;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(),position.getColumn());
    }

    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < collunms;
    }
    public boolean thereIsAPiece(Position position){
        return piece(position)!=null;
    }

    public int getRows() {
        return rows;
    }

    public int getCollunms() {
        return collunms;
    }

}
