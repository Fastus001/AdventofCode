package com.karczmarzyk.advent2016.day11;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Rtf {
    private List<Chip> mChips;
    private Elevator elevator;
    private int MOVE = 0;

    public Rtf(List<Chip> mChips, Elevator elevator) {
        this.mChips = mChips;
        this.elevator = elevator;
    }

    public Rtf execute(List<Chip> list,boolean up){
        List<Chip> temp = new ArrayList<>();
        for (Chip c : mChips) {
            temp.add( c.clone() );
        }

        List<Chip> tempChips = new ArrayList<>();
        for (Chip cList : list) {
            for (Chip cT : temp) {
                if(cT.equals( cList ))
                    tempChips.add( cT );
            }
        }

        Elevator tempElevator = Elevator.builder().floor( elevator.getFloor() ).build();

        tempElevator.setFirst( tempChips.get( 0 ) );
        if ( tempChips.size()>1 ){
            if(!tempElevator.attacheSecond( tempChips.get( 1 ) )){
                return null;
            }
        }

        if(up){
            tempElevator.moveUp();
        }else{
            tempElevator.moveDown();
        }
        int nextRound = MOVE+1;

        //TODO - check integrity of new RTF
        // if item on new floor are allowed, if not return null
        return Rtf.builder()
                .mChips( temp )
                .elevator( tempElevator )
                .MOVE( nextRound )
                .build();
    }

    public List<Chip> getCurrentItems(List<Chip> lst){
        return lst.stream()
                .filter( c->c.getFloor()== elevator.getFloor() )
                .collect( Collectors.toList());
    }

}
