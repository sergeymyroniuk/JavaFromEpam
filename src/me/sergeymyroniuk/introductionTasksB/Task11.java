package me.sergeymyroniuk.introductionTasksB;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        System.out.print("Сколько целых чисел вы собираетесь ввести? ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] sourceNumbers = new int[size];
        System.out.print("Введите целые числа через пробел " + "и нажмите <Enter>: ");
        for (int i = 0; i < size; i++) {
            sourceNumbers[i] = scanner.nextInt();
        }

        for (int j = 0; j < size-2; j++)
            if (((sourceNumbers[j]) + (sourceNumbers[j + 2])) / 2 == sourceNumbers[j + 1]) {
                System.out.println("Элементы, которые равны полусумме соседних элементов: " + sourceNumbers[j + 1]);
            }
    }
}
