package com.karczmarzyk.advent2016.day18;

public class Traps {


    public String getNewRow(String row){
        var sb = new StringBuilder();
        sb.append(checkTiles("."+row.substring( 0,2 ))  );
        for (int i = 1; i < row.length()-1; i++) {
            sb.append( checkTiles( row.substring( i-1,i+2 ) ) );
        }
        sb.append(checkTiles(row.substring( row.length()-2)+".")  );
        return sb.toString();
    }


    public char checkTiles(String tiles){
        switch (tiles){
            case "^^.":
            case ".^^":
            case "^..":
            case  "..^":return '^';
            default:return '.';
        }
    }
}
