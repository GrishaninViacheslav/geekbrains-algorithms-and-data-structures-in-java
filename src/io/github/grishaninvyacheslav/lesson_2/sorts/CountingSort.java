package io.github.grishaninvyacheslav.lesson_2.sorts;

import static io.github.grishaninvyacheslav.utils.loopers.Range.*;

public class CountingSort {

    public static void countingSort(int[] sortArray) {
        int minValue = getMinValue(sortArray);
        int maxValue = getMaxValue(sortArray);

        int[] countArray = new int[maxValue - minValue + 1];
        fillArrayWithValue(countArray, 0);

        for (int i : range(0, sortArray.length)) {
            countArray[sortArray[i] - minValue]++;
        }

        int sortedPartBound = 0;
        for (int i : range(0, countArray.length)) {
            if (countArray[i] > 0) {
                for (int j : range(0, countArray[i])) {
                    sortArray[sortedPartBound] = i + minValue;
                    sortedPartBound++;
                }
            }
        }
    }

    private static int getMinValue(int[] array) {
        int result = array[0];
        for (int i : range(1, array.length)) {
            if (array[i] < result) {
                result = array[i];
            }
        }
        return result;
    }

    private static int getMaxValue(int[] array) {
        int result = array[0];
        for (int i : range(1, array.length)) {
            if (array[i] > result) {
                result = array[i];
            }
        }
        return result;
    }

    private static void fillArrayWithValue(int[] array, int value) {
        for (int i : range(0, array.length)) {
            array[i] = value;
        }
    }
}