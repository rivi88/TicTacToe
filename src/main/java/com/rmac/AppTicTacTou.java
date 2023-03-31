package com.rmac;

import com.rmac.tictactoe.*;

import java.util.Scanner;


public class AppTicTacTou {
    WinConditions winConditions = new WinConditions();
    GameBoard board = new GameBoard();


    public static void main(String[] args) {
        AppTicTacTou appTicTacTou = new AppTicTacTou();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome in Game TicTacTou! \n Please choose how many person will be play (1 lub 2)");
        int numberOfPlayers = scanner.nextInt();
        while (numberOfPlayers != 1 && numberOfPlayers != 2) {
            System.out.println("Please try again choose number of players:");
            numberOfPlayers = scanner.nextInt();
        }
        System.out.println("Please write Your Name:");
        String playerName = scanner.next();
        PlayerInterface player1 = new Player(playerName, 'X');
        PlayerInterface player2 = null;
        if (numberOfPlayers == 2) {
            System.out.println("Please write Your Name:");
            String playerName2 = scanner.next();
            player2 = new Player(playerName2, 'O');
        } else {
            player2 = new PlayerCPU("CPU", 'O');
        }
        appTicTacTou.codeGamePlayFor2Players(player1, player2);
    }

    private void codeGamePlayFor2Players(PlayerInterface player1, PlayerInterface player2) {
        board.printGameBoard();
        while (true) {
            playerMoves(board, player1);
            board.printGameBoard();

            if (checkWinner(board, player1)) break;
            playerMoves(board, player2);
//            board.playerMoves(player2);
            board.printGameBoard();

            if (checkWinner(board,  player2)) break;
//            if (winConditions.checkWinner(board, player)) break;

        }
    }

    private boolean checkWinner(GameBoard board, PlayerInterface player) {
        String result = winConditions.checkWinner(board, player);
        if (!result.equals("Game Runs")) {
            System.out.println(result);
            return true;
        }
        return false;
    }

    private void playerMoves(GameBoard board, PlayerInterface player) {
        boolean occupied = true;

        int move = 0;
        while (occupied) {
            move = player.move();
            occupied = board.isOccupied(move);
        }
        System.out.println(move);
        board.fieldPiece(move, player.getSign());
    }
}
