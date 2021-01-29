package com.karczmarzyk.advent2016.day16;

import org.jetbrains.annotations.NotNull;

public class DataGen {
    private int desiredSize;

    public DataGen(int desiredSize) {
        this.desiredSize = desiredSize;
    }



    public String generateChecksum(String data){
        var sb = new StringBuilder();
        for (int i = 0; i < data.length(); i+=2) {
            if ( data.charAt( i ) == data.charAt( i + 1 ) ) {
                sb.append( 1 );
            }
            else {
                sb.append( 0 );
            }
        }
        if(sb.length()%2==0){
            return generateChecksum( sb.toString() );
        }else
            return sb.toString();
    }

    public String generateData(String init){
        if(init.length()>=desiredSize){
            return init.substring( 0,desiredSize );
        }else{
            init = init+"0"+reverseString( init);
        }
        return generateData( init);
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
