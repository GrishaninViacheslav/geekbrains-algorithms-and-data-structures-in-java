package io.github.grishaninvyacheslav.lesson_4.task_1;

import java.util.Iterator;

class Demo{
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.pushLast(1);
        linkedList.pushLast(2);
        linkedList.pushLast(3);

        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

public class LinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    };

    public void pushLast(E value) {
        if (isEmpty()) {
            tail = new Node(value, null, null);
            head = tail;
            return;
        }
        tail.next = new Node(value, tail, null);
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

    private class Node<E> {
        public E value;
        public Node prev;
        public Node next;

        public Node(E value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private class LinkedListIterator implements Iterator<E> {

        private Node<E> nextElement = head;

        @Override
        public boolean hasNext() {
            return nextElement != null;
        }

        @Override
        public E next() {
            if(nextElement == null){
                throw new RuntimeException();
            }
            E value = nextElement.value;
            nextElement = nextElement.next;
            return value;
        }
    }
}