package lesson05;

import java.util.Scanner;

public class ArraysTask01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int arrSize = scanner.nextInt();
        Double[] array = new Double[arrSize];
        Double minNum = 100.0;
        Double middleNum = 0.0;
        Double maxNum = 0.0;
        Double summ = 0.0;
        for (int i = 0; i < arrSize; i++) {
            Double num = Math.random() * arrSize;
            System.out.println(num);
            array[i] = num;

            minNum = minNum < num ? minNum : num;
            maxNum = maxNum > num ? maxNum : num;
            summ = summ + num;
        }
        middleNum = summ / arrSize;
        System.out.println("minNum = " + minNum + "; maxNum = " + maxNum + "; middleNum = " + middleNum + "; summ = " + summ);

    }
}


/*
Задача 1
Заполните массив на N элементов (размер массива вводит пользователь) случайным целыми числами
и выведете максимальное, минимальное и среднее арифметическое значение элементов массива

 */