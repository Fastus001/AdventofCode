package com.karczmarzyk.advent2020.day25;

public class Rfid{
        private static final int DIVIDING = 20201227;

        public int decrypt(long card, long door) {
            long cardLoop = testNumber( card );
            long doorLoop = testNumber( door );

            int encryptionKeyCard = encrypt( card, doorLoop );
            int encryptionKeyDoor = encrypt( door, cardLoop );
            assert encryptionKeyCard==encryptionKeyDoor;
            return encryptionKeyCard;
        }


        public long testNumber(long number) {
            long total = 1;
            for (int j = 1; j < 100_000_000; j++) {
                total = total * 7;
                total %= DIVIDING;
                if ( total == number ) {
                    return j;
                }
            }
            return 0;
        }

        public int encrypt(long number, long loop) {
            long total = 1;
            for (int j = 0; j < loop; j++) {
                total = total * number;
                total = total % DIVIDING;
            }
            return ( int ) total;
        }
}

