package com.karczmarzyk.advent2016.day21;

public class Scrambler {
    private final int size;
    private char[] pass;

    public Scrambler(String pass) {
        this.pass = pass.toCharArray();
        this.size = this.pass.length;
    }

    public void rotateBasedOnPosition(char letter){
        int rotate = 0;
        for (int i = 0; i < size; i++) {
            if(pass[i]==letter){
                rotate = i;
            }
        }
        if(rotate>=4){
            rotate( rotate+2,true );
        }else{
            rotate( rotate+1,true );
        }
    }

    public void movePosition(int x, int y){
        var sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if(i != x){
                sb.append( pass[i] );
            }
        }
        sb.insert( y,pass[x] );
        pass = sb.toString().toCharArray();
    }

    public void reversePositions(int x, int y){
        char[] temp = new char[size];
        for (int i = 0; i < x; i++) {
            temp[i] = pass[i];
        }
        for (int i = y, z = x; i >= x; i--, z++) {
            temp[i] = pass[z];
        }
        for (int i = y+1; i < size; i++) {
            temp[i] = pass[i];
        }
        pass= temp;
    }

    /*
    rotate left/right X steps means that the whole string should be rotated;
    for example, one right rotation would turn abcd into dabc.
     */
    public void rotate(int x, boolean right){
        x = x% size;
        char[] temp = new char[size];
        for (int i = 0; i < size; i++) {
            int index = i+x;
            if(index>= size){
                index -=size;
            }
            if(right){
                temp[index] = pass[i];
            }else{
                temp[i] = pass[index];
            }
        }
        pass = temp;
    }

    public void swapLetter(char first, char second){
        int x = -1;
        int y = -1;
        for (int i = 0; i < pass.length; i++) {
            if(pass[i]==first){
                x = i;
            }
            if(pass[i]==second){
                y = i;
            }
        }
        swapPosition( x,y );
    }

    public void swapPosition(int x, int y){
        char temp = pass[x];
        pass[x] = pass[y];
        pass[y] = temp;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (char c : pass) {
            sb.append( c );
        }
        return sb.toString();
    }
}
