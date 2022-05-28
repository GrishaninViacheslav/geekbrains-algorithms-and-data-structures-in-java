package io.github.grishaninvyacheslav.utils.loopers;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {

    private final int from;
    private final int to;
    private final int step;

    public Range(int from, int to, int step) {
        if (step <= 0) {
            throw new IllegalArgumentException(String.format("step должен быть положительным, но было передано значение: %s", step));
        }
        this.from = from;
        this.to = to;
        this.step = step;
    }

    public static Range range(int from, int to) {
        return new Range(from, to, 1);
    }

    public static Range range(int to) {
        return new Range(1, to, 1);
    }

    public static Range range(int from, int to, int step) {
        return new Range(from, to, step);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            private int current = from;

            @Override
            public boolean hasNext() {
                if (from < to) {
                    return current < to;
                } else {
                    return current > to;
                }
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    if (from < to) {
                        current += step;
                        return current - step;
                    } else {
                        current -= step;
                        return current + step;
                    }
                } else {
                    throw new NoSuchElementException("Выход за пределы диапазона Range");
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Из диапазона Range нельзя удалять элементы");
            }
        };
    }
}