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
            return 2;
        }else{
            return 0;
        }
    }

    @Override
    public int getNumberOfOccupiedSeats(int row, int col) {
        return checkDiagonal( row,col )+checkRow( row,col )+checkColumn( col,row );
    }

    //todo - jak ktos widzi puste miejsce to zero
    public int checkDiagonal(int row, int col){
        int result = 0;

        for (int i = 1; i < super.getSIZE(); i++) {
            int cellSign = checkSeat(row + i, col + i);
            if(cellSign ==1){
                cellSign++;
                break;
            }else if(cellSign ==2){
                break;
            }
        }
        for (int i = 1; i < super.getSIZE(); i++) {
            if(checkSeat( row-i,col+i )==1){
                result++;
                break;
            }
        }
        for (int i = 1; i < super.getSIZE(); i++) {
            if(checkSeat( row+i,col-i )==1){
                result++;
                break;
            }
        }
        for (int i = 1; i < super.getSIZE(); i++) {
            if(checkSeat( row-i,col-i )==1){
                result++;
                break;
            }
        }
        return result;
    }

//todo
    public int checkRow(int row, int col){
        int result = 0;
        for (int i = 0; i < super.getSIZE(); i++) {
            if(super.getGrid()[row][i] == '#'){
                result++;
            }
        }
        if(col == 0 || col == super.getSIZE()-1){
            return Math.min( result, 1 );
        }else {
            return Math.min( result, 2 );
        }
    }
//todo
    public int checkColumn(int col, int row){
        int result = 0;
        for (int i = 0; i < super.getSIZE(); i++) {
            if(super.getGrid()[i][col] == '#'){
                result++;
            }
        }
        if(row == 0 || row == super.getSIZE()-1){
            return Math.min( result, 1 );
        }else {
            return Math.min( result, 2 );
        }
    }
}
