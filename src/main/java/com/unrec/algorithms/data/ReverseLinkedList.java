package com.unrec.algorithms.data;

import java.util.concurrent.ThreadLocalRandom;

public class ReverseLinkedList {

    public static void main(String[] args) {
        int size = ThreadLocalRandom.current().nextInt(20);
        System.out.println("size = " + size);

        Node list = generateList(size);
        System.out.println("Before: " + printNode(list));

        Node reversed = reverse(list);
        System.out.println("After: " + printNode(reversed));
    }

    private static Node generateList(int size) {
        Node startNode = new Node(1);
        Node current = startNode;

        int i = 2;
        while (i <= size) {
            Node next = new Node(i);
            current.next = next;
            current = next;
            i++;
        }
        return startNode;
    }

    private static Node reverse(Node node) {
        Node current = node;
        Node previous = null;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private static String printNode(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.value);
            if (node.next != null) {
                sb.append(" -> ");
            }
            node = node.next;
        }
        return sb.toString();
    }

    private static class Node {
        int value;
        Node next;

        Node() {
        }

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}