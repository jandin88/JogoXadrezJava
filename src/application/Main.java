package application;

import static application.Ui.clearScreen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ChessMatch chessMatch= new ChessMatch();
        List<ChessPiece> captured=new ArrayList<>();

        while (true) {
            
            try {
                clearScreen();
                System.out.println();
                Ui.printMatch(chessMatch,captured);  
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = Ui.readChessPosition(sc);

                boolean[][] posibleMoves=chessMatch.possibleMoves(source);
                Ui.clearScreen();
                 System.out.println();
                Ui.printBoard(chessMatch.getPiece(),posibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = Ui.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.perform(source, target);

                if(capturedPiece!=null){
                    captured.add(capturedPiece);
                }
            }catch(ChessException e){
                System.out.println(e.getMessage()+ "\npreess Enter");
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println(e.getMessage()+ "\npreess Enter");
                sc.nextLine();

            }
        }
    }
}