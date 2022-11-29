package com.mycompany.app;

public class ThreeInARow {
    private Character[][] board = { { '0', '0', '0' }, { '0', '0', '0' }, { '0', '0', '0' } };

    private char lastPlay = '+';
    private final int SIZE = 3;

    public String play(int x, int y) throws Exception {
        verifyAxis(x);
        verifyAxis(y);

        lastPlay = nextPlay();
        assignPosition(x, y, lastPlay);

        if (thereIsWinner()) {
            return "The winner is " + lastPlay;
        }

        return "There is no winner";
    }

    private void verifyAxis(int axis) throws Exception {
        if (axis < 1 || axis > 3) {
            throw new Exception("The coordinate" + axis + "is out of the bounds of the board");
        }
    }

    private void assignPosition(int x, int y, char lastPlay) throws Exception {
        if (board[x - 1][y - 1] != '0') {
            System.out.println("Asigning position:" + x + ", " + y);
            throw new Exception("The position has a player");
        } else {
            board[x - 1][y - 1] = lastPlay;
        }
    }

    public char nextPlay() {
        if (lastPlay == 'X') {
            return '+';
        }
        return 'X';
    }

    private boolean thereIsWinner() {
        int sizeComplete = lastPlay * SIZE;
        for (int index = 0; index < SIZE; index++) {
            if (board[0][index] + board[1][index] + board[2][index] == sizeComplete) {
                return true;
            }
            if (board[index][0] + board[index][1] + board[index][2] == sizeComplete) {
                return true;
            }
        }
        return false;
    }
}
