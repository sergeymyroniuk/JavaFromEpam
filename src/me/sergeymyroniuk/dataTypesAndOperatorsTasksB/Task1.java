package me.sergeymyroniuk.dataTypesAndOperatorsTasksB;

// Вывести на экран таблицу умножения.

public class Task1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++){
            for (int j = 1; j <= 10; j++){
                System.out.printf("%d \t", i * j);
            }
            System.out.printf("\n");
        }
    }
}
