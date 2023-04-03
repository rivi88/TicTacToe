package com.rmac.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player implements PlayerInterface{
    Scanner scanner = new Scanner(System.in);
    private final String name;
    private final char sign;

    public Player(String name, char sign) {
        this.name = name;
        this.sign = sign;
    }


    public int move() {
        System.out.println(name + " select your field by keyboard (1-9) ");
        int pos;
        try {
            pos = scanner.nextInt();
            while (!isValidMove(pos)) {
                System.out.println("Positions is out of range! \nSelect correct position:");
                pos = scanner.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong Move! Please enter a valid number (1-9)");
            scanner.next();
            pos = move();
        }
        return pos;
    }


    private boolean isValidMove(int pos) {
        return pos > 0 && pos < 10;
    }

    public char getSign() {
        return this.sign;
    }

    public String getName() {
        return this.name;
    }
}
