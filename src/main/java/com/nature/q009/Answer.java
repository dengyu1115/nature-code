package com.nature.q009;

import java.util.Arrays;

public class Answer {

    private final int n;


    public Answer(int n) {
        this.n = n;
    }

    public void solute() {
        System.out.println(this.isIso(this.n));
    }

    private boolean isIso(int n) {
        if (n < 0) {
            return false;
        }
        int m = n;
        int len = 0;
        do {
            m /= 10;
            len++;
        } while (m > 0);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[len - i - 1] = n % 10;
            n /= 10;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 12321;
        new Answer(n).solute();
    }

}
