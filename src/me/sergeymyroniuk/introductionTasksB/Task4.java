package me.sergeymyroniuk.introductionTasksB;

import java.util.Scanner;

// Ввести с консоли n целых чисел. На консоль вывести: числа, которые делятся на 5 и на 7.

public class Task4 {
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
            if ((sourceNumbers[i] % 5 == 0) && (sourceNumbers[i] % 7 == 0)) {
                System.out.println("Число, которое делится на 5 и 7: " + sourceNumbers[i]);
            }
        }
    }
}
