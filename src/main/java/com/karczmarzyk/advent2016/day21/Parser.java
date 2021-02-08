package com.karczmarzyk.advent2016.day21;

import static java.lang.Integer.parseInt;

public class Parser {
    private Scrambler scrambler;

    public Parser(Scrambler scrambler) {
        this.scrambler = scrambler;
    }

    public void scramblerFunctions(String line){
        String[] s = line.split( " " );
        if(line.contains( "swap position " )){
            scrambler.swapPosition( parseInt(s[2]), parseInt( s[5]) );
        }else if(line.contains( "reverse positions " )){
            scrambler.reversePositions(parseInt(s[2]), parseInt( s[4])  );
        }else if ( line.contains( "rotate right " ) ){
            scrambler.rotate( parseInt(s[2]),true );
        }else if ( line.contains( "rotate left" ) ){
            scrambler.rotate( parseInt(s[2]),false );
        }else if ( line.contains( "rotate based on position of letter" ) ){
            scrambler.rotateBasedOnPosition( s[6].charAt( 0 ) );
        }else if(line.contains( "move position " )){
            scrambler.movePosition( parseInt(s[2]), parseInt( s[5]) );
        }else if(line.contains( "swap letter " )){
            scrambler.swapLetter( s[2].charAt( 0 ),s[5].charAt( 0 ) );
        }
    }

    public Scrambler getScrambler() {
        return scrambler;
    }
}
