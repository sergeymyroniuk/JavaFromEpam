package me.sergeymyroniuk.dataTypesAndOperatorsTasksB;

import java.util.Scanner;

// Написать код программы, которая бы переводила числа одной любой системы счисления в любую другую.

public class Task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: " );
        int s = sc.nextInt();
        System.out.println("Система счисления: " + Integer.toHexString(s));
    }
}
