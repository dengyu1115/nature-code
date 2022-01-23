package com.nature.q013;

import java.util.HashMap;
import java.util.Map;

public class Answer {

    public static final Map<String, Integer> MAP = new HashMap<>();

    static {
        MAP.put("I", 1);
        MAP.put("V", 5);
        MAP.put("X", 10);
        MAP.put("L", 50);
        MAP.put("C", 100);
        MAP.put("D", 500);
        MAP.put("M", 1000);
        MAP.put("IV", 4);
        MAP.put("IX", 9);
        MAP.put("XL", 40);
        MAP.put("XC", 90);
        MAP.put("CD", 400);
        MAP.put("CM", 900);
    }

    private int num;

    private final String str;

    public Answer(String str) {
        this.str = str;
    }

    public void solute() {
        int i = 0;
        for (; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            char n = str.charAt(i + 1);
            Integer r = MAP.get(c + "" + n);
            if (r != null) {
                num += r;
                i++;
            } else {
                r = MAP.get("" + c);
                if (r == null) {
                    throw new IllegalArgumentException(str);
                }
                num += r;
            }
        }
        if (i == str.length() - 1) {
            char c = str.charAt(str.length() - 1);
            Integer r = MAP.get("" + c);
            if (r == null) {
                throw new IllegalArgumentException(str);
            }
            num += r;
        }
        System.out.println(num);
    }


    public static void main(String[] args) {
        new Answer("MCMXCIV").solute();
    }


}
