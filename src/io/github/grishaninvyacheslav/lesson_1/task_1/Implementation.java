package io.github.grishaninvyacheslav.lesson_1.task_1;

import static io.github.grishaninvyacheslav.utils.ConsoleOutputs.*;
import static io.github.grishaninvyacheslav.utils.loopers.Range.*;

public class Implementation {
    public static void main(String[] args) {
        log(
                pow(2, 10) // 1. возведение в степень
        );
    }

    public static int pow(int base, int exponent) {
        if(exponent < 0){
            throw new ArithmeticException(String.format("\nЗначение exponent меньше нуля:\nexponent: %d", exponent));
        }
        int result = base;
        for(int i : range(exponent)){
            result *= base;
        }
        return result;
    }
}
