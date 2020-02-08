package com.company;

//Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
//на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
//произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
//позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
public class DemicalCounter {
    private int count = 0;
    private int rangeFrom = -2147483648;
    private int rangeTo = 2147483647;

    DemicalCounter() {
    }

    DemicalCounter(int count) {
        this.count = count;
    }

    DemicalCounter(int count, int rangeFrom) {
        this.count = count;
        this.rangeFrom = rangeFrom;
    }

    DemicalCounter(int count, int rangeFrom, int rangeTo) {
        this.count = count;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
    }

    public void increment() {
        if (this.count < rangeTo) {
            this.count++;
        } else {
            System.out.println("Error! Value out of range.");
        }
    }

    public void decrement() {
        if (this.count > rangeFrom) {
            this.count--;
        } else {
            System.out.println("Error! Value out of range.");
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count >= rangeFrom && count <= rangeTo) {
            this.count = count;
        } else {
            System.out.println("Error! Value out of range.");
        }
    }

    public int getRangeFrom() {
        return rangeFrom;
    }

    public int getRangeTo() {
        return rangeTo;
    }
}