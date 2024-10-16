package com.mas1an.hopto;

public class Resource {
    private String name; // Название ресурса
    private int amount; // Колличество ресурса

    // конструктор
    public Resource(String name, int amount) {
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
        return "Resource{name='" + name + "', amount=" + amount + "}";
    }

}
