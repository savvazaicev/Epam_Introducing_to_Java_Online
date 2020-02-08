package com.company;

import java.util.Arrays;

//Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов,
//вычисления площади, периметра и точки пересечения медиан.
public class Main {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(0, 0, 8, 2, -2, 6);
        System.out.println("Площадь треугольника: ");
        System.out.println(triangle.square());
        System.out.println("Периметр треугольника: ");
        System.out.println(triangle.perimeter());
        System.out.println("Точка пересечения медиан: ");
        System.out.println(Arrays.toString(triangle.medianCrossingPoints()));
    }
}
