package com.nature.q003;

import java.util.HashMap;
import java.util.Map;

public class Answer {

    private String s;

    private String sub;

    private int start, end;

    public Answer(String s) {
        this.s = s;
    }

    public void solute() {
        Map<Character, Integer> map = new HashMap<>();
        do {
            char c = s.charAt(end);
            Integer idx = map.get(c);
            if (idx != null && idx >= start) {
                if (sub == null || end - start > sub.length()) {
                    sub = s.substring(start, end);
                }
                start = idx + 1;
            }
            map.put(c, end);
            end++;
            if (end == s.length()) {
                if (sub == null) {
                    sub = s;
                }
                break;
            }
        } while (sub == null || sub.length() < s.length() - end);
        System.out.println(end - start);
        System.out.println(sub);
    }

    public static void main(String[] args) {
        new Answer("123456789").solute();
    }

}
