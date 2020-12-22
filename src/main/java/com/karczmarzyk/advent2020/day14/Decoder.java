package com.karczmarzyk.advent2020.day14;

import java.util.ArrayList;
import java.util.List;

public class Decoder {
    private String mask;

    public Decoder(String mask) {
        this.mask = mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String convertNumberToBitString(int number){
        String s = Integer.toBinaryString(number);
        StringBuilder temp = new StringBuilder();
        temp.append("0".repeat(36 - s.length()));
        temp.append(s);
        return convertWithMask(temp.toString());
    }

    private String convertWithMask(String number){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if(mask.charAt(i)=='X'){
                temp.append("X");
            }else if(mask.charAt(i)=='1'){
                temp.append(mask.charAt(i));
            }else{
                temp.append(number.charAt(i));
            }
        }
        return temp.toString();
    }

    public List<String> getFloating(List<String> in){
        String x = in.stream().filter(s -> s.contains("X")).findFirst().orElse("");
        if(x.length()==0){
            return in;
        }else{
            List<String> temp = new ArrayList<>();
            for(String s:in){
                temp.add(s.replaceFirst("X","0"));
                temp.add(s.replaceFirst("X","1"));
            }
            return getFloating(temp);
        }
    }

}
