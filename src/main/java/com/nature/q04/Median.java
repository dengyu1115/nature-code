package com.nature.q04;

public class Median {

    public static void main(String[] args) {
        double[] aa = new double[]{1, 5, 7, 15, 18, 30, 51, 55, 59, 70};
        double[] bb = new double[]{6, 9, 10, 20, 50, 52, 55, 70, 100, 105, 110, 130, 150, 160, 165, 166, 170};
        System.out.println(median(aa, bb));
        System.out.println(halfSearch(aa, bb));
    }

    private static double median(double[] aa, double[] bb) {
        if (aa.length == 0 && bb.length == 0) {
            return 0d;
        }
        if (aa.length == 0) {
            return median(bb);
        }
        if (bb.length == 0) {
            return median(aa);
        }
        return simple(aa, bb);
    }

    private static double simple(double[] aa, double[] bb) {
        int i = 0, j = 0;
        int l = aa.length + bb.length;
        boolean ib = l % 2 == 0;
        l = l / 2 + 1;
        double[] arr = new double[l];
        while (true) {
            if (i + j == l) {
                return ib ? (arr[i + j - 2] + arr[i + j - 1]) / 2d : arr[i + j - 1];
            } else if (i == aa.length) {
                arr[i + j] = bb[j++];
            } else if (j == bb.length) {
                arr[i + j] = aa[i++];
            } else {
                double a = aa[i];
                double b = bb[j];
                if (a <= b) {
                    arr[i + j] = a;
                    i++;
                } else {
                    arr[i + j] = b;
                    j++;
                }
            }
        }
    }

    private static double median(double[] arr) {
        int l = arr.length;
        if (l % 2 == 0) {
            return (arr[l / 2 - 1] + arr[l / 2]) / 2d;
        }
        return arr[l / 2];
    }

    private static double halfSearch(double[] aa, double[] bb) {
        int al = aa.length, bl = bb.length;
        if (al > bl) {
            return halfSearch(bb, aa);
        }
        if (aa[al - 1] <= bb[0]) {
            return extreme(aa, bb);
        }
        if (bb[bl - 1] <= aa[0]) {
            return extreme(bb, aa);
        }
        int s = 0, e = aa.length - 1, i = (al + 1) / 2 + 1, j = (bl + 1) / 2 - 1;
        boolean ib = (al + bl) % 2 == 0;
        while (true) {
            double a = i == 0 ? bb[j - 1] : Math.max(aa[i - 1], bb[j - 1]),
                    b = i == al ? bb[j] : Math.min(aa[i], bb[j]);
            if (a <= b) {
                return ib ? (a + b) / 2 : a;
            }
            if (aa[i - 1] > bb[j]) {
                e = i;
                int idx = (s + i) / 2;
                i = idx == i ? i - 1 : idx;
                j = j + (e - i);
            } else {
                s = i;
                int idx = (e + i) / 2;
                i = idx == i ? i + 1 : idx;
                j = j + (s - i);
            }
        }
    }

    private static double extreme(double[] aa, double[] bb) {
        int al = aa.length, bl = bb.length;
        if (al == bl) {
            return (aa[al - 1] + bb[0]) / 2d;
        }
        boolean ib = (al + bl) % 2 == 0;
        if (al < bl) {
            return ib ? (aa[al - (al + bl) / 2 - 1] + aa[al - (al + bl) / 2]) / 2d : aa[al - (al + bl) / 2 - 1];
        }
        return ib ? (bb[bl - (al + bl) / 2 - 1] + bb[bl - (al + bl) / 2]) / 2d : bb[bl - (al + bl) / 2 - 1];
    }

}
