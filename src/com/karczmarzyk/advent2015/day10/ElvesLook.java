package com.karczmarzyk.advent2015.day10;

import java.util.ArrayList;


public class ElvesLook {
    public static ArrayList<String> list = new ArrayList<>();

    public static void convertStringToListOfStrings(String s) {
        list.clear();
        char [] tab = s.toCharArray();
        for (char c : tab) {
            String temp = String.valueOf(c);
            list.add(temp);
        }
    }

    public static void main(String[] args) {

        int licznik = 0;
        convertStringToListOfStrings("1113122113");
        for (int i = 0; i < 50; i++) {
            Sequence seq = new Sequence();
            StringBuilder result = new StringBuilder();
            list.forEach(s->result.append(seq.addCharacterAndGetString(s)));
            licznik++;
            String resultString = result.append(seq.end()).toString();
            System.out.println("result - licznik = "+licznik + " - " + resultString.length());
            convertStringToListOfStrings(result.toString());
        }
    }
}

class Sequence{
    public static String number = "";
    public static int counter = 0;

    public String addCharacterAndGetString(String character)
    {
        StringBuilder sb = new StringBuilder();
        if(number.equals("")) {
            number = character;
            counter++;
        }else if(number.equals(character))
            counter++;
        else {
            sb.append(counter);
            sb.append(number);
            number = character;
            counter = 1;
        }
        return sb.toString();
    }

    public String end()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(counter);
        sb.append(number);
        number = "";
        counter = 0;
        return sb.toString();
    }

}
