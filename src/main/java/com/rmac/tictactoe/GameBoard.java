package com.rmac.tictactoe;

import com.rmac.AppTicTacTou;

public class GameBoard {


    char[][] gameBoard = {{'|', ' ', '|', ' ', '|', ' ', '|'},
            {'|', ' ', '|', ' ', '|', ' ', '|'},
            {'|', ' ', '|', ' ', '|', ' ', '|'}};
    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void fieldPiece(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';

        if (user.equals("player1")) {
            symbol = 'X';
            AppTicTacTou.player1Positions.add(pos);
        } else if (user.equals("player2")){
            symbol = 'O';
            AppTicTacTou.player2Positions.add(pos);
        }

        switch(pos) {
            case 1:
                gameBoard[0][1] = symbol;
                break;
            case 2:
                gameBoard[0][3] = symbol;
                break;
            case 3:
                gameBoard[0][5] = symbol;
                break;
            case 4:
                gameBoard[1][1] = symbol;
                break;
            case 5:
                gameBoard[1][3] = symbol;
                break;
            case 6:
                gameBoard[1][5] = symbol;
                break;
            case 7:
                gameBoard[2][1] = symbol;
                break;
            case 8:
                gameBoard[2][3] = symbol;
                break;
            case 9:
                gameBoard[2][5] = symbol;
                break;
            default:
                break;
        }
    }
    public char[][] getGameBoard() {
        return gameBoard;
    }
}
