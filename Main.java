import src.sort.SortStrategia;

import java.util.Scanner;

public class CarTimsortProgramm {
    private final CarDataManager dataManager;
    private final Scanner scanner;
    SortStrategia<Car> sortStrategy = new SortStrategia<Car>(new TimSorter<Car>());

    public CarTimsortProgramm() {
        this.scanner = new Scanner(System.in);
        this.dataManager = new CarDataManager(scanner);
    }

    public static void main(String[] args) {
        CarTimsortProgramm program = new CarTimsortProgramm();
        program.run();
    }

    public void run() {
        System.out.println("=== ПРОГРАММА СОРТИРОВКИ МАШИН С ПОМОЩЬЮ TIMSORT ===");
        System.out.println("Параметры: мощность, модель, год производства");

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = InputValidator.getValidatedInt(scanner, "Выберите действие: ", 1, 7);

            switch (choice) {
                case 1:
                    dataManager.loadFromFile();
                    break;
                case 2:
                    dataManager.generateRandomData();
                    break;
                case 3:
                    dataManager.enterManualData();
                    break;
                case 4:
                    dataManager.displayCars();
                    break;
                case 5:
                    sortStrategy.sort(dataManager.getArray(), Car::compareTo);
                    break;
                case 6:
                    dataManager.clearData();
                    break;
                case 7:
                    running = false;
                    System.out.println("Выход из программы. До свидания!");
                    break;
            }

            if (running) {
                System.out.println("\nНажмите Enter для продолжения...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("МЕНЮ:");
        System.out.println("1. Загрузить данные из файла");
        System.out.println("2. Сгенерировать случайные данные");
        System.out.println("3. Ввести данные вручную");
        System.out.println("4. Показать список машин");
        System.out.println("5. Отсортировать машины");
        System.out.println("6. Очистить данные");
        System.out.println("7. Выйти из программы");
        System.out.println("=".repeat(60));
    }
}

