package com.karczmarzyk.advent2020.day18;

public class Operator {


    public static long getParentheses(String in) {
        if(!in.contains("(")){
            return evaluateExpression(in);
        }else{
            int start = 0;
            int end = 0;
            for (int i = 0; i < in.length(); i++) {
                if (in.charAt(i) == '(') {
                    start = i;
                }
                if (in.charAt(i) == ')') {
                    end = i;
                    break;
                }
            }
            var sb = new StringBuilder();
            sb.append(in, 0, start);
            sb.append(evaluateExpression(in.substring(start + 1, end)));
            sb.append(in.substring(end+1));
            String temp = sb.toString();
            return getParentheses(temp);
        }
    }

    //without parentheses
    public static long evaluateExpression(String in) {
        String[] s = in.split(" ");
        long start = Long.parseLong(s[0]);
        for (int i = 1; i < s.length; i += 2) {
            if (s[i].equals("+")) {
                start = evaluateAdding(start, Long.parseLong(s[i + 1]));
            } else {
                start = evaluateMulti(start, Long.parseLong(s[i + 1]));
            }
        }
        return start;
    }

    private static long evaluateAdding(long a, long b) {
        return a + b;
    }

    private static long evaluateMulti(long a, long b) {
        return a * b;
    }
}
