package me.sergeymyroniuk.introduction;

import java.util.Scanner;

// Отобразить в окне консоли аргументы командной строки в обратном порядке.

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; true; i++) {
            StringBuffer argument = new StringBuffer(input.nextLine());
            argument.reverse();
            System.out.println("Hello " + argument.toString());
        }
    }

}
