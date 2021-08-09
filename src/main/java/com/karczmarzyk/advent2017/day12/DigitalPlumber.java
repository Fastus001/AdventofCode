package com.karczmarzyk.advent2017.day12;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Data
public class DigitalPlumber {
    private Integer rootNumber = 0;
    private final Map<Integer,Pipe> records;

    public DigitalPlumber(List<String> input) {
        records = input.stream()
                .map(line -> line.replace(" <-> ", ", "))
                .map(line -> line.split(", "))
                .map(arr -> Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList()))
                .map(list->new Pipe(list.get(0), list.subList(1, list.size())))
                .collect(toMap(Pipe::getNumber, pipe->pipe));

        records.values()
                .forEach(pipe -> pipe.setPipes(records));
    }

    public void execute() {
        Pipe pipe = records.get(rootNumber);
        pipe.setZeroLinkedTrue();
    }

    public long getConnectedProgramsNo() {
        return records.values().stream()
                .filter(Pipe::isZeroLinked)
                .count();
    }

}
