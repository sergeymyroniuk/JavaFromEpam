package me.sergeymyroniuk.introduction;

import java.util.Scanner;

// Ввести целые числа как аргументы командной строки, подсчитать их суммы и произведения. Вывести результат на консоль.

public class Task5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; true; i++) {
            int x = input.nextInt();
            int y
                    = input.nextInt();

            System.out.println("Sum= " + (x + y));
            System.out.println("Mutli= " + (x * y));
        }
    }
}
