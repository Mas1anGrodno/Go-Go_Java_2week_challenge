package com.mas1an.hopto;

public class Animal {
    private String name; // Имя животного
    private int amount; // Колличество животных

    // конструктор
    public Animal(String name, int amount) {
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
        return "Animal{name='" + name + "', amount=" + amount + "}";
    }

}