package me.sergeymyroniuk.introductionTasksB;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        System.out.print("Сколько целых чисел вы собираетесь ввести? ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] sourceNumbers = new int[size];
        System.out.print("Введите целые числа через пробел " + "и нажмите <Enter>: ");
        for (int i = 0; i < size; i++) {
            sourceNumbers[i] = scanner.nextInt();
        }

        int a1 = 0, b1 = 0;
        for (int j = 0; j < size; j++)
            if ((sourceNumbers[j] > 99999) && (sourceNumbers[j] < 1000000)) {

                a1 = sourceNumbers[j] / 1000;
                b1 = sourceNumbers[j] % 1000;

                int sum = 0;
                int sum1 = 0;
                while (a1 != 0) {
                    sum = sum + a1 % 10;
                    a1 = a1 / 10;
                }

                while (b1 != 0) {
                    sum1 = sum1 + b1 % 10;
                    b1 = b1 / 10;
                }

                if (sum == sum1) {
                    System.out.println("Счастливое число: " + sourceNumbers[j]);
                }
            }
    }
}
