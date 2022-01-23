package com.nature.q011;

import java.util.HashMap;
import java.util.Map;

public class Answer {

    private final int[] arr;

    private int r;

    public Answer(int[] arr) {
        this.arr = arr;
    }

    public void solute() {
        Map<Integer, Integer> map = new HashMap<>();
        int km = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int k = entry.getKey();
                int v = entry.getValue();
                int temp = (i - v) * Math.min(num, k);
                if (temp > r) {
                    r = temp;
                }
            }
            if (km < num) {
                km = num;
                map.putIfAbsent(num, i);
            }
        }
        System.out.println(map);
        System.out.println(r);
    }

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        new Answer(new int[]{5, 1, 2, 3, 4, 5, 2, 3, 1, 6, 5}).solute();
        System.out.println(System.currentTimeMillis() - s);
    }

}
