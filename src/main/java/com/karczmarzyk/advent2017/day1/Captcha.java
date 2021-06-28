package com.karczmarzyk.advent2017.day1;

import static java.lang.String.valueOf;

public class Captcha {

    public static int checkInput(String input){
        int sum = 0;
        int length = input.length();
        for (int i = 0; i < length; i++) {
            int intValue = Integer.parseInt(valueOf(input.charAt(i)));
            if(i < length-1){
                if(input.charAt(i) == input.charAt(i+1)){
                    sum += intValue;
                }
            }else {
                if(input.charAt(i) == input.charAt(0)){
                    sum += intValue;
                }
            }
        }
        return sum;
    }

    public static int checkInputPartTwo(String input){
        int sum = 0;
        int length = input.length();
        int distance = length/2;
        for (int i = 0; i < length; i++) {
            int intValue = Integer.parseInt(valueOf(input.charAt(i)));
            int nextItemIndex = (i + distance) % length;
                if(input.charAt(i) == input.charAt(nextItemIndex)){
                    sum += intValue;
                }
        }
        return sum;
    }
}
