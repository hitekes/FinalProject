public class LoadFromFile {
    private static void loadFromFile() {
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();

        if (validateCarData(power, model, year)) {
            loadedCars.add(new Car(power, model, year));
        } else {
            errorCount++;
            System.out.println("Ошибка валидации в строке " + (i + 1) + ": " + line);
        }
    } else {
        errorCount++;
        System.out.println("Неверный формат в строке " + (i + 1) + ": " + line);
    }
} catch (NumberFormatException e) {
errorCount++;
        System.out.println("Ошибка числового формата в строке " + (i + 1) + ": " + lines.get(i));
        }
        cars.addAll(loadedCars);
            System.out.println("Загружено " + loadedCars.size() + " машин из файла.");
        if (errorCount > 0) {
        System.out.println("Найдено ошибок: " + errorCount);

                    } catch (IOException e) {
        System.out.println("Ошибка при чтении файла: " + e.getMessage());
}
