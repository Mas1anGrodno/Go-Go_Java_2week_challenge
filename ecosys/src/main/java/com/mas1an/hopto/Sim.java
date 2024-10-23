package com.mas1an.hopto;

import java.util.Scanner;

public class Sim {
    public static void startSimulation(Scanner scanner, String fileName) {
        // Запрос параметров у пользователя
        System.out.print("Введите температуру системы: ");
        int temperature = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите количество воды: ");
        int water = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите фактор роста (по умолчанию 1): ");
        String growInput = scanner.nextLine();
        int grow = growInput.isEmpty() ? 1 : Integer.parseInt(growInput);

        // Создание объекта Ecosys
        Ecosys ecosystem = new Ecosys(temperature, water, grow);

        // Запись объекта в файл
        CRUDOperations.createEcosysObject(ecosystem, fileName);

        System.out.println("Симуляция запущена с параметрами: " + ecosystem);
    }
}
