package src.sort;

import java.util.Collection;

public class SortingContext<T extends Comparable<T>> {

    private Sorter<T> strategy;

    public SortingContext(Sorter<T> sorter) {
        this.strategy = sorter;
    }

    public void setStrategy(Sorter<T> sorter) {
        this.strategy = sorter;
    }

    public void sort(T[] array) {
        if (strategy == null) {
            throw new NullPointerException("Необходимо задать стратегию сортировки.");
        }
        System.out.println("Выполняется полная сортировка (мощность -> модель -> год)...");
        strategy.sort(array);
        System.out.println("Сортировка завершена!");
    }
}
