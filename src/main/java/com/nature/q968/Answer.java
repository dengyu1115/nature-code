package com.nature.q968;

public class Answer {

    private final Integer[] arr;


    public Answer(Integer[] arr) {
        this.arr = arr;
    }

    public void solute() {
        System.out.println(new Tree(this.arr));
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{
                0, 0, null, 0, 0
        };
        new Answer(arr).solute();
    }

}
