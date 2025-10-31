public class EnterManualCars {
    private static void enterManualData() {
    System.out.println("Введите данные машины (для завершения введите 'stop' в поле модели):");

    while (true) {
        System.out.println("\n--- Новая машина ---");

        int power = getValidatedInt("Мощность  ", 50, 2000);

        System.out.print("Модель: ");
        String model = scanner.nextLine();

        if (model.equalsIgnoreCase("stop")) {
            break;
        }

        int year = getValidatedInt("Год производства: ", 1990, 2025);

        if (validateCarData(power, model, year)) {
            cars.add(new Car(power, model, year));
            System.out.println("Машина добавлена!");
        }
    }
}
}
