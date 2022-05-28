package io.github.grishaninvyacheslav.lesson_1.task_3;

import static io.github.grishaninvyacheslav.utils.ConsoleOutputs.log;

public class Implementation {
    public static void main(String[] args) {
        log(
                sumOfWholeNumbersFromTo(0, 100) // 3. получить сумму всех чисел в ряду от 0 до 100.
        );
    }

    public static int sumOfWholeNumbersFromTo(int from, int to) {
        if (from > to) {
            throw new ArithmeticException(String.format("\nЗначение from больше чем to:\nfrom: %d\nto: %d", from, to));
        }
        return (from + to) * (to - from + 1) / 2;
    }
}
