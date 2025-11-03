package src.sort;

import java.util.Comparator;

public class SortStrategia<T> {
    private Sorter<T> sorter;

    public SortStrategia(Sorter<T> sorter) {
        this.sorter = sorter;
    }

    public void setSortStrategy(Sorter<T> sorter) {
        this.sorter = sorter;
    }

    public void sort(T[] array, Comparator<T> comparator) {
        if (sorter != null) {
            sorter.sort(array, comparator);
        }
        else {
            throw new NullPointerException("Необходимо задать стратегию сортировки.");
        }
    }
}
