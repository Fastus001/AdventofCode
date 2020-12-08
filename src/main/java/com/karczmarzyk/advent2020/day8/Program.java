package com.karczmarzyk.advent2020.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    private final List<Instruction> list = new ArrayList<>();

    public boolean executeProgram(int i) {
        clearData();
        changeInstruction( i );

        int step = 0;
        while (step < (list.size())) {
            if ( !isVisited( step ) ) {
                step += list.get( step ).executeInstruction();
            }
            else if ( isVisited( step ) ) {
                changeInstruction( i );
                return false;
            }
        }
        return true;
    }

    private boolean isVisited(int step) {
        return list.get( step ).isVisited();
    }

    private void changeInstruction(int index) {
        list.get( index ).swap();
    }

    private void clearData() {
        Instruction.setAccumulator( 0 );
        for (Instruction i : list) {
            i.setVisited( false );
        }
    }

    public void getInputData(String path) {
        try (var in = new Scanner( new File( path ) )) {
            while (in.hasNext()) {
                String[] split = in.nextLine().split( " " );
                list.add( new Instruction( split[0], Integer.parseInt( split[1] ) ) );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public int sizeOfList() {
        return list.size();
    }

    public int getAccumulator() {
        return Instruction.getAccumulator();
    }
}
