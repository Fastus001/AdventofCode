package com.karczmarzyk.advent2021.day4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Square {
    private List<Pair> numbers;

    public boolean isRowOrColFull() {
        if (isRowFull()) return true;
        return isColFull();
    }

    public int getSumOfUnmarked() {
        return numbers.stream()
                .filter(pair -> !pair.isChecked())
                .mapToInt(Pair::getNumber)
                .sum();
    }

    private boolean isRowFull() {
        for (int i = 0; i < 25; i+=5) {
            int returnVal = 0;
            for (int j = 0; j < 5; j++) {
                if(numbers.get(i+j).isChecked()) returnVal++;
            }
            if(returnVal==5) return true;
        }
        return false;
    }

    private boolean isColFull() {
        for (int i = 0; i < 5; i++) {
            int returnVal = 0;
            for (int j = 0; j < 25; j+=5) {
                if(numbers.get(i+j).isChecked()) returnVal++;
            }
            if(returnVal==5) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            if(i % 5 == 0) {
                sb.append("\n");
            }
            sb.append(numbers.get(i)).append(" ");
        }
        return sb.toString();
    }
}


