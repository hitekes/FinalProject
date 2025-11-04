package src.sort;

public class BinaryInsertionSorter<T extends Comparable<T>> {
    public void sort(T[] array, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            T item = array[i];
            int j = i - 1;
            int pos = binarySearch(array, item, start, i);
            while (j >= pos) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = item;
        }
    }

    private int binarySearch(T[] array, T item, int start, int end) {
        while (start < end) {
            int mid = (start + end) >>> 1;
            if (item.compareTo(array[mid]) < 0) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
