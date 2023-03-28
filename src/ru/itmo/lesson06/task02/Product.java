package ru.itmo.lesson06.task02;

public class Product {
    private String name;
    private int proteins;
    private int fats;
    private int carbohydrates;
    private int calories;


    public Product(String name) {
        if (name.length() > 0 && name != null) this.name = name;
    }

    public Product(String name, int proteins) {
        if (proteins > 0) this.proteins = proteins;
        if (name.length() > 0 && name != null) this.name = name;
    }

    public Product(int fats) {
        if (fats > 0) this.fats = fats;
    }

    public Product(int carbohydrates, int calories) {
        if (carbohydrates > 0) this.carbohydrates = carbohydrates;
        if (calories > 0) this.calories = calories;
    }

    public Product(String name, int proteins, int fats, int carbohydrates, int calories) {
        if (proteins > 0) this.proteins = proteins;
        if (name.length() > 0 && name != null) this.name = name;
        if (fats > 0) this.fats = fats;
        if (carbohydrates > 0) this.carbohydrates = carbohydrates;
        if (calories > 0) this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getProteins() {
        return proteins;
    }

    public int getFats() {
        return fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                ", calories=" + calories +
                '}';
    }
}


