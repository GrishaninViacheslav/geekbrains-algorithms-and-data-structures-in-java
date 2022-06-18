package io.github.grishaninvyacheslav.lesson_3.task_1;

class Demo {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        for(int i = 3; i >= 1; i--){
            deque.insertLeft(i);
        }
        deque.removeLeft();
        while (deque.isNotEmpty()) {
            System.out.println(deque.removeRight());
        }

        System.out.println("###");

        for(int i = 1; i <= 3; i++){
            deque.insertRight(i);
        }
        deque.removeRight();
        while (deque.isNotEmpty()) {
            System.out.println(deque.removeLeft());
        }
    }
}

public class Deque<E> {
    private LinkedList<E> data = new LinkedList<>();

    public void insertLeft(E value) {
        data.pushFirst(value);
    }

    public E pickLeft() {
        return data.pickFirst();
    }

    public E removeLeft() {
        return data.popFirst();
    }

    public void insertRight(E value) {
        data.pushLast(value);
    }

    public E pickRight() {
        return data.pickLast();
    }

    public E removeRight() {
        return data.popLast();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }
}

class LinkedList<E> {
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
