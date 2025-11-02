public class SortCars {
    private static void sortCars() {
            if (cars.isEmpty()) {
                System.out.println("Нет данных для сортировки.");
                return;
            }

            System.out.println("Выполняется полная сортировка (мощность -> модель -> год)...");
            Collections.sort(cars, new CarFullComparator());
            System.out.println("Сортировка завершена!");
        }
}
