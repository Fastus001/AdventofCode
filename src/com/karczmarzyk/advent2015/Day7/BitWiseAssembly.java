package com.karczmarzyk.advent2015.Day7;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BitWiseAssembly {
    public static final Pattern NUM = Pattern.compile("\\d+");
    public static ArrayList<ArrayList<String>>BOOK = new ArrayList<>();
    public static HashMap<String, IntBinaryOperator> operatorMap = new HashMap<>();
    public static ArrayList<Wire> wiresList = new ArrayList<>();


    public static int twoBytesConcate(int a, int b)
    {
        return ((a << 8) | (b & 0xFF));
    }

    public static void getInput(ArrayList<String> l)
    {
        try(var in = new Scanner(new File("src/com/karczmarzyk/advent2015/resources/bitwise.txt")))
        {
            while(in.hasNext())
            {
                String[] line = in.nextLine().split("\\s+");
                var temp = new ArrayList<String>();
                Collections.addAll(temp, line);
                BOOK.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        mappingOperators();
        ArrayList<String> lines = new ArrayList<>();
        getInput(lines);
        for (ArrayList<String> t: BOOK) {
            Wire w = new Wire(t);
            wiresList.add(w);
        }
        for (int i = 0; i < 120; i++) {
            for (Wire w: wiresList) {
                checkSingleSignal(w);
                checkingNOT(w);
                checkingRSHIFT(w);
                checkingLeftSHIFT(w);
                if(w.data.size()>1 && w.data.get(1).equals("AND"))
                    andOrOperator(w,"AND");
                if(w.data.size()>1 && w.data.get(1).equals("OR"))
                    andOrOperator(w,"OR");
            }
        }

        List<Wire> a = wiresList.stream()
                .filter(wire -> wire.getIdentifier().equals("a"))
                .collect(Collectors.toList());


        System.out.println("a = " + a);

        long count = wiresList.stream().filter(Wire::isHasSignal).count();
        System.out.println("lines = " + count);
        short t = -25381;
        int test = t;

        System.out.println("test = " + test);
        for (int i = 0; i <= 16; i++) {
            test &= ~(1<<(32-i));
        }
        System.out.println("Integer.toBinaryString(test) = " + Integer.toBinaryString(test));
        System.out.println("test = " + test);

        int x = 123;
        int h = ~x;
        System.out.println("h = " + h);
        int testNow = ~h;
        System.out.println( "testNow = " + testNow );
        for (int i = 0; i <= 16; i++) {
            h &= ~(1 << (32 - i));
        }


        System.out.println("Integer.toBinaryString(test) = " + Integer.toBinaryString(test));
    }

    private static void andOrOperator(Wire w, String andOr) {
        boolean first = false;
        boolean second = false;
        String a = w.data.get(0);
        String b = w.data.get(2);
        int numA = 0;
        int numB = 0;
        for(Wire find:wiresList)
        {
            if(find.getIdentifier().equals(a) && find.isHasSignal())
            {
                numA = find.giveSignal();
                first = true;
            }
            if(find.getIdentifier().equals(b) && find.isHasSignal())
            {
                numB = find.giveSignal();
                second = true;
            }
        }
        if(numA == 0)
        {
            if(w.data.get(0).matches("1"))
            {
                numA = Integer.parseInt(w.data.get(0));
                first = true;
//                System.out.println("numA = " + numA + " B " + numB);
            }
        }
        if(first && second)
        {
            if(andOr.equals("AND"))
                w.setSignal(numA & numB);
            if(andOr.equals("OR"))
                w.setSignal(numA | numB);
        }

    }

    private static void checkingLeftSHIFT(Wire w) {
        if(w.data.size()>1 && w.data.get(1).equals("LSHIFT"))
        {
            String a = w.data.get(0);
            int b = Integer.parseInt(w.data.get(2));
            int num = 0;
            for(Wire find:wiresList)
            {
                if(find.getIdentifier().equals(a) && find.isHasSignal())
                {
                    num = find.giveSignal();
                    w.setSignal((num<<b));
                }
            }
        }

    }

    private static void checkingRSHIFT(Wire w) {
        if(w.data.size()>1 && w.data.get(1).equals("RSHIFT"))
        {
            String a = w.data.get(0);
            int  b = Integer.parseInt(w.data.get(2));
            int num = 0;
            for(Wire find:wiresList)
            {
                if(find.getIdentifier().equals(a) && find.isHasSignal())
                {
                    num = find.giveSignal();
                    w.setSignal((num>>b));
                }
            }
        }
    }

    private static void checkingNOT(Wire w) {
        if(w.data.get(0).equals("NOT"))
        {
            String b = w.data.get(1);
            int num = 0;
            for(Wire find:wiresList)
            {
                if(find.getIdentifier().equals(b) && find.isHasSignal())
                {
                    num = find.giveSignal();
                    w.setSignal(~num);
                }
            }
        }
    }


    private static void checkSingleSignal(Wire w) {
        if(w.getDataSize()==1 && !w.isHasSignal())
        {
            String s = w.data.get(0);
            if(NUM.matcher(s).find())
                w.setSignal(Integer.parseInt(s));
            else if(s.equals("lx"))
            {
                for(Wire wire:wiresList)
                    if(wire.getIdentifier().equals(s) && wire.isHasSignal())
                    {
                        int num = wire.giveSignal();
                        w.setSignal(num);
                    }
            }

        }
    }

    private static void mappingOperators() {
        operatorMap.put("AND",(a,b)->a & b);
        operatorMap.put("NOT",(a,b)->~b);
        operatorMap.put("RSHIFT",(a,b)->a>>b);
        operatorMap.put("OR",(a,b)->a | b);
        operatorMap.put("LSHIFT",(a,b)->a << b);
        operatorMap.put("->",(a,b)->a);
    }

}

class Wire
{
    private final String identifier;
    private int signal;
    private boolean hasSignal;
    public ArrayList<String> data;

    Wire(ArrayList<String> data)
    {
        this.identifier = data.get(data.size()-1);
        data.remove(data.size()-1);
        data.remove(data.size()-1);
        this.data = data;
        this.hasSignal = false;
    }

    public void setSignal(int signal)
    {
        this.signal = signal;
        this.hasSignal = true;
    }

    public int giveSignal()
    {
        return signal;
    }

    public boolean isHasSignal() {
        return hasSignal;
    }

    public int getDataSize(){return this.data.size();}

    public String getIdentifier() {
        return identifier;
    }

    public void setHasSignal(boolean hasSignal) {
        this.hasSignal = hasSignal;
    }

    @Override
    public String toString() {
        return "Wire{" +
                "identifier='" + identifier + '\'' +
                ", signal=" + signal +
                ", hasSignal=" + hasSignal +
                ", data=" + data +
                '}';
    }
}
