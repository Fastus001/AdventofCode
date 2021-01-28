package com.karczmarzyk.advent2016.day16;

import org.jetbrains.annotations.NotNull;

public class DataGen {
    private int desiredSize;

    public DataGen(int desiredSize) {
        this.desiredSize = desiredSize;
    }


    public String generate(String init){
        if(init.length()>=desiredSize){
            return init.substring( 0,desiredSize );
        }else{
            init = init+"0"+reverseString( init);
        }
        return generate( init);
    }

    @NotNull
    private String reverseString(String init) {
        var sb = new StringBuilder();
        int length = init.length();
        for (int i = 0; i < length; i++) {
            if( init.charAt( (length -1)-i )=='0'){
                sb.append( '1');
            }else{
                sb.append( '0');
            }
        }
        return sb.toString();
    }
}
