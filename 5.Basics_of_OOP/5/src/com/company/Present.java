package com.company;

//Создать консольное приложение, удовлетворяющее следующим требованиям:
//• Корректно спроектируйте и реализуйте предметную область задачи.
//• Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов
//проектирования.(прочитал, не придумал применение).
//• Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
//• для проверки корректности переданных данных можно применить регулярные выражения.
//• Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
//• Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Вариант B. Подарки. Реализовать приложение, позволяющее создавать подарки (объект, представляющий собой
//подарок). Составляющими целого подарка являются сладости и упаковка.
public class Present {
    Box box;
    Sweets sweets;
    int id;

    Present(String typeOfMaterial, Sweets sweets, int id) {
        this.box = new Box(typeOfMaterial);
        this.sweets = sweets;
        setId(id);
    }

    @Override
    public String toString() {
        return "Подарок №" + id + "\n" + box.boxToString() + "\n" + sweets.sweetsToString();
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("Ошибка! Id должен быть больше 0.");
        }
    }
}

class Box {
    private String typeOfMaterial;

    Box(String typeOfMaterial) {
        setTypeOfMaterial(typeOfMaterial);
    }

    String boxToString() {
        return "Тип упаковки: " + typeOfMaterial;
    }

    public void setTypeOfMaterial(String typeOfMaterial) {
        if (typeOfMaterial.matches("^[а-яА-Я]+$")) {
            this.typeOfMaterial = typeOfMaterial;
        } else {
            System.out.println("Ошибка! Тип упаковки должен состоять только из русских букв без пробелов.");
        }
    }
}

class Sweets {
    private String name;

    Sweets(String name) {
        setName(name);
    }

    String sweetsToString() {
        return "Сладости: " + name;
    }

    public void setName(String name) {
        if (name.matches("^[а-яА-Я]+$")) {
            this.name = name;
        } else {
            System.out.println("Ошибка! Название сладостей должны состоять только из русских букв без пробелов.");
        }
    }
}
