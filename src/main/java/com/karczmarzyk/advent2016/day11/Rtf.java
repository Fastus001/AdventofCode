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
        //TODO
        //sprawdzenie czy nie są wszystkie na czwartym piętrze
        isItEnd();
        //pobranie elementów z pietra
        List<Chip> itemsFromCurrentFloor = itemsFromCurrentFloor( mChips );
        //wygenerowanie nowych mozliwości
        int size = itemsFromCurrentFloor.size();
        List<List<Chip>> listList = new ArrayList<>();
        addSingleItemsToMove( itemsFromCurrentFloor, listList );
        addDoublesToMove( itemsFromCurrentFloor, size, listList );
        int floor = elevator.getFloor();
        List<Rtf> afterMove = new ArrayList<>();
        if(floor==1){
                afterMove = getNewMoves(listList, true );
        }
        if(floor==4){
            afterMove = getNewMoves( listList, false );
        }
        if(floor>1 && floor<4){
            afterMove = getNewMoves( listList, true );
            afterMove.addAll( getNewMoves( listList, false ));
//            if(isItemBelow()){
//                afterMove.addAll( getNewMoves( getSingleItems( listList,1 ), false ));
//            }
        }

        //uwzględnic pierwsze i ostatnie piętro
        return afterMove.stream()
                .filter( Objects::nonNull )
                .filter( c->c.moveNumber==moveNumber+1 )
                .collect( Collectors.toList());
    }

    @NotNull
    private List<List<Chip>> getSingleItems(List<List<Chip>> listList, int size) {
        return listList.stream().filter( chips -> chips.size() == size ).collect( Collectors.toList() );
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

    private void addDoublesToMove(List<Chip> itemsFromCurrentFloor, int size, List<List<Chip>> listList) {
        if( size >2){
            List<int[]> generate = Generator.generate( size );
            for (int[] ints : generate) {
                List<Chip> temp = new ArrayList<>();
                for (int i : ints) {
                    temp.add( itemsFromCurrentFloor.get( i-1 ) );
                }
                listList.add( temp );
            }
        }else if( size ==2){
            listList.add( itemsFromCurrentFloor );
        }
    }

    private void addSingleItemsToMove(List<Chip> itemsFromCurrentFloor, List<List<Chip>> listList) {
        for (Chip chip : itemsFromCurrentFloor) {
            List<Chip> temp = new ArrayList<>();
            temp.add( chip );
            listList.add( temp );
        }
    }

    private boolean isItemBelow() {
        return mChips.stream()
                .anyMatch( chip -> chip.getFloor()<elevator.getFloor() );
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

        List<Chip> tempChips = getCopyOfChipsToMove( list, copyOfChips );

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

    private void moveUpOrDown(boolean up, Elevator tempElevator) {
        if( up ){
            tempElevator.moveUp();
        }else{
            tempElevator.moveDown();
        }
    }

    @NotNull
    private List<Chip> getCopyOfChipsToMove(List<Chip> list, List<Chip> copyOfChips) {
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

    public List<Chip> itemsFromCurrentFloor(List<Chip> lst){
        return lst.stream()
                .filter( c->c.getFloor()== elevator.getFloor() )
                .collect( Collectors.toList());
    }

    public int getFloorSum(){
        return mChips.stream().mapToInt( Chip::getFloor ).sum();
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
