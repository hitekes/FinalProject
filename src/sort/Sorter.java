package src.sort;

import java.util.Collection;
import java.util.Comparator;

public interface Sorter<T extends Comparable<T>>{
    void sort(T[] array);
}
