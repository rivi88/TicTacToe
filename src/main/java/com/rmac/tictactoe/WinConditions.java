package com.rmac.tictactoe;



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

    public String checkWinner(GameBoard gameBoard, PlayerInterface player) {

        for (List<Integer> conditions : winningConditions) {
            if (gameBoard.getSymbolsX().containsAll(conditions) || gameBoard.getSymbolsO().containsAll(conditions)) {
                return "Congratulations " + player.getName() + " You won!";
            }
        }
        if (gameBoard.getSymbolsX().size() + gameBoard.getSymbolsO().size() == 9) {
            return "It's a tie!";
        }
        return "Game Runs";
    }
}
