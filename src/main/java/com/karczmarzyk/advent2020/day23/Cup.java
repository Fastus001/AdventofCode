package com.karczmarzyk.advent2020.day23;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cup {
    private Integer number;

    private Cup previous;
    private Cup next;
}
