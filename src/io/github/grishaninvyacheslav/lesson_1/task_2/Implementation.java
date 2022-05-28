package io.github.grishaninvyacheslav.lesson_1.task_2;

import static io.github.grishaninvyacheslav.utils.ConsoleOutputs.*;;
import static io.github.grishaninvyacheslav.utils.Math.*;

public class Implementation {
    public static void main(String[] args) {
        log(
                pow(2, 10) // 2. возведение в степень (с использованием свойства чётности степени)
        );
    }

    public static int pow(int base, int exponent) {
        if(exponent < 0){
            throw new ArithmeticException(String.format("\nЗначение exponent меньше нуля:\nexponent: %d", exponent));
        }
        if (exponent == 0) {
            return 1;
        }
        if (isOdd(exponent)) {
            return pow(base, exponent - 1) * base;
        } else {
            int binaryPowResult = pow(base, exponent / 2);
            return binaryPowResult*binaryPowResult;
        }
    }
}
