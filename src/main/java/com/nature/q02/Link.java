package com.nature.q02;

public class Link {

    private int num;
    private Link next;

    public Link(int num) {
        this.num = num;
    }

    public Link next(int num) {
        return this.next = new Link(num);
    }

    public int getNum() {
        return num;
    }

    public Link getNext() {
        return next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.num);
        Link next = this.next;
        while (next != null) {
            builder.append(", ").append(next.num);
            next = next.next;
        }
        return builder.toString();
    }
}
