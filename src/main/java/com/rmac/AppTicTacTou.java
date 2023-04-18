
package com.rmac;

import com.rmac.tictactoe.*;

import java.util.Scanner;


public class AppTicTacTou {
    WinnerSaver ws = new WinnerSaver();
    GameBoard board;
    private static int typeOfBoard = 0;

    public static void main(String[] args) {
        AppTicTacTou appTicTacTou = new AppTicTacTou();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome in Game TicTacTou! \nPlease choose size of board 3x3 or 10x10");
        System.out.println("For 3x3 please choose number 3. \nFor 10x10 please choose number 10");

        while (true) {
            try {
                typeOfBoard = Integer.parseInt(scanner.nextLine());
                if (typeOfBoard == 3 || typeOfBoard == 10) {
                    break;
                } else {
                    System.out.println("Please try again and choose board size, 3 or 10:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please try again and choose board size, 3 or 10:");
            }
        }
        System.out.println("Welcome in Game TicTacTou! \nPlease choose how many person will be play (1 lub 2)");

        int numberOfPlayers = 0;
        while (true) {
            try {
                numberOfPlayers = Integer.parseInt(scanner.nextLine());
                if (numberOfPlayers == 1 || numberOfPlayers == 2) {
                    break;
                } else {
                    System.out.println("Please try again and choose number of players 1 or 2:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please try again and choose number of players 1 or 2:");
            }
        }

        appTicTacTou.board = new GameBoard(typeOfBoard);
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
        appTicTacTou.runGame(player1, player2);
    }

    private void runGame(PlayerInterface player1, PlayerInterface player2) {
        System.out.println(board.printGameBoard());
        while (true) {
            //player 1
            playerMoves(board, player1);
            System.out.println(board.printGameBoard());
            if (checkGameEnd(board.checkWinner(player1.getSign()), player1)) {
                ws.savesScore(player1);
                break;
            }


            //player2
            playerMoves(board, player2);
            System.out.println(board.printGameBoard());
            if (checkGameEnd(board.checkWinner(player2.getSign()), player2)) {
                ws.savesScore(player2);
                break;
            }
        }
    }

    private static boolean checkGameEnd(char result, PlayerInterface player) {
        if (result == GameBoard.CONTINUE) {
            return false;
        }
        if (GameBoard.TIE == result) {
            System.out.println("It is a TIE");
        } else {
            System.out.println(player.getName() + " you WON!!!");
        }
        return true;
    }


    private void playerMoves(GameBoard board, PlayerInterface player) {
        boolean occupied = true;


        Move move = null;
        while (occupied) {

            move = player.move(board.getSize());
            occupied = board.isOccupied(move);
        }
        board.fieldPiece(move, player.getSign());
    }
}
