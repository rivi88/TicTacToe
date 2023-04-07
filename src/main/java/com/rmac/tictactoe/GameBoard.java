package com.rmac.tictactoe;

public class GameBoard {

    public static final char TIE = '-';
    public static final char CONTINUE = 'c';
    private final int size;
    char[][] gameBoard;
    private int moves = 0;

    public GameBoard(int size) {
        this.size = size;
        gameBoard2 = new char[size * size];
        init2();
    }

    private void init2() {
        gameBoard2 = new char[size * size];
        for (int i = 0; i < size * size; i++) {
            gameBoard2[i] = ' ';
        }
    }

    public String printGameBoard() {
        var builder = new StringBuilder(" ");
        for (int i = 0; i < size; i++) {
            builder.append(" ").append(i);
        }
        builder.append("\n");
        for (int i = 0; i < size; i++) {
            builder.append(i);
            for (int j = 0; j < size; j++) {
                builder.append("|").append(gameBoard[i][j]);
            }
            builder.append("|").append("\n");
        }
        return builder.toString();
    }

    public int getSize() {
        return size;
    }

    public void fieldPiece(Move move, char symbol) {
        moves++;
        if (symbol == 'X') {
            symbolsX.add(pos);
        } else if (symbol == 'O') {
            symbolsO.add(pos);
        }

    }

    public boolean isOccupied(int move) {
        boolean occupied = symbolsX.contains(move) || symbolsO.contains(move);
        if (occupied) {
            System.out.println("Positions is taken! Select correct position");
        }
        return occupied;
    }

    public char checkWinner3(char[][] board, char symbol) {
        int winLength = 3;
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }

        // check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return board[0][j];
            }
        }

        // check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }
        return isATie();
    }

    private static boolean checkDiagonals(char[][] board, char symbol, int winLength) {
        for (int i = 0; i < winLength; i++) {
            if (symbol != board[i][i]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(char[][] board, char symbol, int col, int winLength) {
        for (int row = 0; row < winLength; row++) {
            if (symbol != board[row][col]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(char symbol, char[] boardRow, int winLength) {
        for (int col = 0; col < winLength; col++) {
            if (symbol != boardRow[col]) {
                return false;
            }
        }
        return true;
    }

    private char isATie() {

        if (moves == size * size) {
            return TIE;
        }
        // no winner
        return CONTINUE;
    }

    public char checkWinner10(char[][] board, char symbol) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                if (checkRow10(j, board[i])) {
                    return symbol;
                }
            }
        }
        // check columns
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] != ' ' && board[i][j] == board[i + 1][j] &&
                        board[i + 1][j] == board[i + 2][j] && board[i + 2][j] == board[i + 3][j] &&
                        board[i + 3][j] == board[i + 4][j]) {
                    return symbol;
                }
            }
        }

        // check diagonals (top-left to bottom-right)
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != ' ' && board[i][j] == board[i + 1][j + 1] &&
                        board[i + 1][j + 1] == board[i + 2][j + 2] && board[i + 2][j + 2] == board[i + 3][j + 3] &&
                        board[i + 3][j + 3] == board[i + 4][j + 4]) {
                    return symbol;
                }
            }
        }
        return '-';
    }
}


package com.rmac.tictactoe;

public class GameBoard {

    public static final char TIE = '-';
    public static final char CONTINUE = 'c';
    private final int size;
    char[][] gameBoard;
    private int moves = 0;

    public GameBoard(int size) {
        this.size = size;
//        gameBoard2 = new char[size * size];
        init();
    }

    private void init() {
        gameBoard = new char[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                gameBoard[row][col] = ' ';
            }
        }
    }

    public String printGameBoard() {
        var builder = new StringBuilder(" ");
        for (int i = 0; i < size; i++) {
            builder.append(" ").append(i);
        }
        builder.append("\n");
        for (int i = 0; i < size; i++) {
            builder.append(i);
            for (int j = 0; j < size; j++) {
                builder.append("|").append(gameBoard[i][j]);
            }
            builder.append("|").append("\n");
        }
        return builder.toString();
    }

    public int getSize() {
        return size;
    }

    public void fieldPiece(Move move, char symbol) {
        moves++;
        if (symbol == 'X') {
            gameBoard[move.row][move.col] = symbol;
        } else if (symbol == 'O') {
            gameBoard[move.row][move.col] = symbol;

        }

    }

    public boolean isOccupied(Move move) {
        boolean occupied = !(gameBoard[move.row][move.col] == ' ');
        if (occupied) {
            System.out.println("Positions is taken! Select correct position");
        }
        return occupied;
    }

    public char checkWinner3(char[][] board, char symbol) {
        int winLength = 3;
        // check rows
        for (int row = 0; row < 3; row++) {
            if (checkRow(symbol, board[row], winLength)) {
                return symbol;
            }
        }

        // check columns
        for (int col = 0; col < 3; col++) {
            if (checkCol(board, symbol, col, winLength)) {
                return symbol;
            }
        }

        // check diagonals
        for (int i = 0; i < 3; i++) {
            if (checkDiagonals(board, symbol, winLength)) {
                return symbol;
            }
        }

        if (symbol == board[0][2] && symbol == board[1][1] && symbol == board[2][0]) {
            return symbol;
        }
        return isATie();
    }

    private static boolean checkDiagonals(char[][] board, char symbol, int winLength) {
        for (int i = 0; i < winLength; i++) {
            if (symbol != board[i][i]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(char[][] board, char symbol, int col, int winLength) {
        for (int row = 0; row < winLength; row++) {
            if (symbol != board[row][col]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(char symbol, char[] boardRow, int winLength) {
        for (int col = 0; col < winLength; col++) {
            if (symbol != boardRow[col]) {
                return false;
            }
        }
        return true;
    }

    private char isATie() {

        if (moves == size * size) {
            return TIE;
        }
        // no winner
        return CONTINUE;
    }

    public char checkWinner10(char[][] board, char symbol) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                if (checkRow10(j, board[i])) {
                    return symbol;
                }
            }
        }
        // check columns
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] != ' ' && board[i][j] == board[i + 1][j] &&
                        board[i + 1][j] == board[i + 2][j] && board[i + 2][j] == board[i + 3][j] &&
                        board[i + 3][j] == board[i + 4][j]) {
                    return symbol;
                }
            }
        }

        // check diagonals (top-left to bottom-right)
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != ' ' && board[i][j] == board[i + 1][j + 1] &&
                        board[i + 1][j + 1] == board[i + 2][j + 2] && board[i + 2][j + 2] == board[i + 3][j + 3] &&
                        board[i + 3][j + 3] == board[i + 4][j + 4]) {
                    return symbol;
                }
            }
        }
        //check diagonals 2
        for (int i = 4; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != ' ' && board[i][j] == board[i - 1][j + 1] && board[i - 1][j + 1] == board[i - 2][j + 2]
                        && board[i - 2][j + 2] == board[i - 3][j + 3] && board[i - 3][j + 3] == board[i - 4][j + 4]) {
                    return symbol;
                }
            }
        }
        return isATie();
    }

    private static boolean checkRow10(int j, char[] board) {
        return board[j] != ' ' && board[j] == board[j + 1] &&
                board[j + 1] == board[j + 2] && board[j + 2] == board[j + 3] &&
                board[j + 3] == board[j + 4];
    }

    public static void main(String[] args) {

    }

    public char checkWinner(char symbol) {
        if (size == 3) {
            return checkWinner3(gameBoard, symbol);
        } else if (size == 10) {
            return checkWinner10(gameBoard, symbol);
        }
        throw new IllegalStateException("Illegal board size " + size);
    }
}


