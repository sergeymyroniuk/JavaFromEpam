package me.sergeymyroniuk.introductionTasksB;

import java.util.Scanner;

// Ввести с консоли n целых чисел. На консоль вывести: четные и нечетные числа.

public class Task1 {
    public static void main(String[] args) {
        System.out.print("Сколько целых чисел вы собираетесь ввести? ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] sourceNumbers = new int[size];
        System.out.print("Введите целые числа через пробел " + "и нажмите <Enter>: ");
        for (int i = 0; i < size; i++) {
            sourceNumbers[i] = scanner.nextInt();
        }


        for (int i = 0; i < size; i++)
            if (sourceNumbers[i] % 2 != 0)
                System.out.println("Нечётное число:" + sourceNumbers[i]);
            else if (sourceNumbers[i] % 2 == 0)
                System.out.println("Чётное число:" + sourceNumbers[i]);
    }
}
