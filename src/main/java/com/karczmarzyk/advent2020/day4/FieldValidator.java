package com.karczmarzyk.advent2020.day4;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class FieldValidator {
    private static final Pattern CM = Pattern.compile( "\\d{3}cm" );
    private static final Pattern INCH = Pattern.compile( "\\d{2}in" );
    private static final Pattern HAIR = Pattern.compile( "#[a-f,0-9]{6}" );
    private static final Pattern ID = Pattern.compile( "\\d{9}" );
    private static final List<String> EYES = Arrays.asList( "amb","blu","brn","gry","grn","hzl","oth" );

    public boolean idValidate(String[] pid)
    {
        return ID.matcher( pid[1] ).matches();
    }

    public boolean eyesValidate(String[] ecl){
        for(String icl:EYES)
        {
            if(ecl[1].equals( icl ))
                return true;
        }
        return false;
    }

    public boolean hairColorValidate(String[] hcl)
    {
        return HAIR.matcher( hcl[1] ).matches();
    }

    public boolean heightValidate(String[] hgt)
    {
        if(CM.matcher( hgt[1] ).find())
        {
            int cm = Integer.parseInt( hgt[1].substring( 0,3 ));
            return cm>=150 && cm <=193;
        }else if(INCH.matcher( hgt[1] ).find()){
            int cm = Integer.parseInt( hgt[1].substring( 0,2 ));
            return cm>=59 && cm <=76;
        }
        return false;
    }

    public boolean birthdayValidate(String[] byr)
    {
        int year = Integer.parseInt( byr[1] );

        return year >= 1920 && year <= 2002;
    }

    public boolean issueYearValidate(String[] iyr)
    {
        int year = Integer.parseInt( iyr[1] );

        return year >= 2010 && year <= 2020;
    }

    public boolean expirationYearValidate(String[] exp)
    {
        int year = Integer.parseInt( exp[1] );

        return year >= 2020 && year <= 2030;
    }
}
