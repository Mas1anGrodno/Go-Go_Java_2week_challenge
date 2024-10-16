package com.mas1an.hopto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // цикл ввода растений
        while (true) {
            // Запрос имени для объекта Plant
            System.out.print("Введите имя для растения: ");
            String plantName = scanner.nextLine();
            // Запрос количества для объекта Plant
            System.out.print("Введите количество растений: ");
            int plantAmount = scanner.nextInt();
            // Очистка буфера после ввода числа
            scanner.nextLine();
            // Создаем обьект Plant
            Plant plant = new Plant(plantName, plantAmount);
            CRUDOperations.createObject(plant);

            System.out.print("Хотите ввести еще одно растение? (Y/N): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("N")) {
                break;
            }
        }

        while (true) {
            // Запрос имени для объекта Animal
            System.out.print("Введите имя для животного: ");
            String animalName = scanner.nextLine();
            // Запрос количества для объекта Plant
            System.out.print("Введите количество животных: ");
            int animalAmount = scanner.nextInt();
            // Очистка буфера после ввода числа
            scanner.nextLine();
            // Создаем обьект Animal
            Animal animal = new Animal(animalName, animalAmount);
            CRUDOperations.createObject(animal);
            System.out.print("Хотите ввести еще одно животное? (Y/N): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("N")) {
                break;
            }
        }

        // Вывод созданных объектов
        System.out.println("Созданные объекты:");
        CRUDOperations.readObjects().forEach(System.out::println);

        scanner.close();
    }
}
