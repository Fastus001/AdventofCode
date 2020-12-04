package com.karczmarzyk.advent2020.day4;

import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.*;

public class PassportValidator {
    private static final Pattern PATTERN = Pattern.compile( "\\s+" );

    //part 1
    public static boolean validate(String inputData) {
        final List<String> collect = PATTERN
                .splitAsStream( inputData )
                .collect( toList() );
        if ( collect.size() == 8 )
            return true;
        else {
            if ( collect.size() == 7 && inputData.contains( "cid:" ) )
                return false;
            return collect.size() == 7 && !inputData.contains( "cid:" );
        }
    }


    public static boolean validateData(String record) {
        FieldValidator validator = new FieldValidator();
        String[] split = record.split( ":" );
        switch (record.substring( 0, 3 )) {
            case "byr":
                return validator.birthdayValidate( split );
            case "iyr":
                return validator.issueYearValidate( split );
            case "eyr":
                return validator.expirationYearValidate( split );
            case "hgt":
                return validator.heightValidate( split );
            case "hcl":
                return validator.hairColorValidate( split );
            case "ecl":
                return validator.eyesValidate( split );
            case "pid":
                return validator.idValidate( split );
        }
        return true;
    }

    public static boolean validatePartTwo(String inputData) {
        final List<String> collect = PATTERN
                .splitAsStream( inputData )
                .collect( toList() );
        if ( collect.size() == 8 || collect.size() == 7 && !inputData.contains( "cid:" ) ) {
            for (String s : collect) {
                if ( !validateData( s ) )
                    return false;
            }
            return true;
        }
        else {
            return false;
        }
    }
}
