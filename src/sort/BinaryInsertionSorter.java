package src.sort;

import java.util.Comparator;

public class BinaryInsertionSorter<T>  {
    public void sort(T[] array, Comparator<T> comparator, int start, int end) {
        for (int i = start+1; i <= end; i++) {
            T item = array[i];
            int j = i-1;
            int pos = binarySearch(array, item, comparator, start, i);
            while (j>= pos)
            {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = item;
        }
    }

    private int binarySearch(T[] array, T item, Comparator<T> comparator, int start, int end) {
        while (start < end) {
            int mid = (start + end) >>> 1;
            if (comparator.compare(item, array[mid]) < 0) {
                end = mid;
            } else  {
                start = mid + 1;
            }
        }
        return start;
    }
}
