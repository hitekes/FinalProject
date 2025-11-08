package src.utils;

import java.util.Scanner;

public final class InputValidator {
    private InputValidator() {}

    public static int getValidatedInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value < min || value > max) {
                    System.out.println("Значение должно быть в диапазоне [" + min + ", " + max + "]");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число.");
            }
        }
    }

    public static boolean validateCarData(int power, String model, int year) {
        if (power < 50 || power > 2000) return false;
        if (model == null || model.trim().isEmpty() || model.length() > 100) return false;
        return year >= 1900 && year <= 2100;
    }
}