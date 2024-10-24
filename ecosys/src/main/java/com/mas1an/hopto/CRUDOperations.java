package com.mas1an.hopto;

import java.io.*;
import java.util.*;

public class CRUDOperations {

    // Метод для создания объекта экосистемы и записи его в файл
    public static void createEcosysObject(Ecosys ecosys, String fileName) {
        File file = createDirectoryAndFile(fileName, "simulation.txt");
        writeFile(file, ecosys.toString());
    }

    // Метод для создания объекта и записи его в файл
    public static void createObject(Object obj, String fileName) {
        File file = createDirectoryAndFile(fileName, fileName + ".txt");
        writeFile(file, obj.toString());
    }

    // Метод для чтения объектов из файла
    public static List<String> readObjects(String fileName) {
        String directoryName = "simulations/" + fileName;
        File file = new File(directoryName, fileName + ".txt");
        return readFile(file);
    }

    // Метод для обновления объекта в файле по ключевому слову
    public static void updateObject(String keyword, String newAmount, String fileName) {
        List<String> objects = readObjects(fileName);
        String directoryName = "simulations/" + fileName;
        File file = new File(directoryName, fileName + ".txt");

        // Поиск строки, содержащей ключевое слово
        String selectedObject = null;
        for (String obj : objects) {
            if (obj.contains(keyword)) {
                selectedObject = obj;
                break; // Предполагаем, что строки уникальны, выходим после нахождения первого
                       // совпадения
            }
        }

        if (selectedObject == null) {
            System.out.println("Совпадений не найдено.");
            return;
        }

        // Замена значения amount
        String updatedObject = selectedObject.replaceAll("amount=\\d+", "amount=" + newAmount);

        // Запись обновленных данных в файл
        writeFile(file, objects, updatedObject, selectedObject);
    }

    // Метод для удаления объекта из файла по ключевому слову
    public static void deleteObject(String keyword, String fileName) {
        List<String> objects = readObjects(fileName);
        String directoryName = "simulations/" + fileName;
        File file = new File(directoryName, fileName + ".txt");

        // Поиск строки, содержащей ключевое слово
        String selectedObject = null;
        for (String obj : objects) {
            if (obj.contains(keyword)) {
                selectedObject = obj;
                break; // Предполагаем, что строки уникальны, выходим после нахождения первого
                       // совпадения
            }
        }

        if (selectedObject == null) {
            System.out.println("Совпадений не найдено.");
            return;
        }

        // Запись обновленных данных в файл без удаленного объекта
        writeFile(file, objects, null, selectedObject);
    }

    // Метод для создания каталога и файла
    private static File createDirectoryAndFile(String directoryName, String fileName) {
        File directory = new File("simulations/" + directoryName);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        return new File(directory, fileName);
    }

    // Метод для записи данных в файл
    private static void writeFile(File file, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для записи обновленных данных в файл
    private static void writeFile(File file, List<String> objects, String updatedObject, String selectedObject) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String obj : objects) {
                if (updatedObject != null && obj.equals(selectedObject)) {
                    writer.write(updatedObject);
                } else if (!obj.equals(selectedObject)) {
                    writer.write(obj);
                }
                writer.newLine();
            }
            System.out.println(updatedObject == null ? "Удаление завершено." : "Обновление завершено.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения данных из файла
    private static List<String> readFile(File file) {
        List<String> objects = new ArrayList<>();
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
}
