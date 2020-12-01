package com.karczmarzyk.advent2016.day4;

public class RoomCipher extends Room {

    public RoomCipher(String input) {
        super( input );
    }

    public String decipher() {
        int move = Integer.parseInt( super.getInput( 1 ) ) % 26;
        char[] chars = super.getInput( 0 ).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ( chars[i] == '-' ) {
                chars[i] = 32;
            }
            else {
                chars[i] += move;
                if ( chars[i] > 122 ) {
                    chars[i] -= 26;
                }
            }
        }
        return new String( chars );
    }

}
