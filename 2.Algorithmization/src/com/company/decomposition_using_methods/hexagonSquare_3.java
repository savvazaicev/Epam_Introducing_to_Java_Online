package com.company.decomposition_using_methods;

//Вычислить площадь правильного шестиугольника со стороной а,
//используя метод вычисления площади v треугольника.
class hexagonSquare_3 {
    public static void main(String[] args) {
        int a = 3;
        double square = hexagonSquare(a);
        System.out.println("Площадь шестиугольника: " + square);
    }

    public static double hexagonSquare(int side) {
        return Math.sqrt(3) * 3 / 2 * side * side;
    }
}