package me.sergeymyroniuk.dataTypesAndOperatorsTasksB;

// Вывести на экран все числа от 1 до 100, которые делятся на 3 без остатка.

public class Task4 {
    public static void main(String[] args) {
        for (int i = 3; i < 100; i += 3)
            System.out.println(i);
    }
}
