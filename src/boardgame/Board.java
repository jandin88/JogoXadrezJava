package boardgame;

public class Board {

    private int rows;
    private int collunms;
    private Piece[][] pieces;

    public Board(int rows, int collunms){
        this.rows=rows;
        this.collunms=collunms;
        pieces=new Piece[rows][collunms];
    }

    public Piece piece(int rows,int collunms){
        return pieces[rows][collunms];
    }
    //fazendo uma sobrecagar no metodo para ele retorna as colluns e rows do position
    public Piece piece(Position position){
        return pieces[position.getRow()][position.getRow()];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCollunms() {
        return collunms;
    }

    public void setCollunms(int collunms) {
        this.collunms = collunms;
    }
}
