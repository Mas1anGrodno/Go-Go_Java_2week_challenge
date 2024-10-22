package com.mas1an.hopto;

public class Animal {
    private String name; // Имя животного
    private int amount; // Колличество животных
    private String food; // Чем питается
    // конструктор

    public Animal(String name, int amount, String food) {
        this.name = name;
        this.amount = amount;
        this.food = food;
    }

    @Override
    public String toString() {
        return "Animal{name='" + name + "', amount=" + amount + ", food='" + food + "'}";
    }

}