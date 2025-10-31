public class DisplayCars {
    private static void displayCars() {
        if (cars.isEmpty()) {
            System.out.println("Список машин пуст.");
            return;
        }

        System.out.println("\nСПИСОК МАШИН (" + cars.size() + " шт.):");
        System.out.println("=".repeat(65));
        System.out.printf("%-3s %-40s %-12s %s\n", "№", "Модель", "Мощность", "Год");
        System.out.println("-".repeat(65));

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.printf("%-3d %-40s %-12d %d\n",
                    i + 1, car.getModel(), car.getPower(), car.getYear());
        }
    }
}
