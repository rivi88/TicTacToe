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
    public int move(int boardSize) {
        System.out.println(this.getName() + " select your field by keyboard (1-9) ");
        return random.nextInt(boardSize * boardSize);

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
