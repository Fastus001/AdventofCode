package com.karczmarzyk.advent2020.day22;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class GameAdv extends Game{
    private boolean winFast = false;
    private final List<String> plOneHistory = new ArrayList<>();
    private final List<String> plTwoHistory = new ArrayList<>();


    @Override
    public void round() {
        String one = sameCardsOne();
        String two = sameCardsTwo();
        //check history
        if(plOneHistory.contains( one ) || plTwoHistory.contains( two )){
            winFast = true;
            return;
        }else{
            plOneHistory.add( one );
            plTwoHistory.add( two );
        }
        //
        int nextOne = super.getOne().remove();
        int nextTwo = super.getTwo().remove();

        if(super.getOne().size()>=nextOne && super.getTwo().size()>=nextTwo){
            GameAdv newGame = new GameAdv();
            newGame.setOne( getSubDeque( nextOne, new ArrayDeque<>( super.getOne() ) ) );
            newGame.setTwo( getSubDeque( nextTwo, new ArrayDeque<>( super.getTwo() ) ) );

            if(newGame.result()){
                super.getOne().add( nextOne );
                super.getOne().add( nextTwo );
            }else{
                super.getTwo().add( nextTwo );
                super.getTwo().add( nextOne );
            }
        }else{
            if(nextOne>nextTwo){
                super.getOne().add( nextOne );
                super.getOne().add( nextTwo );
            }else if(nextOne<nextTwo){
                super.getTwo().add( nextTwo );
                super.getTwo().add( nextOne );
            }
        }
    }

    @NotNull
    private Deque<Integer> getSubDeque(int nextOne, Deque<Integer> integers) {
        Deque<Integer> temp = new ArrayDeque<>();
        for (int i = 0; i < nextOne; i++) {
            temp.add( integers.remove() );
        }
        return temp;
    }

    //true - first won
    public boolean result() {
        while (!super.getOne().isEmpty() && !super.getTwo().isEmpty() && !winFast){
            round();
        }
        return winFast || super.getTwo().isEmpty();
    }

    @NotNull
    private String sameCardsOne() {
        return super.getOne().stream().map( s -> Integer.toString( s ) )
                .collect( Collectors.joining() );
    }

    @NotNull
    private String sameCardsTwo() {
        return super.getTwo().stream().map( s -> Integer.toString( s ) )
                .collect( Collectors.joining() );
    }
}
