package com.karczmarzyk.advent2016.day11;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Elevator  implements Elevatorable{

    private Chip first;
    private Chip second;
    private int floor;


    public boolean attacheSecond(Chip chip){
        if(!first.getType().equals( chip.getType() )){
            if(first.getName().equals(chip.getName()  )){
                second = chip;
                return true;
            }else{
                return false;
            }
        }else{
            second=chip;
            return true;
        }
    }

    @Override
    public void moveUp() {
        floor++;
        first.moveUp();
        if(second!=null){
            second.moveUp();
        }
    }

    @Override
    public void moveDown() {
        floor--;
        first.moveDown();
        if(second!=null){
            second.moveDown();
        }
    }
}
