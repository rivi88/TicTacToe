package com.rmac;

import com.rmac.tictactoe.GameBoard;
import com.rmac.tictactoe.WinConditions;

import java.util.ArrayList;
import java.util.Scanner;

public class AppTicTacTou {

    public static ArrayList<Integer> player1Positions = new ArrayList<>();
    public static ArrayList<Integer> player2Positions = new ArrayList<>();

    public static void main(String[] args) {
        GameBoard board = new GameBoard();

        WinConditions winConditions = new WinConditions();

        GameBoard.printGameBoard(board.getGameBoard());//gameBoard gose inside GameBoard and has public method to get it or add sth
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Please Player1 select your field by keyboard (1-9) ");
            int player1Pos = scan.nextInt();
            while (player1Positions.contains(player1Pos) || player2Positions.contains(player1Pos)) {
                System.out.println("Positions is taken! Select correct position");
                player1Pos = scan.nextInt();
            } // dodać Player1Positions i Player2Polition do GameBoard

            System.out.println(player1Pos);

            board.fieldPiece(board.getGameBoard(), player1Pos, "player1");

            board.printGameBoard(board.getGameBoard());

            String result = winConditions.checkWinner(player1Positions, player2Positions);
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            System.out.println("Please Player2 select your field by keyboard (1-9) ");
            int player2Pos = scan.nextInt();
            while (player2Positions.contains(player2Pos) || player1Positions.contains(player2Pos)) {
                System.out.println("Positions is taken! Select correct position");
                player2Pos = scan.nextInt();
            }
            System.out.println(player2Pos);


            board.fieldPiece(board.getGameBoard(), player2Pos, "player2");

            board.printGameBoard(board.getGameBoard());
            result = winConditions.checkWinner(player1Positions, player2Positions);
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        }
    }
}