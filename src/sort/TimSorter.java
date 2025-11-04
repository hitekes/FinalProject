package src.sort;

import java.util.Arrays;
import java.util.Collection;


public class TimSorter<T extends Comparable<T>> implements Sorter<T> {
    private static final int MIN_MERGE = 32;
    private BinaryInsertionSorter<T> binarySorter =  new BinaryInsertionSorter<>();

    @Override
    public void sort(T[] array) {
        if (array.length < 2) return;

        // реализация тимсорт
        int minRun = minRunLength(array.length);

        // сортируем вставками для маленьких подмассивов
        for (int i = 0; i < array.length; i += minRun) {
            int end = Math.min(i + minRun - 1, array.length - 1);
            binarySorter.sort(array, i, end);
        }

        // слияние отсортированных подмассивов
        for (int size = minRun; size < array.length; size = 2 * size) {
            for (int left = 0; left < array.length; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, array.length - 1);

                if (mid < right) {
                    merge(array, left, mid, right);
                }
            }
        }
    }

    private int minRunLength(int n) {
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    private void merge(T[] array, int left, int mid, int right) {
        T[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        T[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }
}
