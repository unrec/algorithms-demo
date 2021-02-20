package com.unrec.algorithms.data;

public class BinaryTree {

    private Node root;

    public void add(int value) {
        root = addNode(root, value);
    }

    public boolean contains(int value) {
        return containsNode(root, value);
    }

    private Node addNode(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addNode(current.left, value);
        } else if (value > current.value) {
            current.right = addNode(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    private boolean containsNode(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNode(current.left, value)
                : containsNode(current.right, value);
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}