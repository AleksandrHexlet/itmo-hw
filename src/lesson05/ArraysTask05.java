package lesson05;

import java.util.Arrays;


public class ArraysTask05 {
    public static void main(String[] args) {

        int[] arr = new int[5];
        int count = 0;
        int[] arrNeg;
        int countArrNeg = 0;

        for (int i = 0; i < arr.length; i++) {
            int randomNum = (int)(Math.random() * arr.length);
            if (randomNum % 2 == 0) {
                arr[i] = randomNum;
                System.out.println("positive  = " + arr[i]);
            } else{
                arr[i] = randomNum - arr.length;
                System.out.println("negat = " + arr[i]);
                count++;
            }

        }
        arrNeg = new int[count];
        for (int i = 0; i < arr.length; i++) {

            if(arr[i] < 0){

                arrNeg[countArrNeg] = arr[i];
                countArrNeg++;
            }
        }

        System.out.println("arrNeg = " + Arrays.toString(arrNeg));
    }
}


/*
Задача 5
Создать массив, наполнить его целыми числами (отрицательными и положительными). Отрицательные элементы массива скопировать в новый массив.

Размер массива должен быть равен количеству отрицательных элементов.
 */