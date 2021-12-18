package com.nature.q10;

public class Answer {

    private final String s;

    private final String p;

    public Answer(String s, String p) {
        this.s = s;
        this.p = p;
    }

    public void solute() {
        System.out.println(new Matcher(s, new Grouper(p).group()).match());
    }

    public static void main(String[] args) {
        String s = "abcdeaaaabacaaabbb", p = "abcd.*...................a*aa**b**b....";
        new Answer(s, p).solute();
    }
}
