package io.github.grishaninvyacheslav.lesson_3.task_1;

import io.github.grishaninvyacheslav.utils.LinkedList;

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
