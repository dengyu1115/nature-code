package com.nature.q014;

public class Answer {

    private String r;

    private final String[] arr;

    public Answer(String[] arr) {
        this.arr = arr;
        this.r = "";
    }

    public void solute() {
        int length = this.min();
        for (int i = 0; i < length; i++) {
            char c = arr[0].charAt(i);
            boolean eq = true;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j].charAt(i) != c) {
                    eq = false;
                    break;
                }
            }
            if (!eq) {
                break;
            }
            r += c;
        }
        System.out.println(r);
    }

    private int min() {
        int min = arr[0].length();
        for (int i = 1; i < arr.length; i++) {
            int l = arr[i].length();
            if (l < min) {
                min = l;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        new Answer(new String[]{"MCMXCIV", "AMC", "MCMddd"}).solute();
    }


}
