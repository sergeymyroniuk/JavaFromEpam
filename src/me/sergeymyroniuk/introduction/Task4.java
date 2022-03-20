package me.sergeymyroniuk.introduction;

import java.util.Scanner;

// Ввести пароль из командной строки и сравнить его со строкой-образцом.

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String password1 = scanner.next();
        String password2 = "1997";
        if (password1.equals(password2)){
            System.out.println("Пароль верный!");
        } else {
            System.out.println("Пароль не верный!");
            }
        }
}
