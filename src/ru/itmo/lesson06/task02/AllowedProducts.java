package ru.itmo.lesson06.task02;

import ru.itmo.lesson06.task01.Climber;

import java.util.Arrays;

public class AllowedProducts {
    private Product[] productsArr = new Product[12];
    private int max_proteins = 10;
    private int max_fats = 15;
    private int max_carbohydrates = 20;
    private int max_calories = 25;


    public void addProduct(Product product, int number) {
        if (product.getProteins() > max_proteins) throw new IllegalArgumentException("Превышено содержание протеинов");
        if (product.getCarbohydrates() > max_carbohydrates)
            throw new IllegalArgumentException("Превышено содержание углеводов");
        if (product.getFats() > max_fats) throw new IllegalArgumentException("Превышено содержание жиров");
        if (product.getCalories() > max_calories) throw new IllegalArgumentException("Превышено содержание калорий");
        if (productsArr[number] == null) {
            productsArr[number] = product;
        } else {
            throw new ArrayIndexOutOfBoundsException("Превышен размер массива");
        }

    }

    public void getNameAllProduct() {
        for (int i = 0; i < productsArr.length - 1; i++) {
            System.out.println("name product is  " + productsArr[i].getName());
        }
    }

    @Override
    public String toString() {
        return "AllowedProducts{" +
                "productsArr=" + Arrays.toString(productsArr) +
                ", max_proteins=" + max_proteins +
                ", max_fats=" + max_fats +
                ", max_carbohydrates=" + max_carbohydrates +
                ", max_calories=" + max_calories +
                '}';
    }
}

