package com.karczmarzyk.advent2020.day24;

import lombok.Data;
import lombok.NoArgsConstructor;

public class Hex {
    private boolean white;
    private Pair pair = new Pair();

    public Hex(String input) {
        var split = input.split( "" );
        for (String s : split) {
            this.addNumber( s );
        }
        white = false;
    }

    public void addNumber(String l){
        switch (l){
            case "e": pair.addX(2);break;
            case "w": pair.addX( -2 );break;
            case "b": pair.addX( 1 ); pair.addY( 1 ); break;
            case "d": pair.addX( -1 ); pair.addY( 1 ); break;
            case "h": pair.addX( 1 ); pair.addY( -1 ); break;
            case "k": pair.addX( -1 ); pair.addY( -1 ); break;
        }
    }

    public Pair getPair() {
        return pair;
    }

    public boolean isBlack(){
        return !white;
    }

    public void flipColor(){
        white = !white;
    }
}

@NoArgsConstructor
@Data
class Pair{
    private int x = 0;
    private int y = 0;

    public void addX(int value){
        x+=value;
    }

    public void addY(int value){
        y+=value;
    }


}
