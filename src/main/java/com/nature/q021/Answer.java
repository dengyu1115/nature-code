package com.nature.q021;

public class Answer {

    private final Link a, b;

    private Link r;

    public Answer(int[] a, int[] b) {
        this.a = new Link(a[0]);
        Link t = this.a;
        for (int i = 1; i < a.length; i++) {
            t = t.next(a[i]);
        }
        this.b = new Link(b[0]);
        t = this.b;
        for (int i = 1; i < b.length; i++) {
            t = t.next(b[i]);
        }
    }

    public void solute() {
        Link a = this.a;
        Link b = this.b;
        if (a.getNum() > b.getNum()) {
            r = b;
            b = b.getNext();
        } else {
            r = a;
            a = a.getNext();
        }
        Link t = r;
        while (a != null && b != null) {
            if (a.getNum() > b.getNum()) {
                t = t.next(b);
                b = b.getNext();
            } else {
                t = t.next(a);
                a = a.getNext();
            }
        }
        while (a != null) {
            t = t.next(a);
            a = a.getNext();
        }
        while (b != null) {
            t = t.next(b);
            b = b.getNext();
        }
        System.out.println(this.a);
        System.out.println(this.b);
        System.out.println(this.r);
    }

    public static void main(String[] args) {
        new Answer(new int[]{0, 1, 2, 3, 9}, new int[]{3, 4, 5, 7, 8}).solute();
    }

}
