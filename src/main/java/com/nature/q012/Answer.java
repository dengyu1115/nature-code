package com.nature.q012;

public class Answer {

    public static final char[] CS = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};

    private int num;

    private final StringBuilder builder;

    public Answer(int num) {
        this.num = num;
        this.builder = new StringBuilder();
    }

    public void solute() {
        this.thousand(this.num / 1000);
        int scale = 100;
        for (int i = 5; i > 0; i -= 2) {
            this.calculate(this.num / scale, i);
            this.num %= scale;
            scale /= 10;
        }
        System.out.println(builder);
    }

    private void thousand(int num) {
        if (num > 0) {
            for (int j = 0; j < num; j++) {
                builder.append('M');
            }
            this.num %= 1000;
        }
    }

    private void calculate(int num, int idx) {
        if (num == 9) {
            builder.append(CS[idx - 1]).append(CS[idx + 1]);
        } else if (num == 4) {
            builder.append(CS[idx - 1]).append(CS[idx]);
        } else {
            if (num >= 5) {
                builder.append(CS[idx]);
                num %= 5;
            }
            if (num > 0) {
                for (int i = 0; i < num; i++) {
                    builder.append(CS[idx - 1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        for (int i = 1; i < 4000; i++) {
            new Answer(i).solute();
        }
        System.out.println(System.currentTimeMillis() - s);
    }

}
