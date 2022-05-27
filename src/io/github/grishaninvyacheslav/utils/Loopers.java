package io.github.grishaninvyacheslav.utils;

public class Loopers {
    public interface Executable {
        void invoke();
    }

    public static void repeat(int times, Executable functionToExecute) {
        repeat(1, times, functionToExecute);
    }

    public static void repeat(int from, int to, Executable function) {
        repeat(from, to, 1, function);
    }

    public static void repeat(int from, int to, int step, Executable function) {
        for (int i = from; i < to; i += step) {
            function.invoke();
        }
    }
}
