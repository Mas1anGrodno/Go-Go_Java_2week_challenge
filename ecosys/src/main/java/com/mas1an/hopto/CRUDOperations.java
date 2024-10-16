package com.mas1an.hopto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDOperations {
    private static final String FILE_PATH = "objects.txt";

    public static void createObject(Object obj) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(obj.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readObjects() {
        List<String> objects = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                objects.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objects;
    }

    public static void updateObject(String oldObject, String newObject) {
        List<String> objects = readObjects();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
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

    public static void deleteObject(String objectToDelete) {
        List<String> objects = readObjects();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
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
