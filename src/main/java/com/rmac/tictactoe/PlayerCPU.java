
package com.rmac.tictactoe;

import java.util.Random;

public class PlayerCPU implements PlayerInterface {
    private Random random = new Random();

    private final String name;
    private final char sign;

    public PlayerCPU(String name, char sign) {
        this.name = name;
        this.sign = sign;
    }

    @Override
    public Move move(int boardSize) {
        System.out.println(this.getName() + " has made it's move.");
        return new Move(random.nextInt(boardSize), random.nextInt(boardSize));

    }

    @Override
    public char getSign() {
        return sign;
    }

    @Override
    public String getName() {
        return name;
    }
}
