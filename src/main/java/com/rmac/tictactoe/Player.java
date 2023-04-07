package com.rmac.tictactoe;

import com.rmac.AppTicTacTou;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player implements PlayerInterface {
    Scanner scanner = new Scanner(System.in);
    private final String name;
    private final char sign;


    public Player(String name, char sign) {
        this.name = name;
        this.sign = sign;
    }

    public Move move(int boardSize) {
        String message = null;
        if (AppTicTacTou.typeOfBoard == 3) {
            message = "0 or 1 or 2.";
        } else {
            message = "0, 1, 2, 3, 4, 5, 6, 7, 8 or 9.";
        }

        System.out.println(name + " select your ROW by keyboard " + message);
        int row;
        int col;
        try {
            row = scanner.nextInt();
            while (!isValidMove(row, boardSize)) {
                System.out.println("Positions is out of range! \nSelect correct position:");
                row = scanner.nextInt();
            }
            System.out.println(name + " select your COLUMN by keyboard " + message);
            col = scanner.nextInt();
            while (!isValidMove(col, boardSize)) {
                System.out.println("Positions is out of range! \nSelect correct position:");
                col = scanner.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong Move! Please enter a valid number");
            scanner.next();
            return move(boardSize);
        }
        return new Move(row, col);
    }

    private boolean isValidMove(int pos, int boardSize) {
        if(boardSize == 3) {
            return pos >= 0 && pos < 10;
        } else {
            return pos >= 0 && pos < 100;
        }
    }

    public char getSign() {
        return this.sign;
    }

    public String getName() {
        return this.name;
    }
}
