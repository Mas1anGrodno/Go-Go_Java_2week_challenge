package com.mas1an.hopto;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class ObjectManager {

    public static boolean simulationExists(String fileName) {
        String directoryName = "simulations/" + fileName;
        File file = new File(directoryName, fileName);
        return file.exists();
    }

    public static String selectSimulation(Scanner scanner) {
        File directory = new File("simulations");
        String[] directories = directory.list((current, name) -> new File(current, name).isDirectory());
        if (directories != null && directories.length > 0) {
            System.out.println("Выберите существующую симуляцию:");
            for (int i = 0; i < directories.length; i++) {
                System.out.println((i + 1) + ") " + directories[i]);
            }
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice > 0 && choice <= directories.length) {
                return directories[choice - 1];
            } else {
                System.out.println("Неправильный выбор. Пожалуйста, попробуйте снова.");
                return selectSimulation(scanner);
            }
        } else {
            System.out.println("Нет сохраненных симуляций.");
            return null;
        }
    }

    public static void addEntity(Scanner scanner, String fileName) {
        System.out.println("Что вы хотите добавить?");
        System.out.println("1) Растение");
        System.out.println("2) Животное");
        System.out.println("3) Ресурс");
        int entityType = Integer.parseInt(scanner.nextLine()); // Преобразование строки в целое число

        switch (entityType) {
            case 1:
                System.out.print("Введите название растения: ");
                String plantName = scanner.nextLine();
                System.out.print("Введите количество растений: ");
                int plantAmount = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера
                CRUDOperations.createObject(new Plant(plantName, plantAmount), fileName);
                break;
            case 2:
                System.out.print("Введите название животного: ");
                String animalName = scanner.nextLine();
                System.out.print("Введите количество животных: ");
                int animalAmount = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера
                CRUDOperations.createObject(new Animal(animalName, animalAmount), fileName);
                break;
            case 3:
                System.out.print("Введите название ресурса: ");
                String resourceName = scanner.nextLine();
                System.out.print("Введите количество ресурса: ");
                int resourceAmount = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера
                CRUDOperations.createObject(new Resource(resourceName, resourceAmount), fileName);
                break;
            default:
                System.out.println("Неизвестный тип. Попробуйте снова.");
        }
    }

    public static void readEntities(String fileName) {
        List<String> entities = CRUDOperations.readObjects(fileName);
        for (String entity : entities) {
            System.out.println(entity);
        }
    }

    public static void updateEntity(Scanner scanner, String fileName) {
        System.out.print("Введите строку для обновления: ");
        String oldEntity = scanner.nextLine();
        System.out.print("Введите новую строку: ");
        String newEntity = scanner.nextLine();
        CRUDOperations.updateObject(oldEntity, newEntity, fileName);
    }

    public static void deleteEntity(Scanner scanner, String fileName) {
        System.out.print("Введите строку для удаления: ");
        String entityToDelete = scanner.nextLine();
        CRUDOperations.deleteObject(entityToDelete, fileName);
    }
}