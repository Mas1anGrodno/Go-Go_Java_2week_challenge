package com.mas1an.hopto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Привет !");

        // Ввод растений
        ObjectManager.addPlants(scanner);

        // Ввод животных
        ObjectManager.addAnimals(scanner);

        // Ввод ресурса
        ObjectManager.addResource(scanner);

        // Вывод созданных объектов
        System.out.println("Созданные объекты:");
        CRUDOperations.readObjects().forEach(System.out::println);

        scanner.close();
    }
}
