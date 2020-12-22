package com.karczmarzyk.advent2020.day14;

public class Bitmask {
    private String mask;

    public Bitmask(String mask) {
        this.mask = mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public long convertNumberToBitString(int number){
        String s = Integer.toBinaryString(number);
        StringBuilder temp = new StringBuilder();
        temp.append("0".repeat(36 - s.length()));
        temp.append(s);
        return convertWithMask(temp.toString());
    }

    private long convertWithMask(String number){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if(mask.charAt(i)=='X'){
                temp.append(number.charAt(i));
            }else{
                temp.append(mask.charAt(i));
            }
        }
        return Long.parseLong(temp.toString(),2);
    }
}
