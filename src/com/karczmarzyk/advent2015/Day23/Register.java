package com.karczmarzyk.advent2015.Day23;

public class Register {
    private int a = 0;

    public int executeInstruction(String inst, int index)
    {
        if( !inst.contains( "j" ))
            return firstThreeInstructions( inst, index );
        else{
            return jumpInstructions( inst, index);
        }
    }

    private int jumpInstructions(String inst, int index) {
        String [] tab = inst.split( " " );
        switch (tab[0])
        {
            case "jmp": return index+Integer.parseInt( tab[1] );
            case "jio":
                if(a == 1)
                    return index+Integer.parseInt( tab[2] );
                else
                    return index+1;
            case "jie":
                if(a % 2 == 0)
                    return index+Integer.parseInt( tab[2] );
                else
                    return index+1;
        }
        return 0;
    }

    private int firstThreeInstructions(String inst, int index) {
        String [] tab = inst.split( " " );
        changeA( tab[0]);
        return index+1;
    }

    private void changeA(String s) {
        switch (s)
        {
            case "inc": a++;break;
            case "hlf": a/=2;break;
            case "tpl": a*=3;break;
            default:break;
        }
    }

    public int getA() {
        return a;
    }
}
