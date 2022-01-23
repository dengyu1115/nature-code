package com.nature.q007;

public class Answer {

    private final int n;

    public Answer(int n) {
        this.n = n;
    }

    public void solute() {
        System.out.println(this.reverse(this.n));
    }

    private int reverse(int n) {
        if (n < 0) {
            return -this.reverse(-n);
        }
        int r = 0;
        while (n > 0) {
            if (r > 0) {
                r *= 10;
                if (r < 0) {
                    return 0;
                }
            }
            r += n % 10;
            n /= 10;
        }
        return r;
    }

    public static void main(String[] args) {
        int n = -1234567890;
        new Answer(n).solute();
    }

}
