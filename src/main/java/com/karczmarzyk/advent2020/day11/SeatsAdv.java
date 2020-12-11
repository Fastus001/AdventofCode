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
    public int getNumberOfOccupiedSeats(int row, int col) {
        return checkDiagonal( row,col )+checkRow( row )+checkColumn( col );
    }

    public int checkDiagonal(int row, int col){
        int result = 0;

        //1 w dó³
        for (int i = col+1,x=1; i < super.getSIZE(); i++,x++) {
            if(checkSeat( row+x,i )==1){
                result++;
                break;
            }
        }
        for (int i = col+1,x=1; i < super.getSIZE(); i++,x++) {
            if(checkSeat( row-x,i )==1){
                result++;
                break;
            }
        }
        //TODO
//        for (int i = col,x=1; i > 0; i--) {
//            if(checkSeat( row+x,col-x )==1){
//                result++;
//                break;
//            }
//        }
//        for (int i = col,x=1; i > 0; i--) {
//            if(checkSeat( row-x,col-x )==1){
//                result++;
//                break;
//            }
//        }


//
//        for (int i = col, x=0, y=0; i < super.getSIZE(); i++,x++, y++) {
//            result += checkSeat( row+x,i );
//            result += checkSeat( row-x,i );
//            result += checkSeat( row+x,col-y );
//            result += checkSeat( row-x,col-y );
//        }
        return Math.min( result, 4 );
    }


    public int checkRow(int row){
        int result = 0;
        for (int i = 0; i < super.getSIZE(); i++) {
            if(super.getGrid()[row][i] == '#'){
                result++;
            }
        }
        if(row == 0 || row == super.getSIZE()-1){
            return Math.min( result, 1 );
        }else {
            return Math.min( result, 2 );
        }
    }

    public int checkColumn(int col){
        int result = 0;
        for (int i = 0; i < super.getSIZE(); i++) {
            if(super.getGrid()[i][col] == '#'){
                result++;
            }
        }
        if(col == 0 || col == super.getSIZE()-1){
            return Math.min( result, 1 );
        }else {
            return Math.min( result, 2 );
        }
    }
}
