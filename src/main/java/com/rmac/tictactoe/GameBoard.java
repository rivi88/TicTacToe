package com.rmac.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private final int size;
    private char[] gameBoard2;

    public GameBoard(int size) {
        this.size = size;
        gameBoard2 = new char[size * size];
        init2();
    }

    private void init2() {
        gameBoard2 = new char[size * size];
        for (int i = 0; i < size * size; i++) {
            gameBoard2[i] = ' ';
        }
    }

    public String printGameBoard() {
        var builder = new StringBuilder(" ");
        for (int i = 0; i < size; i++) {
            builder.append(" ").append(i);
        }
        builder.append("\n0");
        for (int i = 1; i <= size * size; i++) {
            builder.append("|").append(gameBoard2[i - 1]);
            if (i % size == 0) {
                builder.append("|").append("\n");
                if (i != size * size) {
                    builder.append(i / size);
                }
            }
        }
        return builder.toString();
    }

    public int getSize() {
        return size;
    }

    private List<Integer> symbolsX = new ArrayList<>();
    private List<Integer> symbolsO = new ArrayList<>();

    public void fieldPiece(int pos, char symbol) {

        if (symbol == 'X') {
            symbolsX.add(pos);
        } else if (symbol == 'O') {
            symbolsO.add(pos);
        }

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

    public char checkWinner3(char[][] board) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }

        // check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return board[0][j];
            }
        }

        // check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }

        // no winner
        return '-';
    }

    public static char checkWinner10(char[][] board) {
        // check rows
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != '-' && board[i][j] == board[i][j + 1] &&
                        board[i][j + 1] == board[i][j + 2] && board[i][j + 2] == board[i][j + 3] &&
                        board[i][j + 3] == board[i][j + 4]) {
                    return board[i][j];
                }
            }
        }

        // check columns
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] != '-' && board[i][j] == board[i + 1][j] &&
                        board[i + 1][j] == board[i + 2][j] && board[i + 2][j] == board[i + 3][j] &&
                        board[i + 3][j] == board[i + 4][j]) {
                    return board[i][j];
                }
            }
        }

        // check diagonals (top-left to bottom-right)
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != '-' && board[i][j] == board[i + 1][j + 1] &&
                        board[i + 1][j + 1] == board[i + 2][j + 2] && board[i + 2][j + 2] == board[i + 3][j + 3] &&
                        board[i + 3][j + 3] == board[i + 4][j + 4]) {
                    return board[i][j];
                }
            }
        }
        return '-';
    }
}


