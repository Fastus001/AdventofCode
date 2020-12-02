package com.karczmarzyk.advent2016.day5;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class MdPartTwo{
    private static final Pattern PATTERN = Pattern.compile( "[1-7]" );
    private final MessageDigest md = MessageDigest.getInstance( "MD5");
    private final String doorId;
    private long number = 0;
    private boolean isZero = false;

    public MdPartTwo(String doorId) throws NoSuchAlgorithmException {
        this.doorId = doorId;
    }

    public Pair generateHash() {
        String result;
        do{
            String in = doorId+number;
            byte[] theDigest = md.digest(in.getBytes( StandardCharsets.UTF_8 ));
            BigInteger bigInt = new BigInteger( 1, theDigest);
            result = bigInt.toString(16);
            if(!isZero){
                if(result.length()<27){
                    isZero = true;
                    if(result.length()==26)
                        return new Pair( 0, result.substring( 0, 1 ) );
                    else
                        return new Pair( 0, "0" );
                }
            }
            number++;
        }while(result.length()!=27);
        String substring = result.substring( 0, 1 );
        if(PATTERN.matcher( substring ).find())
        {
            int num = Integer.parseInt(substring);
            return new Pair( num, result.substring( 1, 2 ) );
        }else{
            return generateHash();
        }
    }

    public String generatePassword()
    {
        int counter = 0;
        Pair[] tab = new Pair[8];
        while(counter<8)
        {
            var pair = generateHash();
            if(tab[pair.num] == null){
                tab[pair.num] = pair;
                counter++;
            }
        }
        var sb = new StringBuilder();
        for (Pair pair : tab) {
            sb.append( pair.text );
        }
        return sb.toString();
    }

    private static class Pair
    {
        private final int num;
        private final String text;

        public Pair(int num, String text) {
            this.num = num;
            this.text = text;
        }
    }

}

