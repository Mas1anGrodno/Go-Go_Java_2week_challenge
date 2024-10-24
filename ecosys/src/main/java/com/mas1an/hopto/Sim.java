package com.mas1an.hopto;

import java.util.Scanner;

public class Sim {

    // Метод для запуска симуляции
    public static void startSimulation(Scanner scanner, String fileName) {
        // Запрос параметров у пользователя
        System.out.print("Введите температуру системы: ");
        int temperature = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите количество воды: ");
        int water = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите фактор роста (по умолчанию 1): ");
        String growInput = scanner.nextLine();
        int grow = growInput.isEmpty() ? 1 : Integer.parseInt(growInput);

        // Создание объекта Ecosys
        Ecosys ecosystem = new Ecosys(temperature, water, grow);

        // Запись объекта в файл
        CRUDOperations.createEcosysObject(ecosystem, fileName);

        System.out.println("Симуляция запущена с параметрами: " + ecosystem);

        // Выполнение расчетов после создания объекта
        while (true) {
            displayCalculationMenu(); // Вызов метода для вывода меню расчетов
            int action = Integer.parseInt(scanner.nextLine());
            handleCalculationAction(action, fileName); // Вызов метода для обработки выбора расчета
        }
    }

    // Метод для вывода меню расчетов
    private static void displayCalculationMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1) Сумма amount для Animal");
        System.out.println("2) Остатки еды для животных");
        System.out.println("3) Выйти");
    }

    // Метод для обработки выбора расчета
    private static void handleCalculationAction(int action, String fileName) {
        switch (action) {
            case 1:
                System.out.println("Сумма amount для Animal");
                int totalAnimalAmount = Calculations.sumAnimalAmounts(CRUDOperations.readObjects(fileName));
                System.out.println("Сумма всех amount для Animal: " + totalAnimalAmount);
                break;
            case 2:
                System.out.println("Остатки еды для животных");
                Calculations.animalFoodDivision(CRUDOperations.readObjects(fileName), fileName);
                break;
            case 3:
                System.out.println("Выход из расчетов");
                System.exit(0);
            default:
                System.out.println("Неизвестное действие. Попробуйте снова.");
        }
    }
}
