package me.sergeymyroniuk.introductionTasksB;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        System.out.print("Сколько целых чисел вы собираетесь ввести? ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] sourceNumbers = new int[size];
        System.out.print("Введите целые числа через пробел " + "и нажмите <Enter>: ");
        for (int i = 0; i < size; i++) {
            sourceNumbers[i] = scanner.nextInt();
        }

        int a = 0, b = 0, c = 0;
        for (int j = 0; j < size; j++)
            if ((sourceNumbers[j] > 99) && (sourceNumbers[j] < 1000)) {
                a = sourceNumbers[j] / 10 / 10;
                b = sourceNumbers[j] / 10 % 10;
                c = sourceNumbers[j] % 100 % 10;
                if (a != b && a != c && b != a && b != c && c != a && c != b)

                    System.out.println("3х-значное число в десятичной записи которых нет одинаковых цифр: " + sourceNumbers[j]);
            }
    }
}
