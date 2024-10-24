package com.mas1an.hopto;

import java.util.Scanner;

public class Main {

    // Метод для вывода меню
    private static void displayMenu() {
        System.out.println("Выберите действие:");
        System.out.println("0) Запустить симуляцию");
        System.out.println("1) Добавить");
        System.out.println("2) Прочитать");
        System.out.println("3) Изменить количество");
        System.out.println("4) Удалить");
        System.out.println("5) Выйти");
    }

    // Метод для обработки выбора действия
    private static void handleAction(int action, Scanner scanner, String fileName) {
        switch (action) {
            case 0:
                System.out.println("Запускаем симуляцию");
                Sim.startSimulation(scanner, fileName);
                break;
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
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Неизвестное действие. Попробуйте снова.");
        }
    }

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

        while (true) {
            displayMenu(); // Вызов метода для вывода меню
            int action = Integer.parseInt(scanner.nextLine()); // Преобразование строки в целое число
            handleAction(action, scanner, fileName); // Вызов метода для обработки ввода
        }
    }
}
