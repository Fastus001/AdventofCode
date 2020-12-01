package com.karczmarzyk.advent2016.day5;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MdDecipher {
    private final MessageDigest md = MessageDigest.getInstance( "MD5");
    private final String doorId;
    private long number = 0;

    public MdDecipher(String doorId) throws NoSuchAlgorithmException {
        this.doorId = doorId;
    }

    //rest 5 digits are 0..
    //needs to check if the hash string is not shorter that 27 digits,
    public String generateHash() throws UnsupportedEncodingException {
        String result = "";
        do{
            String in = doorId+number;
            byte[] theDigest = md.digest(in.getBytes("UTF-8"));
            BigInteger bigInt = new BigInteger( 1, theDigest);
            result = bigInt.toString(16);
            if(result.length()<27)
                return "0";
            number++;
        }while(result.length()!=27);
        return result.substring( 0,1 );
    }

    public String getPassword() throws UnsupportedEncodingException {
        var sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append( generateHash() );
        }
        return sb.toString();
    }
}
