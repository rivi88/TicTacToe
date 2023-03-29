package com.rmac.tictactoe;

import com.rmac.AppTicTacTou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinConditions {

    static List<List<Integer>> winningConditions = new ArrayList<>();

    static {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> middleRow = Arrays.asList(4, 5, 6);
        List<Integer> dowRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> middleCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);

        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(dowRow);
        winningConditions.add(leftCol);
        winningConditions.add(middleCol);
        winningConditions.add(rightCol);
        winningConditions.add(cross1);
        winningConditions.add(cross2);
    }

    public String checkWinner(ArrayList<Integer> player1Positions, ArrayList<Integer> player2Positions) {

        for (List<Integer> l : winningConditions) {
            if (player1Positions.containsAll(l)) {
                return "Congratulations Player1 You won!";
            } else if (player2Positions.containsAll(l)) {
                return "Congratulations Player2 You won!";
            } else if (player2Positions.size() + player1Positions.size() == 9) {
                return "It's a tie!";
            }
        }
        return "";//return class Result
    }
}

class Result {
    private final String message;
    private final String status;//"winner", "tie", "no winner";

    public Result(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
