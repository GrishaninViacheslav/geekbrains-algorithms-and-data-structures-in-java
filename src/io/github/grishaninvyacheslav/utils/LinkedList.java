package io.github.grishaninvyacheslav.utils;

public class LinkedList<E> {
    private Node head = null;
    private Node tail = null;

    public void pushLast(E value) {
        if (isEmpty()) {
            tail = new Node(value, null, null);
            head = tail;
            return;
        }
        tail.next = new Node(value, tail, null);
        ;
        tail = tail.next;
    }

    public E pickLast() {
        return tail.value;
    }

    public E popLast() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        E lastValue = tail.value;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        return lastValue;
    }

    public void pushFirst(E value) {
        if (isEmpty()) {
            tail = new Node(value, null, null);
            head = tail;
            return;
        }
        head.prev = new Node(value, null, head);
        head = head.prev;
    }

    public E pickFirst() {
        return head.value;
    }

    public E popFirst() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        E firstValue = head.value;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        return firstValue;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    private class Node {
        public E value;
        public Node prev;
        public Node next;

        public Node(E value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}