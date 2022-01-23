package com.nature.q015;

import java.util.*;

public class Answer {

    private final int[] arr;

    private final Set<Arr> rs;

    public Answer(int[] arr) {
        this.arr = arr;
        this.rs = new HashSet<>();
    }

    public void solute() {
        System.out.println(Arrays.toString(arr));
        Map<Integer, Integer> mapCount = new HashMap<>();
        Map<Integer, Set<Arr>> map = new HashMap<>();
        for (int i : arr) {
            Set<Arr> ints = map.get(i);
            if (ints != null) {
                for (Arr is : ints) {
                    int a = is.getArr()[0];
                    int b = is.getArr()[1];
                    if (i < a) {
                        rs.add(new Arr(i, a, b));
                    } else if (i > b) {
                        rs.add(new Arr(a, b, i));
                    } else {
                        rs.add(new Arr(a, i, b));
                    }
                }
            }
            Integer count = mapCount.get(i);
            if (count == null) {
                mapCount.put(i, 1);
                for (Integer num : mapCount.keySet()) {
                    int r = -(num + i);
                    Set<Arr> set = map.computeIfAbsent(r, k -> new HashSet<>());
                    if (num > i) {
                        set.add(new Arr(i, num));
                    } else {
                        set.add(new Arr(num, i));
                    }
                }
            } else if (count == 1) {
                mapCount.put(i, 2);
                Set<Arr> set = map.computeIfAbsent(-(i + i), k -> new HashSet<>());
                set.add(new Arr(i, i));
            }
        }
        System.out.println(rs);
    }

    public static void main(String[] args) {
        new Answer(new int[]{-3, -1, 0, 1, 2, 3}).solute();
    }

    private static class Arr {

        private final int[] arr;

        public Arr(int... arr) {
            this.arr = arr;
        }

        public int[] getArr() {
            return arr;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Arr arr1 = (Arr) o;
            return Arrays.equals(arr, arr1.arr);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }

        @Override
        public String toString() {
            return Arrays.toString(arr);
        }
    }
}
