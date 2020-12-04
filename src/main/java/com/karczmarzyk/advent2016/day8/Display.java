package com.karczmarzyk.advent2016.day8;

public class Display {
    private static final int SIZE = 50;
    private static final int COL = 6;
    char[][] display = new char[COL][SIZE];

    public Display() {
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < SIZE; j++) {
                display[i][j] = '.';
            }
        }
    }

    public void rotateRow(int row, int by)
    {
        char[] temp = new char[SIZE];
        System.arraycopy( display[row], 0, temp, 0, SIZE );
        for (int i = 0; i < SIZE; i++) {
            int moveBy = i+by;
            if(moveBy>SIZE-1)
                moveBy %=SIZE;
            display[row][moveBy] = temp[i];
        }
    }

    public void rotateColumn(int column, int by)
    {
        char[] temp = new char[COL];
        for (int i = 0; i < COL; i++) {
            temp[i] = display[i][column];
        }

        for (int i = 0; i < COL; i++) {
            int moveBy = i+by;
            if(moveBy>COL-1)
                moveBy %= COL;
            display[moveBy][column] = temp[i];
        }
    }

    public void rect(int x, int y)
    {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                display[i][j] = '#';
            }
        }
    }


    public void showDisplay()
    {
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(display[i][j]);
            }
            System.out.println();
        }
    }

    public int getNumberOfLights() {
        int result = 0;
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(display[i][j]=='#')
                    result++;
            }
        }
        return result;
    }
}
