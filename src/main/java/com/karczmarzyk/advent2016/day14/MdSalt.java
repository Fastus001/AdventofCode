package com.karczmarzyk.advent2016.day14;

import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MdSalt {
    private static final Pattern THREE_SAME = Pattern.compile( "(.)\\1\\1" );
    private final String salt;
    private int number = 0;
    private List<String> keys = new ArrayList<>();

    public MdSalt(String salt) {
        this.salt = salt;
    }


    public int start() throws NoSuchAlgorithmException {
        do{
            String hash = generateHash( salt + number );

            if( checkHash( hash )){
                String temp = getMatchingString( hash );
                if(nextThousand( salt,temp,number )){
                    keys.add( hash );
                }
            }
            if(keys.size()==64){
                return number;
            }
            number++;
        }while (keys.size()<64);
        return number;
    }

    @NotNull
    private String getMatchingString(String hash) {
        int index = getIndexOfChars( hash );
        String temp = hash.substring( index, index + 3 );
        temp+=temp.substring( 1 );
        return temp;
    }

    public boolean nextThousand(String salt, String chars, int number){
        for (int i = number+1; i <=1000+number ; i++) {
            String s = generateHash( salt + i);
            if(s.contains( chars )){
                return true;
            }
        }
        return false;
    }

    public String generateHash(String hash){
            return DigestUtils.md5Hex( hash );
    }

    public String generateHash(String hash, int times){
        String digest = DigestUtils.md5Hex( hash );
        if(times>0){
            return generateHash( digest,times-1 );
        }else{
            return digest;
        }
    }


    public boolean checkHash(String hash){
        return THREE_SAME.matcher( hash ).find();
    }

    public int getIndexOfChars(String hash){
        Matcher matcher = THREE_SAME.matcher(hash);
        matcher.find();
        return matcher.start();

    }

}
