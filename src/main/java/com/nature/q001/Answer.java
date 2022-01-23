package com.nature.q001;

import java.util.HashMap;
import java.util.Map;

public class Answer {

    private int[] nums;

    private int target;

    private Integer start, end;

    public Answer(int target, int... nums) {
        this.target = target;
        this.nums = nums;
    }

    public void solute() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int n = this.target - num;
            Integer idx = map.get(n);
            if (idx == null) {
                map.put(num, i);
            } else {
                this.start = idx;
                this.end = i;
                break;
            }
        }
        System.out.println("start:" + this.start + " end:" + this.end);
    }

    public static void main(String[] args) {
        new Answer(9, 1, 2, 3, 4, 5, 6, 7, 8).solute();
    }
}
