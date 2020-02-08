package com.company;

//Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
//изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
//недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
//заданное количество часов, минут и секунд.
public class Main {

    public static void main(String[] args) {
        Time time = new Time(13, 37, 0);
        System.out.println("Пытаемся выйти за диапазон допустимых значений: " + '\n');
        Time time1 = new Time(24);
        time1.output();
        Time time2 = new Time(23, 60);
        time2.output();
        Time time3 = new Time(23, 59, 60);
        time3.output();
        time.setSeconds(60);
        time.setSeconds(-1);
        System.out.println();
        System.out.println("Выведем заданное время: ");
        time.output();
        System.out.println("Установим время на полдень: ");
        time.changeTime(12, 0);
        time.output();
        System.out.println("Изменим время на 23:59:59");
        time.changeTime(23, 59, 59);
        time.output();
    }
}