package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

import static application.Ui.clearScreen;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ChessMatch chessMatch= new ChessMatch();
        while (true) {
            
            try {
                clearScreen();
                System.out.println();
                Ui.printBoard(chessMatch.getPiece());
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

                ChessPiece capturedPizzece = chessMatch.perform(source, target);
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