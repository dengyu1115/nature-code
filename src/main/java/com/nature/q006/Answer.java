package com.nature.q006;

public class Answer {

    private final String s;

    private final int h;
    private final int i;
    private final int left;
    private final int n;

    private String r = "";

    public Answer(String s, int h) {
        this.s = s;
        this.h = h;
        int l = s.length();
        this.i = 2 * h - 2;
        int left = l % i;
        this.n = left == 0 ? l / i : l / i + 1;
        this.left = left == 0 ? i : left;
    }

    public String solute() {
        this.rowFirst();
        this.rowElse();
        this.rowLast();
        return r;
    }

    private void rowLast() {
        if (left < h) {
            for (int j = 0; j < n - 1; j++) {
                r += s.charAt(j * i + h - 1);
            }
        } else {
            for (int j = 0; j < n; j++) {
                r += s.charAt(j * i + h - 1);
            }
        }
    }

    private void rowElse() {
        for (int j = 1; j < h - 1; j++) {
            int st = 0;
            int m = 0;
            if (left <= j) {
                m = 2 * (n - 1);
            } else if (left < h || left + j <= i) {
                m = 2 * n - 1;
            } else if (left + j > i) {
                m = 2 * n;
            }
            for (int k = 0; k < m; k++) {
                boolean b = k % 2 == 0;
                int idx = b ? st * i + j : st * i - j;
                r += s.charAt(idx);
                if (b) {
                    st++;
                }
            }
        }
    }

    private void rowFirst() {
        for (int j = 0; j < n; j++) {
            r += s.charAt(j * i);
        }
    }

    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        int h = 5;
        System.out.println(new Answer(s, h).solute());
    }

}
