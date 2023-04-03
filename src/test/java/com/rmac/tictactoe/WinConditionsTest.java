package com.rmac.tictactoe;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class WinConditionsTest {
    private WinConditions winConditions;
    private GameBoard gameBoard;
    private PlayerInterface player1;
    private PlayerInterface player2;

    @BeforeEach
    void setUp() {
        winConditions = new WinConditions();
        gameBoard = new GameBoard();
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
    }

    @Test
    void testFirstRowWinPlayer1Win() {
        gameBoard.fieldPiece(1, 'X');
        gameBoard.fieldPiece(2, 'X');
        gameBoard.fieldPiece(3, 'X');
        gameBoard.fieldPiece(4, 'X');
        gameBoard.fieldPiece(5, 'O');
        gameBoard.fieldPiece(6, 'O');
        gameBoard.fieldPiece(7, 'O');
        gameBoard.fieldPiece(8, 'O');

        String result = winConditions.checkWinner(gameBoard, player1);

        Assertions.assertEquals("Congratulations Player 1 You won!", result);
    }

    @Test
    void testSecondRowWinPlayer2Win() {
        gameBoard.fieldPiece(1, 'X');
        gameBoard.fieldPiece(2, 'O');
        gameBoard.fieldPiece(3, 'X');
        gameBoard.fieldPiece(4, 'O');
        gameBoard.fieldPiece(5, 'O');
        gameBoard.fieldPiece(6, 'O');
        gameBoard.fieldPiece(7, 'X');

        String result = winConditions.checkWinner(gameBoard, player2);

        Assertions.assertEquals("Congratulations Player 2 You won!", result);
    }
    @Test
    void testThirdRowWinPlayer1Win() {
        gameBoard.fieldPiece(1, 'X');
        gameBoard.fieldPiece(2, 'X');
        gameBoard.fieldPiece(3, 'X');
        gameBoard.fieldPiece(4, 'X');
        gameBoard.fieldPiece(5, 'O');
        gameBoard.fieldPiece(6, 'O');
        gameBoard.fieldPiece(7, 'O');
        gameBoard.fieldPiece(8, 'O');

        String result = winConditions.checkWinner(gameBoard, player1);

        Assertions.assertEquals("Congratulations Player 1 You won!", result);
    }
    @Test
    void testLeftColCheckWinnerPlayer2Wins() {
        gameBoard.fieldPiece(1, 'O');
        gameBoard.fieldPiece(2, 'O');
        gameBoard.fieldPiece(3, 'X');
        gameBoard.fieldPiece(4, 'O');
        gameBoard.fieldPiece(5, 'X');
        gameBoard.fieldPiece(6, 'X');
        gameBoard.fieldPiece(7, 'O');

        String result = winConditions.checkWinner(gameBoard, player2);

        Assertions.assertEquals("Congratulations Player 2 You won!", result);
    }
    @Test
    void testMiddleColRowWinPlayer1Win() {
        gameBoard.fieldPiece(1, 'O');
        gameBoard.fieldPiece(2, 'X');
        gameBoard.fieldPiece(3, 'X');
        gameBoard.fieldPiece(4, 'X');
        gameBoard.fieldPiece(5, 'X');
        gameBoard.fieldPiece(6, 'O');
        gameBoard.fieldPiece(7, 'O');
        gameBoard.fieldPiece(8, 'X');

        String result = winConditions.checkWinner(gameBoard, player1);

        Assertions.assertEquals("Congratulations Player 1 You won!", result);
    }

    @Test
    void testRightColCheckWinnerPlayer2Wins() {
        gameBoard.fieldPiece(1, 'X');
        gameBoard.fieldPiece(2, 'O');
        gameBoard.fieldPiece(3, 'O');
        gameBoard.fieldPiece(4, 'X');
        gameBoard.fieldPiece(5, 'X');
        gameBoard.fieldPiece(6, 'O');
        gameBoard.fieldPiece(9, 'O');

        String result = winConditions.checkWinner(gameBoard, player2);

        Assertions.assertEquals("Congratulations Player 2 You won!", result);
    }
    @Test
    void testCross1CheckWinnerPlayer1Wins() {
        gameBoard.fieldPiece(1, 'X');
        gameBoard.fieldPiece(2, 'O');
        gameBoard.fieldPiece(3, 'O');
        gameBoard.fieldPiece(4, 'X');
        gameBoard.fieldPiece(5, 'X');
        gameBoard.fieldPiece(6, 'O');
        gameBoard.fieldPiece(9, 'X');

        String result = winConditions.checkWinner(gameBoard, player1);

        Assertions.assertEquals("Congratulations Player 1 You won!", result);
    } @Test
    void testCross2CheckWinnerPlayer2Wins() {
        gameBoard.fieldPiece(1, 'X');
        gameBoard.fieldPiece(2, 'O');
        gameBoard.fieldPiece(3, 'O');
        gameBoard.fieldPiece(4, 'X');
        gameBoard.fieldPiece(5, 'O');
        gameBoard.fieldPiece(6, 'X');
        gameBoard.fieldPiece(7, 'O');

        String result = winConditions.checkWinner(gameBoard, player2);

        Assertions.assertEquals("Congratulations Player 2 You won!", result);
    }
    @Test
    void testCheckWinnerTie() {
        gameBoard.fieldPiece(1, 'X');
        gameBoard.fieldPiece(2, 'O');
        gameBoard.fieldPiece(3, 'X');
        gameBoard.fieldPiece(4, 'O');
        gameBoard.fieldPiece(5, 'X');
        gameBoard.fieldPiece(6, 'O');
        gameBoard.fieldPiece(7, 'O');
        gameBoard.fieldPiece(8, 'X');
        gameBoard.fieldPiece(9, 'O');

        String result = winConditions.checkWinner(gameBoard, player1);

        Assertions.assertEquals("It's a tie!", result);
    }
}