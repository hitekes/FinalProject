public class SortCars {
    private static void sortCars() {
    if (cars.isEmpty()) {
        System.out.println("Нет данных для сортировки.");
        return;
    }

    System.out.println("\nВЫБЕРИТЕ ТИП СОРТИРОВКИ:");
    System.out.println("1. По мощности");
    System.out.println("2. По модели");
    System.out.println("3. По году производства");
    System.out.println("4. По мощности и модели");
    System.out.println("5. По модели и году");
    System.out.println("6. По мощности и году");
    System.out.println("7. По мощности, модели и году (полная)");

    int sortChoice = getValidatedInt("Ваш выбор: ", 1, 7);
        switch (sortChoice) {
            case 1:
                comparator = new CarPowerComparator();
                sortDescription = "мощности";
                break;
            case 2:
                comparator = new CarModelComparator();
                sortDescription = "модели";
                break;
            case 3:
                comparator = new CarYearComparator();
                sortDescription = "году производства";
                break;
            case 4:
                comparator = new CarPowerModelComparator();
                sortDescription = "мощности и модели";
                break;
            case 5:
                comparator = new CarModelYearComparator();
                sortDescription = "модели и году";
                break;
            case 6:
                comparator = new CarPowerYearComparator();
                sortDescription = "мощности и году";
                break;
            case 7:
                comparator = new CarFullComparator();
                sortDescription = "мощности, модели и году";
                break;
            default:
                comparator = new CarFullComparator();
                sortDescription = "мощности, модели и году";
        }

        System.out.println("Сортировка по " + sortDescription + "...");
}
