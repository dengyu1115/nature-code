package com.nature.q968;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {

    private Integer[] arr;

    private Node head;

    private int index;

    public Tree(Integer[] arr) {
        this.arr = arr;
        this.head = new Node();
        Integer num = this.arr[this.index];
        if (num == null) {
            throw new RuntimeException("head is null");
        }
        List<Node> nodes = Arrays.asList(this.node(this.head), this.node(this.head));
        do {
            nodes = this.generate(nodes);
        } while (!nodes.isEmpty());
    }

    private List<Node> generate(List<Node> parents) {
        List<Node> list = new ArrayList<>();
        for (Node node : parents) {
            index++;
            Integer num = index < arr.length ? arr[index] : null;
            if (num != null) {
                Node parent = node.getParent();
                if (index % 2 == 1) {
                    parent.setLeft(node);
                } else {
                    parent.setRight(node);
                }
                list.add(this.node(node));
                list.add(this.node(node));
            }
        }
        return list;
    }

    private Node node(Node parent) {
        Node node = new Node();
        node.setParent(parent);
        return node;
    }

    @Override
    public String toString() {


        return head.toString();
    }
}
