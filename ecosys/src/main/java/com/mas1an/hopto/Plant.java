package com.mas1an.hopto;

public class Plant {
    private String name; // Имя растения
    private int amount; // Колличество растений

    // конструктор
    public Plant(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Plant{name='" + name + "', amount=" + amount + "}";
    }

}
