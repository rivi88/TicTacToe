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

}