package com.karczmarzyk.advent2015.day25;

public class ArrayFill {
//    private static final long[][] tab = new long[10][10];
    private static final int ROW = 3010;
    private static final int COL = 3019;
    private static int counter = 1;
    private long result = 0;

    public void fillFirstTen()
    {
//      tab[0][0] = 20151125;
      long temp = 20151125;
        int i = 1;
        while(true)
        {
            int x = 0;
            for (int j = i; j >=0 ; j--,x++) {
                temp =getResult( temp );
//                temp = tab[j][x];
                if(j == ROW-1 && x == COL-1 )
                {
                    result = temp;
                    return;
                }
            }
            i++;
        }
    }

    public long getResult(long number)
    {
        return (number*252533)%33554393;
    }

    public int getCounterNumber() {
        return counter;
    }

    public long getResult()
    {
        return result;
    }

//    public void showTab()
//    {
//        for (long[] longs : tab) {
//            System.out.println( "tab = " + Arrays.toString( longs ) );
//        }
//    }
}
