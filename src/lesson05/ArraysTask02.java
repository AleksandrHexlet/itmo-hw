package lesson05;

import java.util.Arrays;


public class ArraysTask02 {
    public static void main(String[] args) {

        int[] array = new int[12];
        int min = 2;
        int max = 20;

        for (int i = 0; i < array.length; i++) {
            max -= min;
            int randomNumber = (int) (Math.random() * ++max) + min;
            if (randomNumber % 2 == 0 && randomNumber != 0)  array[i] = randomNumber;

        }
        Arrays.sort(array);

        for (int i = array.length -1 ; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
}


/*

Задача 2
Создайте массив из чётных чисел [2;20] (использовать Math.random()) и выведите элементы массива в консоль в обратном порядке (20 18 16 ... 4 2)

 */