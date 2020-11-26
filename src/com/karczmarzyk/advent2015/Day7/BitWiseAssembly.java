package com.karczmarzyk.advent2015.Day7;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BitWiseAssembly {
    public static final Pattern NUM = Pattern.compile("\\d+");
    public static ArrayList<ArrayList<String>>BOOK = new ArrayList<>();
    public static HashMap<String, IntBinaryOperator> operatorMap = new HashMap<>();
    public static ArrayList<Wire> wiresList = new ArrayList<>();

    public static void getInput()
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
        getInput();
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
                if(w.dataSize()>1 && w.dataGet(1).equals("AND"))
                    andOrOperator(w,true);
                if(w.dataSize()>1 && w.dataGet(1).equals("OR"))
                    andOrOperator(w,false);
            }
        }

        List<Wire> a = wiresList.stream()
                .filter(wire -> wire.getIdentifier().equals("a"))
                .collect(Collectors.toList());


        System.out.println("a = " + a);

    }

    private static void andOrOperator(Wire w, boolean and) {
        boolean first = false;
        boolean second = false;
        int numA = 0;
        int numB = 0;
        for(Wire find:wiresList)
        {
            if(find.getIdentifier().equals(w.dataGet(0)) && find.hasSignal())
            {
                numA = find.giveSignal();
                first = true;
            }
            if(find.getIdentifier().equals(w.dataGet(2)) && find.hasSignal())
            {
                numB = find.giveSignal();
                second = true;
            }
        }
        if(numA == 0)
        {
            if(w.dataGet(0).matches("\\d+"))
            {
                numA = Integer.parseInt(w.dataGet(0));
                first = true;
            }
        }
        if(first && second)
        {
            if(and)
                w.setSignal(numA & numB);
            else
                w.setSignal(numA | numB);
        }
    }

    private static void checkingLeftSHIFT(Wire w) {
        if(w.dataSize()>1 && w.dataGet(1).equals("LSHIFT"))
            insideJob( w,true );
    }

    private static void checkingRSHIFT(Wire w) {
        if(w.dataSize()>1 && w.dataGet(1).equals("RSHIFT"))
            insideJob( w,false );
    }

    private static void insideJob(Wire w, boolean lShift)
    {
        for(Wire find:wiresList)
        {
            if(find.getIdentifier().equals(w.dataGet(0)) && find.hasSignal())
            {
                int  b = Integer.parseInt(w.dataGet(2));
                int num = find.giveSignal();
                if(lShift)
                    w.setSignal((num<<b));
                else
                    w.setSignal((num>>b));
            }
        }
    }

    private static void checkingNOT(Wire w) {
        if(w.dataGet(0).equals("NOT"))
        {
            String b = w.dataGet(1);
            for(Wire find:wiresList)
            {
                if(find.getIdentifier().equals(b) && find.hasSignal())
                {
                    int num = find.giveSignal();
                    w.setSignal(~num);
                }
            }
        }
    }

    private static void checkSingleSignal(Wire w) {
        if(w.getDataSize()==1 && !w.hasSignal())
        {
            String s = w.dataGet(0);
            if(NUM.matcher(s).find())
                w.setSignal(Integer.parseInt(s));
            else if(s.equals("lx"))
            {
                for(Wire wire:wiresList)
                    if(wire.getIdentifier().equals(s) && wire.hasSignal())
                    {
                        w.setSignal(wire.giveSignal());
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

