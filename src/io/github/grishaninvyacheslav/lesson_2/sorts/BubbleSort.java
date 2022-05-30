package io.github.grishaninvyacheslav.lesson_2.sorts;

import static io.github.grishaninvyacheslav.utils.loopers.Range.*;
import static io.github.grishaninvyacheslav.utils.Arrays.*;

public class BubbleSort implements IntArraySorter {
    public static <E extends Comparable<E>> void bubbleSort(E[] sortArray){
        for(int unsortedPartBound = sortArray.length; unsortedPartBound != 0; unsortedPartBound--){
            int indexOfMaxValue = 0;
            for(int i: range(1, unsortedPartBound)){
                if(sortArray[i].compareTo(sortArray[indexOfMaxValue]) > 0){
                    indexOfMaxValue = i;
                }
                swapValues(sortArray, indexOfMaxValue, unsortedPartBound - 1);
            }
        }
    }

    @Override
    public void sort(Integer[] sortArray) {
        bubbleSort(sortArray);
    }
}
