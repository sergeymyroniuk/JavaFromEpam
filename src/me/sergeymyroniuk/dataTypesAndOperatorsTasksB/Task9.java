package me.sergeymyroniuk.dataTypesAndOperatorsTasksB;

import java.util.Scanner;

// Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.

public class Task9 {
    public static void main(String[] args) {
        System.out.print("Введите число месяца: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number == 1){
            System.out.println("Январь");
        }
        if (number == 2){
            System.out.println("Февраль");
        }
        if (number == 3){
            System.out.println("Март");
        }
        if (number == 4){
            System.out.println("Апрель");
        }
        if (number == 5){
            System.out.println("Май");
        }
        if (number == 6){
            System.out.println("Июнь");
        }
        if (number == 7){
            System.out.println("Июль");
        }
        if (number == 8){
            System.out.println("Август");
        }
        if (number == 9){
            System.out.println("Сентябрь");
        }
        if (number == 10){
            System.out.println("Октябрь");
        }
        if (number == 11){
            System.out.println("Ноябрь");
        }
        if (number == 12){
            System.out.println("Декабрь");
        }
        else {
            System.out.println("Такого месяца не существует в природе!");
        }
    }
}
