package com.company;

//Создать консольное приложение, удовлетворяющее следующим требованиям:
//• Приложение должно быть объектно-, а не процедурно-ориентированным.
//• Каждый класс должен иметь отражающее смысл название и информативный состав.
//• Наследование должно применяться только тогда, когда это имеет смысл.
//• При кодировании должны быть использованы соглашения об оформлении кода java code convention.
//• Классы должны быть грамотно разложены по пакетам.
//• Консольное меню должно быть минимальным.
//• Для хранения данных можно использовать файлы.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
//дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и
//выбора сокровищ на заданную сумму.
public class Treasures {
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Integer> costs = new ArrayList<>();

    public void add(String name, int cost) {
        this.names.add(name);
        this.costs.add(cost);
    }

    public void remove(int index) {
        this.names.remove(index);
        this.costs.remove(index);
    }

    public void outputAll() {
        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + "." + getName(i) + ", цена: " + getCost(i) + "$");
        }
    }

    public int buyMostExpensive() {
        int max = 0;
        int maxCostIndex = 0;
        for (int i = 1; i < names.size(); i++) {
            if (getCost(i) >= max){
                max = getCost(i);
                maxCostIndex = i;
            }
        }
        return maxCostIndex;
    }

    public int buy(int index) {
        return getCost(index);
    }

    public String getName(int index) {
        return this.names.get(index);
    }

    public int getCost(int index) {
        return this.costs.get(index);
    }
}
