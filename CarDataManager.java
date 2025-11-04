package src.manager;

import src.entity.Car;
import src.util.InputValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CarDataManager {
    private final List<Car> cars = new ArrayList<>();
    private final Scanner scanner;

    public CarDataManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void loadFromFile() {
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine().trim();
        int limit = InputValidator.getValidatedInt(scanner, "Сколько машин загрузить? ", 1, 1000000);

        List<Car> loaded = new ArrayList<>();
        int errorCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNum = 0;
            while ((line = br.readLine()) != null) {
                lineNum++;
                String trimmed = line.trim();
                if (trimmed.isEmpty()) continue;
                String[] parts = splitFlexible(trimmed);
                if (parts.length != 3) {
                    System.out.println("Неверный формат в строке " + lineNum + ": " + line);
                    errorCount++;
                    continue;
                }
                try {
                    int power = Integer.parseInt(parts[0].trim());
                    String model = parts[1].trim();
                    int year = Integer.parseInt(parts[2].trim());
                    if (InputValidator.validateCarData(power, model, year)) {
                        Car car = new Car.CarBuilder()
                                .setPower(power)
                                .setModel(model)
                                .setYear(year)
                                .build();
                        loaded.add(car);
                        if (loaded.size() >= limit) {
                            break;
                        }
                    } else {
                        System.out.println("Ошибка валидации в строке " + lineNum + ": " + line);
                        errorCount++;
                    }
                } catch (IllegalArgumentException ex) {
                    System.out.println("Ошибка в строке " + lineNum + ": " + line + " - " + ex.getMessage());
                    errorCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        cars.addAll(loaded);
        System.out.println("Загружено " + loaded.size() + " машин из файла (запрошено " + limit + ").");
        if (errorCount > 0) {
            System.out.println("Найдено ошибок: " + errorCount);
        }
    }

    private String[] splitFlexible(String line) {
        String[] parts = line.split("[;,]\\s*", -1);
        if (parts.length == 1) {
            parts = line.split("\t", -1);
        }
        if (parts.length == 1) {
            parts = line.split("\\s+", -1);
        }
        return parts;
    }

    public void generateRandomData() {
        int count = InputValidator.getValidatedInt(scanner, "Сколько машин сгенерировать? ", 1, 10000);
        Random rnd = new Random();
        for (int i = 0; i < count; i++) {
            int power = 50 + rnd.nextInt(950);
            String model = randomModel(rnd);
            int year = 1990 + rnd.nextInt(35);
            try {
                cars.add(new Car.CarBuilder()
                        .setPower(power)
                        .setModel(model)
                        .setYear(year)
                        .build());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка при генерации машины: " + e.getMessage());
            }
        }
        System.out.println("Сгенерировано " + count + " случайных машин.");
    }

    private String randomModel(Random rnd) {
        String[] brands = {"Audi", "BMW", "VW", "Volvo", "Toyota", "Honda", "Mazda", "Kia", "Hyundai", "Renault"};
        String[] series = {"A", "B", "C", "D", "E", "F", "G"};
        return brands[rnd.nextInt(brands.length)] + " " + series[rnd.nextInt(series.length)] + (1 + rnd.nextInt(9));
    }

    public void enterManualData() {
        System.out.println("Введите данные машины");
        while (true) {
            try {
                int power = InputValidator.getValidatedInt(scanner, "Мощность: ", 50, 1000);
                System.out.print("Модель: ");
                String model = scanner.nextLine().trim();
                int year = InputValidator.getValidatedInt(scanner, "Год производства: ", 1990, 2025);

                Car car = new Car.CarBuilder()
                        .setPower(power)
                        .setModel(model)
                        .setYear(year)
                        .build();
                cars.add(car);
                System.out.println("Машина добавлена!");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

            System.out.print("Хотите добавить ещё машину? (да/нет): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (!answer.equals("да")) {
                break;
            }
        }
    }

    public void displayCars() {
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
                    i + 1, car.getModel(), car.getPower(), car.getYearOfProduction());
        }
    }

    public void clearData() {
        cars.clear();
        System.out.println("Все данные очищены.");
    }

    public Car[] getArray() {
        return cars.toArray(new Car[0]);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}