package com.company.decomposition_using_methods;

//Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
//если угол между сторонами длиной X и Y— прямой.
public class task_9 {

    public static void main(String[] args) {
        int x = 5;
        int y = 4;
        int z = 4;
        int t = 3;
        //выпуклый четырехугольник
        boolean convex = true;
        double quadrangleArea = quadrangleArea(x, y, z, t, convex);
        if (quadrangleArea != 0) {
            System.out.println("Площадь четырехугольника: " + quadrangleArea);
        } else {
            System.out.println("Данные стороны не образуют четырехугольник");
        }
    }

    private static double quadrangleArea(int x, int y, int z, int t, boolean convex) {
        double triangleSquare = x * y / 2;
        double diagonal = Math.sqrt(y * y + x * x);
        //формула Герона
        double p = (z + t + diagonal) / 2;
        double secondTriangleSquare = 0;
        if (diagonal <= p) {
            secondTriangleSquare = Math.sqrt(p * (p - z) * (p - t) * (p - diagonal));
        } else {
            return 0;
        }
        if (convex) {
            return triangleSquare + secondTriangleSquare;
        } else {
            return triangleSquare - secondTriangleSquare;
        }
    }
}
