package com.nature.q05;

public class Answer {

    private final String s;

    private String sub;

    public Answer(String s) {
        this.s = s;
        this.sub = "";
    }

    public void solute() {
        int l = 0;
        for (int i = 1; i < s.length(); i++) {
            int m = i - 1, n = i;
            char cm = s.charAt(m), cn = s.charAt(n);
            String t = "";
            if (cm == cn) {
                t = cm + t + cn;
            } else {
                m = i;
                t = t + cn;
            }
            StringBuilder builder = new StringBuilder(t);
            while (true) {
                m--;
                n++;
                if (m < 0 || n == s.length()) {
                    break;
                }
                cm = s.charAt(m);
                cn = s.charAt(n);
                if (cm != cn) {
                    break;
                }
                builder = new StringBuilder(cm + builder.toString() + cn);
            }
            t = builder.toString();
            if (t.length() > l) {
                this.sub = t;
                l = t.length();
            }
        }
        System.out.println(this.sub);
    }

    public static void main(String[] args) {
        String s = "abcdefgfedcsfdagsjdlgkhaogidsalkjgdhlsagjsalkbdgiurhgslkndkagdslgjdnajksabcdefghijklmnnmlkjihgfedcba";
        new Answer(s).solute();
    }
}
