package lesson05;

import java.util.Arrays;
import java.util.Scanner;

public class StringTask01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while(flag) {
            System.out.println("Введите вашу строку");
            String input = scanner.nextLine();
            flag =  !(input.contains("exit"));

            String[] lines = input.split(";");

            for (int i = 0; i < lines.length ; i++) {
                lines[i] =  lines[i].strip();
                lines[i] = lines[i].substring(0,1).toUpperCase() + lines[i].substring(1);
                System.out.println("string === " + lines[i]);
            }
            System.out.println("total = " + Arrays.toString(lines));
        }

    }
}

/*
Task № 1 Считывать с консоли строки до тех пор, пока пользователь не введёт "exit".
Каждую полученную строку приводить к виду: первая заглавная, остальные маленькие и
выводить в консоль. Пробелов в начале и конце строки быть не должно.

 */