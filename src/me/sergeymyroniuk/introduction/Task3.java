package me.sergeymyroniuk.introduction;

// Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.

public class Task3 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        for (int i : a) {
            System.out.println(i);
            System.out.print(i);
        }
    }
}
