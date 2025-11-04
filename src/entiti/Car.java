package src.entiti;

public class Car implements Comparable<Car> {

    private final int power;
    private final String model;
    private final int yearOfProduction;

    private Car(CarBuilder builder) {
        this.power = builder.power;
        this.model = builder.model;
        this.yearOfProduction = builder.yearOfProduction;
    }

    public int getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    @Override
    public int compareTo(Car other) {
        if (this.power != other.power) {
            return Integer.compare(this.power, other.power);
        }
        if (!this.model.equals(other.model)) {
            return this.model.compareTo(other.model);
        }
        return Integer.compare(this.yearOfProduction, other.yearOfProduction);
    }

    @Override
    public String toString() {
        return "%s, %d л.с., %d г.".formatted(model, power, yearOfProduction);
    }

    public static class CarBuilder {
        private int power;
        private String model;
        private int yearOfProduction;

        public CarBuilder power(int power) {
            if (power < 50 || power > 1000)
                throw new IllegalArgumentException("Мощность автомобиля должна быть в диапозоне от 50 до 1000 л.с.");
            this.power = power;
            return this;
        }

        public CarBuilder model(String model) {
            if (model == null || model.trim().isEmpty())
                throw new IllegalArgumentException("Название модели обязательно");
            this.model = model;
            return this;
        }

        public CarBuilder yearOfProduction(int yearOfProduction) {
            if (yearOfProduction < 1990 || yearOfProduction > 2025)
                throw new IllegalArgumentException("Год производства должен быть в диапозоне от 1990 до 2025");
            this.yearOfProduction = yearOfProduction;
            return this;
        }

        public Car build() {
            if (power <= 0 || model == null || yearOfProduction < 0) {
                throw new IllegalStateException("Обязательно заполнить все поля");
            }
            return new Car(this);
        }
    }
}
