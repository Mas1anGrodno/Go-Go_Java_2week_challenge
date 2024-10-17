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

    public static void updateObject(String oldObject, String newObject, String fileName) {
        List<String> objects = readObjects(fileName);
        String directoryName = "simulations/" + fileName;
        File file = new File(directoryName, fileName + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String obj : objects) {
                if (obj.equals(oldObject)) {
                    writer.write(newObject);
                } else {
                    writer.write(obj);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteObject(String objectToDelete, String fileName) {
        List<String> objects = readObjects(fileName);
        String directoryName = "simulations/" + fileName;
        File file = new File(directoryName, fileName + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String obj : objects) {
                if (!obj.equals(objectToDelete)) {
                    writer.write(obj);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
