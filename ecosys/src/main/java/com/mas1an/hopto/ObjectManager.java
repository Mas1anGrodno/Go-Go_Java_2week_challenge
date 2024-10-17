package com.mas1an.hopto;

import java.util.Scanner;

public class ObjectManager {

    // функция добавления растений
    public static void addPlants(Scanner scanner, String fileName) {
        while (true) {
            // Запрос имени для объекта Plant
            System.out.print("Введите название растения: ");
            String plantName = scanner.nextLine();
            // Запрос количества для объекта Plant
            System.out.print("Введите количество растений: ");
            int plantAmount = scanner.nextInt();
            // Очистка буфера после ввода числа
            scanner.nextLine();
            // Создаем объект Plant
            Plant plant = new Plant(plantName, plantAmount);
            CRUDOperations.createObject(plant, fileName);

            System.out.print("Хотите ввести еще одно растение? (Y/N): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    // функция добавления животных
    public static void addAnimals(Scanner scanner, String fileName) {
        while (true) {
            // Запрос имени для объекта Animal
            System.out.print("Введите название животного: ");
            String animalName = scanner.nextLine();
            // Запрос количества для объекта Animal
            System.out.print("Введите количество животных: ");
            int animalAmount = scanner.nextInt();
            // Очистка буфера после ввода числа
            scanner.nextLine();
            // Создаем объект Animal
            Animal animal = new Animal(animalName, animalAmount);
            CRUDOperations.createObject(animal, fileName);

            System.out.print("Хотите ввести еще одно животное? (Y/N): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    // функция добавления ресурсов
    public static void addResource(Scanner scanner, String fileName) {
        while (true) {
            // Запрос имени для объекта Resource
            System.out.print("Введите название расурса: ");
            String resourcetName = scanner.nextLine();
            // Запрос количества для объекта Resource
            System.out.print("Введите количество ресурса: ");
            int resourceAmount = scanner.nextInt();
            // Очистка буфера после ввода числа
            scanner.nextLine();
            // Создаем обьект Resource
            Resource resource = new Resource(resourcetName, resourceAmount);
            CRUDOperations.createObject(resource, fileName);

            System.out.print("Хотите ввести еще один вид ресурса? (Y/N): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("N")) {
                break;
            }
        }
    }
}
