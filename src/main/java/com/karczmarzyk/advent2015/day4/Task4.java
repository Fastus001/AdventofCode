package com.karczmarzyk.advent2015.day4;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task4 {

    public Task4() {
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String secretKey = "iwrupvqb";
        String hashtext = "";
        String message = "";
        int number = 0;
        do {
            message  = secretKey+number;
            byte[] bytesOfMessage = message.getBytes("UTF-8");
            byte[] theDigest = md.digest(bytesOfMessage);
            BigInteger bigInt = new BigInteger(1,theDigest);
            hashtext = bigInt.toString(16);

            number++;
        }while(hashtext.length()!=26);
        System.out.println("message = " + message);
        System.out.println("hashtext = " + hashtext);
        System.out.println("hashtext.length() = " + hashtext.length());


    }
}
