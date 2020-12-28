package com.karczmarzyk.advent2020.day18;

public class Operator {


    public static long getParentheses(String in) {
        if(!in.contains("(")){
            return evaluateExpressionAdv(in);
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
            sb.append(in, 0, start)
              .append(evaluateExpressionAdv(in.substring(start + 1, end)))
              .append(in.substring(end+1));
            return getParentheses(sb.toString());
        }
    }

    //without parentheses
    public static long evaluateExpression(String in) {
        if(in.length()==1){
            return Long.parseLong(in);
        }
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

    public static long evaluateExpressionAdv(String in) {
        if(in.contains("+")){
            String[] s = in.split(" \\* ");
            long sum = 1;
            for (int i = 0; i < s.length; i ++) {
                sum*=evaluateExpression(s[i]);
            }
            return sum;
        }else{
            return evaluateExpression(in);
        }
    }

    private static long evaluateAdding(long a, long b) {
        return a + b;
    }

    private static long evaluateMulti(long a, long b) {
        return a * b;
    }
}
