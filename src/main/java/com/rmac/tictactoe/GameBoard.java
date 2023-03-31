package com.rmac.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    char[][] gameBoard = {{'|', ' ', '|', ' ', '|', ' ', '|'},
            {'|', ' ', '|', ' ', '|', ' ', '|'},
            {'|', ' ', '|', ' ', '|', ' ', '|'}};
    public void printGameBoard() { // przerobić żeby nie coś zwracało
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    private List<Integer> symbolsX = new ArrayList<>();
    private List<Integer> symbolsO = new ArrayList<>();
    public void fieldPiece(int pos, char symbol) {

        if (symbol == 'X') {
            symbolsX.add(pos);
        } else if (symbol == 'O') {
            symbolsO.add(pos);
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
    public List<Integer> getSymbolsX() {
        return symbolsX;
    }

    public List<Integer> getSymbolsO() {
        return symbolsO;
    }

    public boolean isOccupied(int move) {
        boolean occupied = symbolsX.contains(move) || symbolsO.contains(move);
        if (occupied) {
            System.out.println("Positions is taken! Select correct position");
        }
        return occupied;
    }
}
