package com.karczmarzyk.advent2015.Day23;

public class Register {
    private int a = 0;
    private int b = 0;

    public int executeInstruction(String inst, int index)
    {
        if( inst.contains( "hlf" ))
            return hlfInstruction( inst, index );
        if ( inst.contains( "inc" ) )
            return incInstruction(inst,index);
        if ( inst.contains( "tpl" ) )
            return tpl(inst,index);


        return index;
    }

    private int tpl(String inst, int index) {
        String [] tab = inst.split( " " );
        if ( tab[1].equals( "a" ) ) {
            a*=3;
        }
        else {
            b*=3;
        }
        return index;
    }


    private int incInstruction(String inst, int index) {
        String [] tab = inst.split( " " );
        if ( tab[1].equals( "a" ) ) {
            a++;
        }
        else {
            b++;
        }
        return index;
    }


    private int hlfInstruction(String inst, int index) {
        String [] tab = inst.split( " " );
            if(tab[1].equals( "a" ))
                a = a/2;
            if(tab[1].equals( "b" ))
                b = b/2;
            return index;
    }

    public int getA() {
        return a;
    }
}
