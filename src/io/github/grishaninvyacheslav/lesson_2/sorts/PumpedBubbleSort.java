package io.github.grishaninvyacheslav.lesson_2.sorts;

import java.util.Stack;
import static io.github.grishaninvyacheslav.utils.Arrays.*;


public class PumpedBubbleSort implements IntArraySorter{

    /**
     * Улучшенная сортировка пузырьком.
     * В отличии от пузырьковой сортировки всплывает не один элемент массива,
     * а половины массива. На первой итерации всплывает та половина элементов,
     * в которой каждый элемент больше любого элемента в другой половине. На последующих итерациях
     * то же самое происходит внутри получившиеся половин. То есть в левой половине всплывает та половина элементов,
     * в которой каждый элемент больше любого элемента в другой половине левой половины. Эта операция повторяется для
     * всех получившиеся в результате её выполнения половин до тех пока получившиеся половины не станут неделимыми поровну.
     * Выигрышь в сложности в сравнении с обыной сортировкой пузырьком достигается за счёт того, что элементы первой половины
     * не сравниваются с той половиной элементов, каждый из которых будет гарантированно больше.
     *
     * @param sortArray массив, который отсортируется методом.
     * @param <E>       тип элемента массива. Должен реализовывать интерфейс Comparable.
     */
    public static <E extends Comparable<E>> void pumpedBubbleSort(E[] sortArray) {
        Stack<Integer> halfsBounds = new Stack<>();
        halfsBounds.push(0);
        halfsBounds.push(sortArray.length);
        while (!halfsBounds.isEmpty()) {
            int endIndex = halfsBounds.pop();
            int startIndex = halfsBounds.pop();

            if (endIndex - startIndex < 2) {
                continue;
            }

            int middleIndex = splitOnBubbledHalf(sortArray, startIndex, endIndex);

            halfsBounds.push(startIndex);
            halfsBounds.push(middleIndex);

            halfsBounds.push(middleIndex + 1);
            halfsBounds.push(endIndex);
        }
    }

    /**
     * Меняет местами элементы в диапазоне массива так, чтобы каждый элемент первой
     * половины диапазона был меньше каждого элемента второй половины диапазона.
     *
     * @param array массив элементов.
     * @param sortRangeStart начало диапазона.
     * @param sortRangeEnd   конец диапазона.
     * @param <E>   тип элемента массива. Должен реализовывать интерфейс Comparable.
     * @return индекс начала второй половины.
     */
    private static <E extends Comparable<E>> int splitOnBubbledHalf(E[] array, int sortRangeStart, int sortRangeEnd) {
        int rangeToSortStart = sortRangeStart;
        int rangeToSortEnd = sortRangeEnd - 2;
        int middleIndex = sortRangeStart + ((sortRangeEnd - sortRangeStart) / 2);
        E middleValue = array[middleIndex];
        swapValues(array, middleIndex, sortRangeEnd - 1);

        while (rangeToSortStart < rangeToSortEnd) {
            if (array[rangeToSortStart].compareTo(middleValue) < 0) {
                rangeToSortStart++;
            } else if (array[rangeToSortEnd].compareTo(middleValue) >= 0) {
                rangeToSortEnd--;
            } else {
                swapValues(array, rangeToSortStart, rangeToSortEnd);
            }
        }
        int secondHalfStartIndex = rangeToSortEnd;
        if (array[rangeToSortEnd].compareTo(middleValue) < 0) {
            secondHalfStartIndex++;
        }
        swapValues(array, sortRangeEnd - 1, secondHalfStartIndex);
        return secondHalfStartIndex;
    }

    @Override
    public void sort(Integer[] sortArray) {
        pumpedBubbleSort(sortArray);
    }
}
