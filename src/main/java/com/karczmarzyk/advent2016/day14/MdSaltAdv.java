package com.karczmarzyk.advent2016.day14;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class MdSaltAdv extends MdSalt{
    private static final int ADD_HASHING = 2016;
    private final Map<Integer,String> hashesMap = new HashMap<>();

    public MdSaltAdv(String salt) {
        super( salt );
    }

    @Override
    public int start() throws NoSuchAlgorithmException {
        String hash;
        do{
            if(hashesMap.containsKey( number )){
                hash = hashesMap.get( number );
            }else{
                hash = super.generateHash( salt + number, ADD_HASHING );
            }

            addToKeysIfCorrect( hash );

            if(keys.size()==64){
                return number;
            }
            number++;
        }while (keys.size()<64);

        return number;
    }

    private void addToKeysIfCorrect(String hash) {
        if( checkHash( hash )){
            String temp = getMatchingString( hash );
            if(nextThousand( salt,temp,number )){
                keys.add( hash );
                System.out.println( "hash = " + hash + " number - " + number);
            }
        }
    }

    @Override
    public boolean nextThousand(String salt, String chars, int number) {
        for (int i = number+1; i <=1000+number ; i++) {
            if( hashesMap.containsKey( i )){
                if( hashesMap.get( i ).contains( chars )){
                    return true;
                }
            }else{
                String s = generateHash( salt + i,ADD_HASHING);
                hashesMap.put( i, s );
                if(s.contains( chars )){
                    return true;
                }
            }
        }
        return false;
    }
}
