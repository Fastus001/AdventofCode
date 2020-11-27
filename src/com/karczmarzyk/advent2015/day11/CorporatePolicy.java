package com.karczmarzyk.advent2015.day11;

public class CorporatePolicy {
    public static void main(String[] args) {
        Password psw = new Password("hxbxxzaa");
        while (!psw.isNotOk()){
            psw.increaseByOne(7);
            if(psw.isNotOk())
                System.out.println("psw.getPassword() = " + psw.getPassword());
        }
    }
}
