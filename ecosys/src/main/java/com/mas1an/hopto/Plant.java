package com.mas1an.hopto;

public class Plant {
    private String name; // Имя растения
    private int amount; // Колличество растений

    // конструктор
    public Plant(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    // геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Plant{name='" + name + "', amount=" + amount + "}";
    }

}
