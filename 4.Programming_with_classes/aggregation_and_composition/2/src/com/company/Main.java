package com.company;

//Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
//Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
public class Main {

    public static void main(String[] args) {
        Wheel wheel1 = new Wheel(40);
        Wheel wheel2 = new Wheel(30);
        Wheel wheel3 = new Wheel(50);
        Car lamborgini = new Car("Lamborgini", 100, wheel1);
        Car porshe = new Car("Porshe", 50, wheel2);
        lamborgini.drive();
        porshe.refuel();
        System.out.println("Диаметр колеса " + lamborgini.getModel() + ": " + lamborgini.getWheel().getDiameter());
        lamborgini.changeWheel(wheel3);
        lamborgini.modelOutput();
    }
}
