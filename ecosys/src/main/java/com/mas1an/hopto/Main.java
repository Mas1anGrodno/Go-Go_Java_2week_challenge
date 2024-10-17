package com.mas1an.hopto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Привет ! Введите имя файла для сохранения данных:");
        String fileName = scanner.nextLine();

        // Ввод растений
        ObjectManager.addPlants(scanner, fileName);

        // Ввод животных
        ObjectManager.addAnimals(scanner, fileName);

        // Ввод ресурса
        ObjectManager.addResource(scanner, fileName);

        // Вывод созданных объектов
        System.out.println("Созданные объекты:");
        CRUDOperations.readObjects(fileName + "_plants.txt").forEach(System.out::println);
        CRUDOperations.readObjects(fileName + "_animals.txt").forEach(System.out::println);
        CRUDOperations.readObjects(fileName + "_animals.txt").forEach(System.out::println);
        scanner.close();
    }
}
