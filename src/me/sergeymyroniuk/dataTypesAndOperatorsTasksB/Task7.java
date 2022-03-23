package me.sergeymyroniuk.dataTypesAndOperatorsTasksB;

import java.util.Scanner;

// Написать код программы, которая бы переводила числа из десятичной системы счисления в любую другую.

public class Task7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Десятичное число ");
        int i = s.nextInt();
        System.out.println("Двоичное число: " + Integer.toBinaryString(i));
    }
}
