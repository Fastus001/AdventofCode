package com.karczmarzyk.advent2017.day12;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.*;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toMap;

@Data
public class DigitalPlumber {
    private int groupCounter = 0;
    private Map<Integer,Pipe> records;

    public DigitalPlumber(List<String> input) {
        records = input.stream()
                .map(line -> line.replace(" <-> ", ", "))
                .map(line -> line.split(", "))
                .map(arr -> Arrays.stream(arr).map(Integer::parseInt).collect(toList()))
                .map(list->new Pipe(list.get(0), list.subList(1, list.size())))
                .collect(toMap(Pipe::getNumber, pipe->pipe));

        records.values()
                .forEach(pipe -> pipe.setPipes(records));
    }

    public int getGroupCounter() {
        while (records.size() != 0) {
            records.entrySet()
                    .stream()
                    .findFirst()
                    .ifPresent(entry -> markGroup(entry.getKey()));
            records =records.entrySet()
                    .stream()
                    .filter(entries->!entries.getValue().isZeroLinked())
                    .collect(toMap(Entry::getKey, Entry::getValue));
            groupCounter++;
        }
        return groupCounter;
    }

    public void markGroup(int number) {
        Pipe pipe = records.get(number);
        pipe.setZeroLinkedTrue();
    }

    public long getConnectedProgramsNo() {
        return records.values().stream()
                .filter(Pipe::isZeroLinked)
                .count();
    }

}
