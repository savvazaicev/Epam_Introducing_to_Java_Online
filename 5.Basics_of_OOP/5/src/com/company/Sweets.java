package com.company;

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