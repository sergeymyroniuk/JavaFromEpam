package me.sergeymyroniuk.introductionTasksB;

import java.util.Scanner;

// Ввести с консоли n целых чисел. На консоль вывести: числа, которые делятся на 3 или на 9.

public class Task3 {
    public static void main(String[] args) {
        System.out.print("Сколько целых чисел вы собираетесь ввести? ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] sourceNumbers = new int[size];
        System.out.print("Введите целые числа через пробел " + "и нажмите <Enter>: ");
        for (int i = 0; i < size; i++) {
            sourceNumbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < size; i++) {
            if ((sourceNumbers[i] % 3 == 0) || (sourceNumbers[i] % 9 == 0)) {
                System.out.println("Число, которое делится на 3 или 9: " + sourceNumbers[i]);
            }
        }
    }
}
