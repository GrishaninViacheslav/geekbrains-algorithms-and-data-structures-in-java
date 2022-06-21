package io.github.grishaninvyacheslav.lesson_3.task_2;

import io.github.grishaninvyacheslav.utils.LinkedList;

class Demo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(1);
        System.out.println("min: " + priorityQueue.getMin() + "\nmax: " + priorityQueue.getMax());
    }
}

public class PriorityQueue<E extends Comparable<E>> {
    private LinkedList<E> data = new LinkedList<>();

    public void add(E value) {
        if(data.isEmpty()){
            data.pushFirst(value);
            return;
        }

        LinkedList.Node<E> currNode = data.head;
        while (currNode != null) {
            if (currNode.value.compareTo(value) > 0) {
                LinkedList.Node<E> newNode = new LinkedList.Node<>(value, currNode.prev, currNode);
                if (currNode == data.head) {
                    currNode.prev = newNode;
                    data.head = newNode;
                } else {
                    currNode.prev.next = newNode;
                    currNode.prev = newNode;
                }
                return;
            }
            currNode = currNode.next;
        }

        LinkedList.Node<E> newNode = new LinkedList.Node<>(value, data.tail, null);
        data.tail.next = newNode;
        data.tail = newNode;
    }

    public E getMin() {
        return data.pickFirst();
    }

    public E getMax() {
        return data.pickLast();
    }
}
