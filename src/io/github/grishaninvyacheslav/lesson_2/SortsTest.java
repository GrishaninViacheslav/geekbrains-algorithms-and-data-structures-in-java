package io.github.grishaninvyacheslav.lesson_2;

import io.github.grishaninvyacheslav.lesson_2.sorts.BubbleSort;
import io.github.grishaninvyacheslav.lesson_2.sorts.CountingSort;
import io.github.grishaninvyacheslav.lesson_2.sorts.IntArraySorter;
import io.github.grishaninvyacheslav.lesson_2.sorts.PumpedBubbleSort;

import static io.github.grishaninvyacheslav.utils.ConsoleOutputs.*;
import static io.github.grishaninvyacheslav.utils.Arrays.*;
import static io.github.grishaninvyacheslav.utils.loopers.Range.*;

public class SortsTest {
    public static void main(String[] args) {
        Integer[][] sampleArrays = new Integer[10][];

        for (int i : range(0, sampleArrays.length)) {
            sampleArrays[i] = new Integer[(i + 1) * 10_000];
            fillArrayWithRandomValues(sampleArrays[i]);
        }

        log("==========================\n" +
                "========BubbleSort========");
        double[] bubbleSortTestResult = testSort(sampleArrays, new BubbleSort());
        log("==========================\n==========================\n");

        log("==========================\n" +
            "=====PumpedBubbleSort=====");
        double[] pumpedBubbleSortTestResult = testSort(sampleArrays, new PumpedBubbleSort());
        log("==========================\n==========================\n");

        log("==========================\n" +
            "=====CountingSort=====");
        double[] countingSortTestResult =  testSort(sampleArrays, new CountingSort());
        log("==========================\n==========================\n");

        for(int i : range(0, 10)){
            log((i+1) + "0k:\n" + (countingSortTestResult[i] - pumpedBubbleSortTestResult[i]) + "\n" + (countingSortTestResult[i] - bubbleSortTestResult[i]) );
        }
    }

    private static double[] testSort(Integer[][] sampleArrays, IntArraySorter sorter) {
        StringBuilder dataSet = new StringBuilder();
        double[] result = new double[10];

        for (int i : range(0, sampleArrays.length)) {
            long current = System.nanoTime();
            BubbleSort.bubbleSort(sampleArrays[i]);
            double delta = (System.nanoTime() - current) * 0.000_000_001;
            log(String.format("N = %d0k: %.9f", (i + 1), delta));
            dataSet.append("{" + (i + 1) * 10_000 + "," + delta + "},");
            result[i] = delta;
        }
        log("dataSet: " + dataSet);
        return result;
    }
}
