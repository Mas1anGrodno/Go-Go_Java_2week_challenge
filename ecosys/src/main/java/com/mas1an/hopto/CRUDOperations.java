package com.mas1an.hopto;

import java.io.*;
import java.util.*;

public class CRUDOperations {
    public static void createObject(Object obj, String fileName) {
        String directoryName = "simulations/" + fileName;
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(directory, fileName + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(obj.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readObjects(String fileName) {
        List<String> objects = new ArrayList<>();
        String directoryName = "simulations/" + fileName;
        File file = new File(directoryName, fileName + ".txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                objects.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objects;
    }

    public static void updateObject(String keyword, String newAmount, String fileName) {
        List<String> objects = readObjects(fileName);
        String directoryName = "simulations/" + fileName;
        File file = new File(directoryName, fileName + ".txt");

        List<String> matchingObjects = new ArrayList<>();
        for (String obj : objects) {
            if (obj.contains(keyword)) {
                matchingObjects.add(obj);
            }
        }

        if (matchingObjects.isEmpty()) {
            System.out.println("Совпадений не найдено.");
            return;
        }

        System.out.println("Выберите строку для обновления:");
        for (int i = 0; i < matchingObjects.size(); i++) {
            System.out.println((i + 1) + ") " + matchingObjects.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice > 0 && choice <= matchingObjects.size()) {
            String selectedObject = matchingObjects.get(choice - 1);
            String updatedObject = selectedObject.replaceAll("amount=\\d+", "amount=" + newAmount);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String obj : objects) {
                    if (obj.equals(selectedObject)) {
                        writer.write(updatedObject);
                    } else {
                        writer.write(obj);
                    }
                    writer.newLine();
                }
                System.out.println("Обновление завершено.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Неверный выбор.");
        }
    }

    public static void deleteObject(String keyword, String fileName) {
        List<String> objects = readObjects(fileName);
        String directoryName = "simulations/" + fileName;
        File file = new File(directoryName, fileName + ".txt");

        List<String> matchingObjects = new ArrayList<>();
        for (String obj : objects) {
            if (obj.contains(keyword)) {
                matchingObjects.add(obj);
            }
        }

        if (matchingObjects.isEmpty()) {
            System.out.println("Совпадений не найдено.");
            return;
        }

        System.out.println("Выберите строку для удаления:");
        for (int i = 0; i < matchingObjects.size(); i++) {
            System.out.println((i + 1) + ") " + matchingObjects.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice > 0 && choice <= matchingObjects.size()) {
            String objectToDelete = matchingObjects.get(choice - 1);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String obj : objects) {
                    if (!obj.equals(objectToDelete)) {
                        writer.write(obj);
                        writer.newLine();
                    }
                }
                System.out.println("Удаление завершено.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Неверный выбор.");
        }
    }

}