package com.karczmarzyk.advent2020.day11;

public class SeatsAdv extends Seats{

    public SeatsAdv(int size) {
        super( size );
    }


    @Override
    public char[][] getNewGrid() {
        int size = super.getSIZE();
        char [][] temp = new char[super.getSIZE()][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(super.getGrid()[row][col] =='L' && this.getNumberOfOccupiedSeats( row,col ) == 0){
                    temp[row][col] = '#';
                }else if(super.getGrid()[row][col] =='#' && this.getNumberOfOccupiedSeats( row,col ) >= 5){
                    temp[row][col] = 'L';
                }else{
                    temp[row][col] = super.getGrid()[row][col];
                }
            }
        }
        return temp;
    }

    @Override
    public int checkSeat(int row, int col) {
        if(row <0 || row>=super.SIZE || col<0 || col >=super.SIZE){
            return 0;
        }
        if(super.getCharAt(row,col) == '#'){
            return 1;
        }else if(super.getCharAt(row,col) == 'L'){
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public int getNumberOfOccupiedSeats(int row, int col) {
        return checkDiagonal( row,col )+checkRow( row,col )+checkColumn( row,col );
    }

    public int checkDiagonal(int row, int col){
        int result = 0;

        for (int i = 1; i < super.getSIZE(); i++) {
            int res = checkSeat(row+i, col+i);
            if( res >= 0){
                if(res==1){
                    result++;
                }
                break;
            }
        }
        for (int i = 1; i < super.getSIZE(); i++) {
            int res = checkSeat(row-i, col+i);
            if( res >= 0){
                if(res==1){
                    result++;
                }
                break;
            }
        }
        for (int i = 1; i < super.getSIZE(); i++) {
            int res = checkSeat(row+i, col-i);
            if( res >= 0){
                if(res==1){
                    result++;
                }
                break;
            }
        }
        for (int i = 1; i < super.getSIZE(); i++) {
            int res = checkSeat(row-i, col-i);
            if( res >= 0){
                if(res==1){
                    result++;
                }
                break;
            }
        }
        return result;
    }

    public int checkRow(int row, int col){
        int result = 0;
        for (int i = col+1; i < super.getSIZE(); i++) {
            int res = checkSeat(row, i);
            if( res >= 0){
                if(res==1){
                    result++;
                }
                break;
            }
        }

        for (int i = col-1; i >= 0; i--) {
            int res = checkSeat(row, i);
            if( res >= 0){
                if(res==1){
                    result++;
                }
                break;
            }
        }
    return result;
    }

    public int checkColumn(int row, int col){
        int result = 0;
        for (int i = row+1; i < super.getSIZE(); i++) {
            int res = checkSeat(i, col);
            if( res >= 0){
                if(res==1){
                    result++;
                }
                break;
            }
        }
        for (int i = row-1; i >= 0; i--) {
            int res = checkSeat(i, col);
            if( res >= 0){
                if(res==1){
                    result++;
                }
                break;
            }
        }
        return result;
    }
}
