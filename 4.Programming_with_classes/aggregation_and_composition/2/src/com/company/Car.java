package com.company;

//Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
//Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
public class Car {
    private String model;
    private Engine engine;
    private Wheel wheel;

    Car(String model, int power, Wheel wheel) {
        this.model = model;
        this.engine = new Engine(power);
        this.wheel = wheel;
    }

    String getModel() {
        return model;
    }

    Wheel getWheel() {
        return wheel;
    }

    private void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    void drive() {
        System.out.println(getModel() + " едет");
    }

    void refuel() {
        System.out.println(getModel() + " заправляется");
    }

    void changeWheel(Wheel wheel) {
        System.out.println(getModel() + " Меняют колесо");
        setWheel(wheel);
        System.out.println("Диаметр нового колеса: " + getWheel().getDiameter());
    }

    void modelOutput() {
        System.out.println("Модель: " + getModel());
    }
}

class Wheel {
    private int diameter;

    Wheel(int diameter) {
        if (diameter > 0) {
            this.diameter = diameter;
        } else {
            System.out.println("Ошибка! Диаметр колеса не может быть меньше или равен 0.");
        }
    }

    int getDiameter() {
        return diameter;
    }
}

class Engine {
    private int power;

    Engine(int power) {
        this.power = power;
    }
}
