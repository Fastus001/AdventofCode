package com.karczmarzyk.advent2021.day13;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FoldMachine {
    private Set<Coordinate> points;
    private List<String> foldInstructions;

    public FoldMachine(List<String> input) {
        foldInstructions = input.stream().filter(s->s.contains("fold"))
                .collect(Collectors.toList());
        points = input.stream().filter(s -> s.contains(",")).map(Coordinate::new).collect(Collectors.toSet());
    }

    public void foldPaper(){
        for (String foldInstruction : foldInstructions) {
            foldInstruction(foldInstruction);
        }
        System.out.println("points = " + points);
        printNumber();
    }

    private void printNumber() {
        char [][] tab = new char[40][40];
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                tab[i][j] = '.';
            }
        }
        points.forEach(p->tab[p.getY()][p.getX()]='#');
        var vb = new StringBuilder();
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                vb.append(tab[i][j]);
            }
            vb.append('\n');
        }
        System.out.println(vb);
    }

    private boolean isDot(int x, int y) {
        Optional<Coordinate> optional = points.stream().filter(p -> p.getY() == x && p.getY() == y).findFirst();
        return optional.isPresent();
    }


    public int foldInstruction(String instruction){
        String[] split = instruction.split("=");
        if(split[0].contains("y")){
            foldHorizontal(Integer.parseInt(split[1]));
        }else {
            foldVertical(Integer.parseInt(split[1]));
        }
        return points.size();
    }

    private void foldHorizontal(int y) {
        Set<Coordinate> afterFold = points.stream().filter(p -> p.getY() < y).collect(Collectors.toSet());
        Set<Coordinate> secondPart = points.stream().filter(p -> p.getY() > y).map(p -> {
            int difference = p.getY() - y;
            p.setY(y - difference);
            return p;
        }).collect(Collectors.toSet());
        afterFold.addAll(secondPart);
        points = afterFold;
    }

    private void foldVertical(int x) {
        Set<Coordinate> afterFold = points.stream().filter(p -> p.getX() < x).collect(Collectors.toSet());
        Set<Coordinate> secondPart = points.stream().filter(p -> p.getX() > x).map(p -> {
            int difference = p.getX() - x;
            p.setX(x - difference);
            return p;
        }).collect(Collectors.toSet());
        afterFold.addAll(secondPart);
        points = afterFold;
    }


}
