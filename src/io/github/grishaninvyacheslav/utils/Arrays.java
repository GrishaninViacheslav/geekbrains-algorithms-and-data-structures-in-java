package io.github.grishaninvyacheslav.utils;

import java.util.concurrent.ThreadLocalRandom;

import static io.github.grishaninvyacheslav.utils.loopers.Range.range;

public class Arrays {

    /**
     * Меняет местами знаяения элементов массива.
     *
     * @param array  массив элементы которого поменяются местами
     * @param aIndex индекс элемента, которому будет присвоено значение bIndex
     * @param bIndex индекс элемента, которому будет присвоено значение aIndex
     * @param <E>    тип элемента массива.
     */
    public static <E> void swapValues(E[] array, int aIndex, int bIndex) {
        E temp = array[aIndex];
        array[aIndex] = array[bIndex];
        array[bIndex] = temp;
    }

    public static void fillArrayWithValue(int[] array, int value) {
        for (int i : range(0, array.length)) {
            array[i] = value;
        }
    }

    public static void fillArrayWithRandomValues(Integer[] array){
        for(int i : range(0, array.length)){
            array[i] = ThreadLocalRandom.current().nextInt();
        }
    }

    public static int getMinValue(int[] array) {
        int result = array[0];
        for (int i : range(1, array.length)) {
            if (array[i] < result) {
                result = array[i];
            }
        }
        return result;
    }

    public static int getMaxValue(int[] array) {
        int result = array[0];
        for (int i : range(1, array.length)) {
            if (array[i] > result) {
                result = array[i];
            }
        }
        return result;
    }

    public static boolean isSorted(Integer[] array){
        for(int i: range(1, array.length)){
            if(array[i] < array[i - 1]){
                return false;
            }
        }
        return true;
    }
}
