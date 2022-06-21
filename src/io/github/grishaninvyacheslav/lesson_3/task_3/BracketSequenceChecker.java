package io.github.grishaninvyacheslav.lesson_3.task_3;

import io.github.grishaninvyacheslav.lesson_3.task_1.Deque;
import io.github.grishaninvyacheslav.utils.Pair;

class Demo {
    public static void main(String[] args) {
        System.out.println(BracketSequenceChecker.check("{{}{{}}}"));
        System.out.println(BracketSequenceChecker.check("{{{{}}}"));
    }
}

public class BracketSequenceChecker {
    public static boolean check(String bracketSequence) {
        Deque<Pair<Character, Integer>> stack = new Deque<>();

        for (int i = 0; i < bracketSequence.length(); i++) {
            char currChar = bracketSequence.charAt(i);
            if (currChar == '{') {
                stack.insertRight(new Pair<>(currChar, i));
            } else if (currChar == '}') {
                stack.removeRight();
            } else {
                throw new RuntimeException();
            }
        }

        return stack.isEmpty();
    }
}
