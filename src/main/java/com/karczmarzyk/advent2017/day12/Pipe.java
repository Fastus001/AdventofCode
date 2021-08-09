package com.karczmarzyk.advent2017.day12;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class Pipe {
    private final Integer number;
    private final List<Integer> programsId;
    private List<Pipe> pipes = new ArrayList<>();
    private boolean zeroLinked;

    public Pipe(Integer number, List<Integer> programsId) {
        this.number = number;
        this.programsId = programsId;
        zeroLinked = number.equals(0);
    }

    public void setPipes(Map<Integer, Pipe> records) {
            pipes = programsId.stream()
                    .map(records::get)
                    .collect(Collectors.toList());
    }

    public void setZeroLinkedTrue() {
        List<Pipe> list = pipes.stream().filter(pipe -> !pipe.zeroLinked)
                .collect(Collectors.toList());
        list.forEach(pipe -> pipe.setZeroLinked(true));
        list.forEach(Pipe::setZeroLinkedTrue);
    }
}
