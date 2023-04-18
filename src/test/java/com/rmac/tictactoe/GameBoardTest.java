package com.rmac.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    @Test
    void printGameBoard() {
    }

    @Test
    public void testCheckWinner3WhenTie() {
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.fieldPiece(new Move(0, 0), 'X');
        gameBoard.fieldPiece(new Move(0, 1), 'O');
        gameBoard.fieldPiece(new Move(0, 2), 'X');
        gameBoard.fieldPiece(new Move(1, 0), 'O');
        gameBoard.fieldPiece(new Move(1, 1), 'X');
        gameBoard.fieldPiece(new Move(1, 2), 'O');
        gameBoard.fieldPiece(new Move(2, 0), 'O');
        gameBoard.fieldPiece(new Move(2, 1), 'X');
        gameBoard.fieldPiece(new Move(2, 2), 'O');

        char actual = gameBoard.checkWinner3(gameBoard.gameBoard, 'X');

        assertEquals(GameBoard.TIE, actual);
    }

    @Test
    public void testCheckWinner3WhenXWins() {
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.fieldPiece(new Move(0, 0), 'X');
        gameBoard.fieldPiece(new Move(0, 1), 'O');
        gameBoard.fieldPiece(new Move(0, 2), 'X');
        gameBoard.fieldPiece(new Move(1, 0), 'O');
        gameBoard.fieldPiece(new Move(1, 1), 'X');
        gameBoard.fieldPiece(new Move(1, 2), 'O');
        gameBoard.fieldPiece(new Move(2, 0), 'X');
        assertEquals('X', gameBoard.checkWinner3(gameBoard.gameBoard, 'X'));
    }
    @Test
    public void testCheckWinner3WhenXWinsDiagonals() {
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.fieldPiece(new Move(0, 0), 'X');
        gameBoard.fieldPiece(new Move(0, 1), 'O');
        gameBoard.fieldPiece(new Move(0, 2), 'O');
        gameBoard.fieldPiece(new Move(1, 1), 'X');
        gameBoard.fieldPiece(new Move(1, 2), 'O');
        gameBoard.fieldPiece(new Move(2, 2), 'X');
        assertEquals('X', gameBoard.checkWinner3(gameBoard.gameBoard, 'X'));
    }

    @Test
    public void testCheckWinner3WhenOWins() {
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.fieldPiece(new Move(0, 0), 'O');
        gameBoard.fieldPiece(new Move(0, 1), 'X');
        gameBoard.fieldPiece(new Move(0, 2), 'O');
        gameBoard.fieldPiece(new Move(1, 0), 'X');
        gameBoard.fieldPiece(new Move(1, 1), 'O');
        gameBoard.fieldPiece(new Move(1, 2), 'X');
        gameBoard.fieldPiece(new Move(2, 2), 'O');
        assertEquals('O', gameBoard.checkWinner3(gameBoard.gameBoard, 'O'));
    }



    @Test
    void checkWinner10Row() {
        GameBoard gameBoard = new GameBoard(10);
        gameBoard.fieldPiece(new Move(7, 2), 'O');
        gameBoard.fieldPiece(new Move(7, 3), 'O');
        gameBoard.fieldPiece(new Move(7, 4), 'O');
        gameBoard.fieldPiece(new Move(7, 5), 'O');
        gameBoard.fieldPiece(new Move(7, 6), 'O');
        gameBoard.fieldPiece(new Move(7, 7), 'O');
        gameBoard.fieldPiece(new Move(1, 0), 'X');
        gameBoard.fieldPiece(new Move(1, 1), 'O');
        gameBoard.fieldPiece(new Move(1, 2), 'X');
        gameBoard.fieldPiece(new Move(2, 2), 'O');
        assertEquals('O', gameBoard.checkWinner10(gameBoard.gameBoard, 'O'));
    }
    @Test
    void checkWinner10Column() {
        GameBoard gameBoard = new GameBoard(10);
        gameBoard.fieldPiece(new Move(0, 0), 'O');
        gameBoard.fieldPiece(new Move(0, 1), 'X');
        gameBoard.fieldPiece(new Move(0, 2), 'X');
        gameBoard.fieldPiece(new Move(0, 3), 'X');
        gameBoard.fieldPiece(new Move(0, 4), 'O');
        gameBoard.fieldPiece(new Move(0, 7), 'O');
        gameBoard.fieldPiece(new Move(1, 0), 'O');
        gameBoard.fieldPiece(new Move(2, 0), 'O');
        gameBoard.fieldPiece(new Move(3, 0), 'O');
        gameBoard.fieldPiece(new Move(4, 0), 'O');
        gameBoard.fieldPiece(new Move(1, 1), 'O');
        gameBoard.fieldPiece(new Move(1, 2), 'X');
        gameBoard.fieldPiece(new Move(2, 2), 'O');
        assertEquals('O', gameBoard.checkWinner10(gameBoard.gameBoard, 'O'));
    }
    @Test
    void checkWinner10Diagonals() {
        GameBoard gameBoard = new GameBoard(10);
        gameBoard.fieldPiece(new Move(1, 0), 'X');
        gameBoard.fieldPiece(new Move(2, 1), 'X');
        gameBoard.fieldPiece(new Move(3, 2), 'X');
        gameBoard.fieldPiece(new Move(4, 3), 'X');
        gameBoard.fieldPiece(new Move(5, 4), 'X');
        gameBoard.fieldPiece(new Move(0, 7), 'O');
        gameBoard.fieldPiece(new Move(8, 0), 'O');
        gameBoard.fieldPiece(new Move(2, 0), 'X');
        gameBoard.fieldPiece(new Move(3, 0), 'O');
        gameBoard.fieldPiece(new Move(4, 0), 'O');
        gameBoard.fieldPiece(new Move(7, 0), 'O');
        gameBoard.fieldPiece(new Move(1, 2), 'X');
        System.out.println(gameBoard.printGameBoard());
        assertEquals('X', gameBoard.checkWinner10(gameBoard.gameBoard, 'X'));
    }
    @Test
    void checkWinner10Diagonals2() {
        GameBoard gameBoard = new GameBoard(10);
        gameBoard.fieldPiece(new Move(3, 7), 'X');
        gameBoard.fieldPiece(new Move(4, 6), 'X');
        gameBoard.fieldPiece(new Move(5, 5), 'X');
        gameBoard.fieldPiece(new Move(6, 4), 'X');
        gameBoard.fieldPiece(new Move(7, 3), 'X');
        gameBoard.fieldPiece(new Move(0, 7), 'O');
        gameBoard.fieldPiece(new Move(1, 0), 'O');
        gameBoard.fieldPiece(new Move(2, 0), 'O');
        gameBoard.fieldPiece(new Move(3, 0), 'O');
        gameBoard.fieldPiece(new Move(4, 0), 'O');
        gameBoard.fieldPiece(new Move(1, 1), 'O');
        gameBoard.fieldPiece(new Move(1, 2), 'X');
        gameBoard.fieldPiece(new Move(2, 2), 'O');
        char actual = gameBoard.checkWinner3(gameBoard.gameBoard, 'X');
        System.out.println(gameBoard.printGameBoard());
        assertEquals('O', gameBoard.checkWinner10(gameBoard.gameBoard, 'O'));
    }
    @Test
    void checkWinner10Diagonals3() {
        GameBoard gameBoard = new GameBoard(10);
        gameBoard.fieldPiece(new Move(0, 0), 'O');
        gameBoard.fieldPiece(new Move(0, 1), 'X');
        gameBoard.fieldPiece(new Move(0, 2), 'X');
        gameBoard.fieldPiece(new Move(0, 3), 'X');
        gameBoard.fieldPiece(new Move(0, 4), 'O');
        gameBoard.fieldPiece(new Move(0, 7), 'O');
        gameBoard.fieldPiece(new Move(1, 0), 'O');
        gameBoard.fieldPiece(new Move(2, 0), 'O');
        gameBoard.fieldPiece(new Move(3, 0), 'O');
        gameBoard.fieldPiece(new Move(4, 0), 'O');
        gameBoard.fieldPiece(new Move(1, 1), 'O');
        gameBoard.fieldPiece(new Move(1, 2), 'X');
        gameBoard.fieldPiece(new Move(2, 2), 'O');
        assertEquals('O', gameBoard.checkWinner10(gameBoard.gameBoard, 'O'));
    }
    @Test
    void checkWinner10Tie() {
        GameBoard gameBoard = new GameBoard(10);
        gameBoard.fieldPiece(new Move(0, 0), 'O');
        gameBoard.fieldPiece(new Move(0, 1), 'X');
        gameBoard.fieldPiece(new Move(0, 2), 'X');
        gameBoard.fieldPiece(new Move(0, 3), 'X');
        gameBoard.fieldPiece(new Move(0, 4), 'O');
        gameBoard.fieldPiece(new Move(0, 5), 'O');
        gameBoard.fieldPiece(new Move(0, 6), 'X');
        gameBoard.fieldPiece(new Move(0, 7), 'X');
        gameBoard.fieldPiece(new Move(0, 8), 'O');
        gameBoard.fieldPiece(new Move(0, 9), 'O');
        gameBoard.fieldPiece(new Move(1, 0), 'O');
        gameBoard.fieldPiece(new Move(1, 1), 'O');
        gameBoard.fieldPiece(new Move(1, 2), 'X');
        gameBoard.fieldPiece(new Move(1, 3), 'X');
        gameBoard.fieldPiece(new Move(1, 4), 'O');
        gameBoard.fieldPiece(new Move(1, 5), 'O');
        gameBoard.fieldPiece(new Move(1, 6), 'X');
        gameBoard.fieldPiece(new Move(1, 7), 'X');
        gameBoard.fieldPiece(new Move(1, 8), 'O');
        gameBoard.fieldPiece(new Move(1, 9), 'O');
        gameBoard.fieldPiece(new Move(2, 0), 'X');
        gameBoard.fieldPiece(new Move(2, 1), 'X');
        gameBoard.fieldPiece(new Move(2, 2), 'O');
        gameBoard.fieldPiece(new Move(2, 3), 'O');
        gameBoard.fieldPiece(new Move(2, 4), 'X');
        gameBoard.fieldPiece(new Move(2, 5), 'X');
        gameBoard.fieldPiece(new Move(2, 6), 'O');
        gameBoard.fieldPiece(new Move(2, 7), 'O');
        gameBoard.fieldPiece(new Move(2, 8), 'X');
        gameBoard.fieldPiece(new Move(2, 9), 'X');
        gameBoard.fieldPiece(new Move(3, 0), 'O');
        gameBoard.fieldPiece(new Move(3, 1), 'O');
        gameBoard.fieldPiece(new Move(3, 2), 'X');
        gameBoard.fieldPiece(new Move(3, 3), 'X');
        gameBoard.fieldPiece(new Move(3, 4), 'O');
        gameBoard.fieldPiece(new Move(3, 5), 'O');
        gameBoard.fieldPiece(new Move(3, 6), 'X');
        gameBoard.fieldPiece(new Move(3, 7), 'X');
        gameBoard.fieldPiece(new Move(3, 8), 'O');
        gameBoard.fieldPiece(new Move(3, 9), 'O');
        gameBoard.fieldPiece(new Move(4, 0), 'O');
        gameBoard.fieldPiece(new Move(4, 1), 'O');
        gameBoard.fieldPiece(new Move(4, 2), 'X');
        gameBoard.fieldPiece(new Move(4, 3), 'X');
        gameBoard.fieldPiece(new Move(4, 4), 'O');
        gameBoard.fieldPiece(new Move(4, 5), 'O');
        gameBoard.fieldPiece(new Move(4, 6), 'X');
        gameBoard.fieldPiece(new Move(4, 7), 'X');
        gameBoard.fieldPiece(new Move(4, 8), 'O');
        gameBoard.fieldPiece(new Move(4, 9), 'O');
        gameBoard.fieldPiece(new Move(5, 0), 'X');
        gameBoard.fieldPiece(new Move(5, 1), 'X');
        gameBoard.fieldPiece(new Move(5, 2), 'O');
        gameBoard.fieldPiece(new Move(5, 3), 'O');
        gameBoard.fieldPiece(new Move(5, 4), 'X');
        gameBoard.fieldPiece(new Move(5, 5), 'X');
        gameBoard.fieldPiece(new Move(5, 6), 'O');
        gameBoard.fieldPiece(new Move(5, 7), 'O');
        gameBoard.fieldPiece(new Move(5, 8), 'X');
        gameBoard.fieldPiece(new Move(5, 9), 'X');
        gameBoard.fieldPiece(new Move(6, 0), 'O');
        gameBoard.fieldPiece(new Move(6, 1), 'O');
        gameBoard.fieldPiece(new Move(6, 2), 'X');
        gameBoard.fieldPiece(new Move(6, 3), 'X');
        gameBoard.fieldPiece(new Move(6, 4), 'O');
        gameBoard.fieldPiece(new Move(6, 5), 'O');
        gameBoard.fieldPiece(new Move(6, 6), 'X');
        gameBoard.fieldPiece(new Move(6, 7), 'X');
        gameBoard.fieldPiece(new Move(6, 8), 'O');
        gameBoard.fieldPiece(new Move(6, 9), 'O');
        gameBoard.fieldPiece(new Move(7, 0), 'O');
        gameBoard.fieldPiece(new Move(7, 1), 'O');
        gameBoard.fieldPiece(new Move(7, 2), 'X');
        gameBoard.fieldPiece(new Move(7, 3), 'X');
        gameBoard.fieldPiece(new Move(7, 4), 'O');
        gameBoard.fieldPiece(new Move(7, 5), 'O');
        gameBoard.fieldPiece(new Move(7, 6), 'X');
        gameBoard.fieldPiece(new Move(7, 7), 'X');
        gameBoard.fieldPiece(new Move(7, 8), 'O');
        gameBoard.fieldPiece(new Move(7, 9), 'O');
        gameBoard.fieldPiece(new Move(8, 0), 'X');
        gameBoard.fieldPiece(new Move(8, 1), 'X');
        gameBoard.fieldPiece(new Move(8, 2), 'O');
        gameBoard.fieldPiece(new Move(8, 3), 'O');
        gameBoard.fieldPiece(new Move(8, 4), 'X');
        gameBoard.fieldPiece(new Move(8, 5), 'X');
        gameBoard.fieldPiece(new Move(8, 6), 'O');
        gameBoard.fieldPiece(new Move(8, 7), 'O');
        gameBoard.fieldPiece(new Move(8, 8), 'X');
        gameBoard.fieldPiece(new Move(8, 9), 'X');
        gameBoard.fieldPiece(new Move(9, 0), 'O');
        gameBoard.fieldPiece(new Move(9, 1), 'O');
        gameBoard.fieldPiece(new Move(9, 2), 'X');
        gameBoard.fieldPiece(new Move(9, 3), 'X');
        gameBoard.fieldPiece(new Move(9, 4), 'O');
        gameBoard.fieldPiece(new Move(9, 5), 'O');
        gameBoard.fieldPiece(new Move(9, 6), 'X');
        gameBoard.fieldPiece(new Move(9, 7), 'X');
        gameBoard.fieldPiece(new Move(9, 8), 'O');
        gameBoard.fieldPiece(new Move(9, 9), 'O');
        System.out.println(gameBoard.printGameBoard());
        assertEquals('-', gameBoard.checkWinner10(gameBoard.gameBoard, 'O'));
    }

}