package com.mas1an.hopto;

public class Ecosys {
    private int temperature; // Температура системы
    private int water; // количество воды
    private int grow; // фактор роста (+1 в день по умолчанию)
    // конструктор

    public Ecosys(int temperature, int water, int grow) {
        this.temperature = temperature;
        this.water = water;
        this.grow = grow;
    }

    @Override
    public String toString() {
        return "Ecosystem{temperature='" + temperature + "', water=" + water + ", growth='" + grow + "'}";
    }

}