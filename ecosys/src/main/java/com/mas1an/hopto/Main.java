package com.mas1an.hopto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! Вы хотите работать с новой симуляцией или продолжить старую?");
        System.out.println("1) Новая симуляция");
        System.out.println("2) Старая симуляция");

        int choice = Integer.parseInt(scanner.nextLine());
        String fileName;

        if (choice == 1) {
            System.out.println("Введите имя новой симуляции:");
            fileName = scanner.nextLine();
        } else {
            fileName = ObjectManager.selectSimulation(scanner);
            while (fileName == null) {
                fileName = ObjectManager.selectSimulation(scanner);
            }
        }

        System.out.println("Выберите действие:");
        System.out.println("1) Добавить");
        System.out.println("2) Прочитать");
        System.out.println("3) Изменить колличество");
        System.out.println("4) Удалить");
        System.out.println("5) Выйти");

        while (true) {
            int action = Integer.parseInt(scanner.nextLine()); // Преобразование строки в целое число
            switch (action) {
                case 1:
                    System.out.println("Выбрано: Добавить");
                    ObjectManager.addEntity(scanner, fileName);
                    break;
                case 2:
                    System.out.println("Выбрано: Прочитать");
                    ObjectManager.readEntities(fileName);
                    break;
                case 3:
                    System.out.println("Выбрано: Обновить");
                    ObjectManager.updateEntity(scanner, fileName);
                    break;
                case 4:
                    System.out.println("Выбрано: Удалить");
                    ObjectManager.deleteEntity(scanner, fileName);
                    break;
                case 5:
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("Неизвестное действие. Попробуйте снова.");
            }
            System.out.println("Выберите следующее действие:");
            System.out.println("1) Добавить");
            System.out.println("2) Прочитать");
            System.out.println("3) Изменить колличество");
            System.out.println("4) Удалить");
            System.out.println("5) Выйти");
        }
    }
}