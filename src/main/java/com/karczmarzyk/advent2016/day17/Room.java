package com.karczmarzyk.advent2016.day17;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Room {
    private String passMain;

    public void setPassMain(String passMain) {
        this.passMain = passMain;
    }

    public String start(List<String> input){
        List<String> resultList = input.stream()
                .map( this::testHashCode )
                .flatMap( Collection::stream )
                .map( this::testMove )
                .filter( s -> !s.contains( "false" ) )
                .collect( Collectors.toList() );

        for (String s : resultList) {
            if(s.contains( "FINISH" )){
                return s.split( "-" )[0];
            }
        }
        return start( resultList );
    }

    public List<String> testHashCode(String tail){
        List<String> temp = new ArrayList<>();
        char[] doors = DigestUtils.md5Hex( passMain +tail ).substring( 0, 4 ).toCharArray();
        if(doors[0]>97){
            temp.add( tail+"U" );
        }
        if(doors[1]>97){
            temp.add( tail+"D" );
        }
        if(doors[2]>97){
            temp.add( tail+"L" );
        }
        if(doors[3]>97){
            temp.add( tail+"R" );
        }
        return temp;
    }

    public String  testMove(String moves){
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt( i )){
                case 'U':startX-=1;break;
                case 'D':startX+=1;break;
                case 'L':startY-=1;break;
                case 'R':startY+=1;break;
            }
            if(startX < 0 || startX > 3 || startY < 0 || startY > 3){
                return moves+"false";
            }
        }
        if(startX==3 && startY==3){
            return moves+"-FINISH";
        }
        return moves;
    }

}
