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

