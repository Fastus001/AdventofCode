package com.karczmarzyk.advent2016.day11;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.karczmarzyk.utils.Generator.generateCombinations;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Rtf {
    private List<Chip> mChips;
    private Elevator elevator;
    private int moveNumber = 0;

    public Rtf(List<Chip> mChips, Elevator elevator) {
        this.mChips = mChips;
        this.elevator = elevator;
    }

    public List<Rtf> generatePossibleMoves(){
        isItEnd();

        List<Chip> currentFloor = itemsFromCurrentFloor( mChips );

        List<List<Chip>> listList = new ArrayList<>();
        addSingleItemsToMove( currentFloor, listList );
        if ( currentFloor.size()>1 ){
            addDoublesToMove( currentFloor,listList );
        }

        int floor = elevator.getFloor();

        return getMoves( listList, floor )
                .stream()
                .filter( Objects::nonNull )
                .filter( c->c.moveNumber==moveNumber+1 )
                .collect( Collectors.toList());
    }

    public List<Chip> itemsFromCurrentFloor(List<Chip> lst){
        return lst.stream()
                .filter( c->c.getFloor()== elevator.getFloor() )
                .collect( Collectors.toList());
    }

    private void addSingleItemsToMove(List<Chip> itemsFromCurrentFloor, List<List<Chip>> listList) {
        for (Chip chip : itemsFromCurrentFloor) {
            List<Chip> temp = new ArrayList<>();
            temp.add( chip );
            listList.add( temp );
        }
    }

    private void addDoublesToMove(List<Chip> floorItems, List<List<Chip>> listList) {
        if( floorItems.size() ==2){
            listList.add( floorItems );
        }else{
            for (int[] ints : generateCombinations( floorItems.size() )) {
                List<Chip> temp = new ArrayList<>();
                for (int i : ints) {
                    temp.add( floorItems.get( i-1 ) );
                }
                listList.add( temp );
            }
        }
    }

    private List<Rtf> getMoves(List<List<Chip>> listList, int floor) {
        List<Rtf> afterMove;
        switch (floor){
            case 1:afterMove = getNewMoves( listList, true );break;
            case 4:afterMove = getNewMoves( listList, false );break;
            case 2:
            case 3:
                afterMove = getNewMoves( listList, true );
                afterMove.addAll( getNewMoves( listList, false ));break;
            default: throw new IllegalStateException( "Unexpected value: " + floor );
        }
        return afterMove;
    }

    @NotNull
    private List<Rtf> getNewMoves(List<List<Chip>> listList, boolean up) {
        return listList.stream().map( chips -> {
            try {
                return executeNextMove( chips, up );
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        } ).collect( Collectors.toList() );
    }

    private void isItEnd() {
        long howManyOnFourFloor = mChips.stream()
                .filter( chip -> chip.getFloor() == 4 )
                .count();
        if(howManyOnFourFloor==mChips.size()){
            System.out.println("Finish!!!!!!! " + moveNumber);
        }
    }


    public Rtf executeNextMove(List<Chip> list, boolean up) throws CloneNotSupportedException {

        List<Chip> copyOfChips = getCopyOfChips();

        List<Chip> tempChips = getCopyOfItemsToMove( list, copyOfChips );

        Elevator tempElevator = Elevator.builder().floor( elevator.getFloor() ).build();

        tempElevator.setFirst( tempChips.get( 0 ) );
        if ( tempChips.size()>1 ){
            if(!tempElevator.attacheSecond( tempChips.get( 1 ) )){
                return null;
            }
        }

        moveUpOrDown( up, tempElevator );

        int nextRound = moveNumber +1;

        Rtf newRtf = Rtf.builder()
                .mChips( copyOfChips )
                .elevator( tempElevator )
                .moveNumber( nextRound )
                .build();

        return RtfValidator.validateRtf( newRtf ) ? newRtf:null;
    }

    private void moveUpOrDown(boolean up, Elevator elevator) {
        if( up ){
            elevator.moveUp();
        }else{
            elevator.moveDown();
        }
    }

    @NotNull
    private List<Chip> getCopyOfItemsToMove(List<Chip> list, List<Chip> copyOfChips) {
        List<Chip> tempChips = new ArrayList<>();
        for (Chip cList : list) {
            for (Chip cT : copyOfChips) {
                if(cT.equals( cList ))
                    tempChips.add( cT );
            }
        }
        return tempChips;
    }

    @NotNull
    private List<Chip> getCopyOfChips() throws CloneNotSupportedException {
        List<Chip> temp = new ArrayList<>();
        for (Chip c : mChips) {
            temp.add( c.cloneChip() );
        }
        return temp;
    }

    @Override
    public String toString() {
        return mChips.toString();
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        Rtf rtf = ( Rtf ) o;

        if ( moveNumber != rtf.moveNumber ) return false;
        return mChips != null ? mChips.equals( rtf.mChips ) : rtf.mChips == null;
    }

    @Override
    public int hashCode() {
        int result = mChips != null ? mChips.hashCode() : 0;
        result = 31 * result + moveNumber;
        return result;
    }
}
