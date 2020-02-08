package com.company;

//Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
//на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
//произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
//позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
class Main {

    public static void main(String[] args) {
        DemicalCounter counter = new DemicalCounter(0, 0, 10);
        System.out.println("Пробуем выйти за нижний диапазон: ");
        counter.decrement();
        System.out.println("Увеличиваем счётчик до верхнего диапазона с помощью инкремента: ");
        for (int i = counter.getRangeFrom(); i < counter.getRangeTo(); i++) {
            counter.increment();
        }
        System.out.println(counter.getCount());
        System.out.println("Пробуем выйти за верхнийний диапазон: ");
        counter.increment();
    }
}