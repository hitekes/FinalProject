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
        if (sorter == null) {
            throw new NullPointerException("Необходимо задать стратегию сортировки.");
            return;
        }
        if (array.length == 0)
        {
            System.out.println("Нет данных для сортировки.");
            return;
        }
        System.out.println("Выполняется полная сортировка (мощность -> модель -> год)...");
        sorter.sort(array, comparator);
        System.out.println("Сортировка завершена!");
    }
}
