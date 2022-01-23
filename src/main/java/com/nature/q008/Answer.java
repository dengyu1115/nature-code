package com.nature.q008;

public class Answer {

    private final String s;

    private long r;

    public Answer(String s) {
        this.s = s;
    }

    public void solute() {
        char symbol = '0';
        int st = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (c == '-') {
                    symbol = '-';
                    st = i + 1;
                } else if (c == '+') {
                    symbol = '+';
                    st = i + 1;
                } else {
                    symbol = '+';
                    st = i;
                }
                break;
            }
        }
        if (symbol != '0') {
            for (int i = st; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    if (r != 0) {
                        r *= 10;
                    }
                    r += c - 48;
                    if (symbol == '+' && r > Integer.MAX_VALUE) {
                        r = Integer.MAX_VALUE;
                        break;
                    } else if (-r < Integer.MIN_VALUE) {
                        r = Integer.MAX_VALUE;
                        r++;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(r);
    }

    public static void main(String[] args) {
        String s = " -1234332518059348 abc";
        new Answer(s).solute();
    }

}
