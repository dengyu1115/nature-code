package com.nature.q010;

import java.util.ArrayList;
import java.util.List;

public class Grouper {

    private final String regex;

    public Grouper(String regex) {
        this.regex = regex;
    }

    public List<String> group() {
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        Character pre = null;
        for (int i = 0; i < regex.length(); i++) {
            char c = regex.charAt(i);
            if (pre == null && c == '*') {
                throw new RuntimeException("illegal");
            }
            if (pre != null && (pre == '.' && c != '*' && c != '.' || pre == '*' && c != '*')) {
                list.add(builder.toString());
                builder = new StringBuilder();
            }
            builder.append(c);
            pre = c;
        }
        String regex = builder.toString();
        list.add(regex);
        return list;
    }
}
