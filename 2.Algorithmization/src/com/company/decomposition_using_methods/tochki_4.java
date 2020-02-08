package com.company.decomposition_using_methods;

//На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие,
//между какими из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
class tochki_4 {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 1}, {3, 4}, {5, 1}, {4, 2}, {3, 2}};
        System.out.println("Минимальное расстояние между двумя точками: " + minDistance(points));
    }

    public static double minDistance(int[][] points) {
        double minDistance = 2147483647;
        for (int i = 0; i < points.length; i++) {
            for (int j = 1 + i; j < points.length; j++) {
                double distance = Math.sqrt(Math.pow(Math.abs(points[i][0] - points[j][0]), 2) +
                        Math.pow(Math.abs(points[i][1] - points[j][1]), 2));
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }
}