package com.karczmarzyk.advent2020.day22;

import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

@Data
public class Game {
    private static int gameNo = 0;
    private Queue<Integer> one = new ArrayDeque<>();
    private Queue<Integer> two = new ArrayDeque<>();

    public void addPlayerDecks(String path) throws IOException {
        List<String> input = Files.readAllLines( Path.of( path ) );
        boolean one = true;
        for (String s : input) {
            if(s.isEmpty()){
                one = false;
            }else{
                if(one){
                    this.one.add( Integer.parseInt( s ) );
                }else{
                    this.two.add( Integer.parseInt( s ) );
                }
            }
        }
    }

    public void round(){
        if(one.peek()>two.peek()){
            one.add( one.remove() );
            one.add( two.remove() );
        }else if(one.peek()<two.peek()){
            two.add( two.remove() );
            two.add( one.remove() );
        }
    }
    
    public long getResult(){
        long res = 0;
        if( one.isEmpty() ){
            for (int i = two.size(); i > 0; i--) {
                res+= ( long ) two.remove() *i;
            }
        }else{
            for (int i = one.size(); i > 0; i--) {
                res+= ( long ) one.remove() *i;
            }
        }
        return res;
    }

    public static int getGameNo() {
        return gameNo;
    }
}
