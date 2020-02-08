package com.company;

//Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами.
//Добавьте конструктор, инициализирующий члены класса по умолчанию.
//Добавьте set- и get- методы для полей экземпляра класса.
public class Main {

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println(test2.getVar1());
        System.out.println(test2.getVar2());
        test2.setVar1(1);
        test2.setVar2(2);
        System.out.println(test2.getVar1());
        System.out.println(test2.getVar2());
    }
}
