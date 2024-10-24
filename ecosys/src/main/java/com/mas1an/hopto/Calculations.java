package com.mas1an.hopto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculations {

    // Метод для расчета оставшейся еды для животных
    public static void animalFoodDivision(List<String> objects, String fileName) {
        Map<String, Integer> plantAmounts = new HashMap<>();

        // Сбор данных о растениях и их количестве
        for (String obj : objects) {
            if (obj.startsWith("Plant")) {
                String name = obj.split(",")[0].split("=")[1].replace("'", "").trim();
                int amount = Integer.parseInt(obj.split(",")[1].split("=")[1].replace("}", "").trim());
                plantAmounts.put(name, amount);
            }
        }

        List<String> results = new ArrayList<>();

        // Проход по всем животным и расчет оставшейся еды
        for (String obj : objects) {
            if (obj.startsWith("Animal")) {
                String[] parts = obj.split(","); // Разделение строки на части по запятой
                String name = parts[0].split("=")[1].replace("'", "").trim(); // Извлечение имени животного
                int amount = Integer.parseInt(parts[1].split("=")[1].trim()); // Извлечение количества животного
                String food = parts[2].split("=")[1].replace("'", "").replace("}", "").trim(); // Извлечение типа пищи
                if (plantAmounts.containsKey(food)) {
                    int plantAmount = plantAmounts.get(food); // Получение количества пищи
                    int days = plantAmount / amount; // Расчет количества дней оставшейся пищи
                    String result = "Для животного " + name + " еды осталось на " + days + " дней";
                    results.add(result); // Добавление результата в список
                    System.out.println(result); // Вывод результата
                }
            }
        }

        // Запись результатов в файл simulation.txt
        String directoryName = "simulations/" + fileName;
        File file = new File(directoryName, "simulation.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (String result : results) {
                writer.write(result);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для подсчета общей суммы amount для Animal
    public static int sumAnimalAmounts(List<String> objects) {
        int totalAmount = 0;
        for (String obj : objects) {
            if (obj.startsWith("Animal")) {
                String amountStr = obj.split(",")[1].split("=")[1].replace("}", "").trim();
                totalAmount += Integer.parseInt(amountStr);
            }
        }
        return totalAmount;
    }
}
