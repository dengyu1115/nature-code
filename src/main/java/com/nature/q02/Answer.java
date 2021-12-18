package com.nature.q02;

public class Answer {

    private final Link a;
    private final Link b;

    private int n;
    private Link r;
    private Link c;

    public Answer(Link a, Link b) {
        this.a = a;
        this.b = b;
    }

    public void solute() {
        this.doFirstAdd(a.getNum(), b.getNum());
        this.doAdd(a.getNext(), b.getNext());
        if (n == 1) {
            c.next(1);
        }
        System.out.println(r);
    }

    private void doAdd(Link a, Link b) {
        if (a != null && b == null) {
            this.doAdd(a);
        } else if (a == null && b != null) {
            this.doAdd(b);
        } else if (a != null) {
            this.doAdd(a.getNum() + b.getNum(), n);
            this.doAdd(a.getNext(), b.getNext());
        }
    }

    private void doAdd(Link a) {
        this.doAdd(a.getNum(), n);
        if (a.getNext() != null) {
            this.doAdd(a.getNext());
        }
    }

    private void doFirstAdd(int a, int b) {
        n = a + b;
        if (n > 9) {
            r = c = new Link(n - 10);
            n = 1;
        } else {
            r = c = new Link(n - 10);
            n = 0;
        }
    }

    private void doAdd(int a, int b) {
        n = a + b;
        if (n > 9) {
            c = c.next(n - 10);
            n = 1;
        } else {
            c = c.next(n);
            n = 0;
        }
    }

    public static void main(String[] args) {
        Link a = new Link(9);
        a.next(9).next(9).next(9).next(9).next(9).next(9).next(9);
        Link b = new Link(9);
        b.next(9).next(9).next(9).next(9);
        System.out.println(a);
        System.out.println(b);
        new Answer(a, b).solute();
    }
}
