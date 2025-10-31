import java.util.*;
import java.io.*;
import java.nio.file.*;

class CarTimsortProgramm {
    private final static List<Car> cars = new ArrayList<>();
    private final static Scanner scanner = new Scanner(System.in);

    private static void displayMenu() {
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
    public static void main(String[] args) {
        System.out.println("=== ПРОГРАММА СОРТИРОВКИ МАШИН С ПОМОЩЬЮ TIMSORT ===");
        System.out.println("Параметры: мощность, модель, год производства");

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getValidatedInt("Выберите действие: ", 1, 7);

            switch (choice) {
                case 1:
                    loadFromFile();
                    break;
                case 2:
                    generateRandomData();
                    break;
                case 3:
                    enterManualData();
                    break;
                case 4:
                    displayCars();
                    break;
                case 5:
                    sortCars();
                    break;
                case 6:
                    clearData();
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
}

