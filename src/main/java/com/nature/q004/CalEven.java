package com.nature.q004;

public class CalEven {

    private final double[] arrA, arrB;
    private final int lenA, lenB, lenTotal;
    private int idxA, idxB, start, end;

    public CalEven(double[] arrA, double[] arrB) {
        this.arrA = arrA;
        this.arrB = arrB;
        this.lenA = this.arrA.length;
        this.lenB = this.arrB.length;
        this.lenTotal = this.lenA + this.lenB;
    }

    public double calculate() {
        if (arrA[this.lenA - 1] <= arrB[0]) {
            int idx = lenB - lenTotal / 2 - 1;
            return ((idx == -1 ? arrA[lenA - 1] : arrB[idx]) + arrB[lenB - lenTotal / 2]) / 2d;
        } else if (arrA[0] >= arrB[lenB - 1]) {
            int idx = lenTotal / 2;
            return (arrB[lenTotal / 2 - 1] + (idx == lenB ? arrA[0] : arrB[idx])) / 2d;
        } else {
            this.start = 0;
            this.end = lenA;
            this.idxA = this.start;
            this.idxB = lenA + (lenB - lenA) / 2;
            return this.doFind(false);
        }
    }

    private double doFind(boolean left) {
        int idxA;
        if (left) {
            idxA = (this.idxA - 1 + start) / 2;
            if (idxA == this.idxA) {
                idxA = this.idxA - 1;
            }
        } else {
            idxA = (this.idxA + 1 + end) / 2;
            if (idxA == this.idxA) {
                idxA = this.idxA + 1;
            }
        }
        int move = this.idxA - idxA;
        this.idxA = idxA;
        this.idxB = this.idxB + move;
        if (this.idxA > 0 && arrA[this.idxA - 1] > arrB[this.idxB]) {
            this.end = idxA;
            return this.doFind(true);
        } else if (this.idxA < lenA - 1 && arrA[this.idxA] < arrB[this.idxB - 1]) {
            this.start = idxA;
            return this.doFind(false);
        } else if (this.idxA == lenA - 1) {
            return (Math.max(arrA[idxA], arrB[this.idxB - 1]) + arrB[idxB]) / 2d;
        } else if (this.idxA == 0) {
            return (arrB[this.idxB - 1] + Math.min(arrA[idxA], arrB[idxB])) / 2d;
        } else {
            return (Math.max(arrA[idxA - 1], arrB[this.idxB - 1]) + Math.min(arrA[idxA], arrB[idxB])) / 2d;
        }
    }
}
