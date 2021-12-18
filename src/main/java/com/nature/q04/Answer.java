package com.nature.q04;

public class Answer {

    private final double[] arrA, arrB;
    private final int lenTotal;

    public Answer(double[] arrA, double[] arrB) {
        if (arrA.length > arrB.length) {
            this.arrA = arrB;
            this.arrB = arrA;
        } else {
            this.arrA = arrA;
            this.arrB = arrB;
        }
        this.lenTotal = this.arrA.length + this.arrB.length;
    }

    public void solute() {
        double r;
        if (lenTotal % 2 == 0) {
            r = new CalEven(arrA, arrB).calculate();
        } else {
            r = new CalOdd(arrA, arrB).calculate();
        }
        System.out.println(r);
    }

    public static void main(String[] args) {
        double[] arrA = new double[]{0.1d, 1.5d, 4, 5}, arrB = new double[]{5, 6, 7, 8, 9, 10, 15, 20, 21};
        new Answer(arrA, arrB).solute();
    }
}
