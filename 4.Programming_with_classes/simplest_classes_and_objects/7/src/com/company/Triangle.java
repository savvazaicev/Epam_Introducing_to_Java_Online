package com.company;

import static java.lang.Math.*;

//Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов,
//вычисления площади, периметра и точки пересечения медиан.
public class Triangle {
    private double pointX1 = 0;
    private double pointY1 = 0;
    private double pointX2 = 0;
    private double pointY2 = 0;
    private double pointX3 = 0;
    private double pointY3 = 0;

    public Triangle(double pointX1, double pointY1, double pointX2, double pointY2, double pointX3, double pointY3) {
        this.pointX1 = pointX1;
        this.pointY1 = pointY1;
        this.pointX2 = pointX2;
        this.pointY2 = pointY2;
        this.pointX3 = pointX3;
        this.pointY3 = pointY3;
    }

    public double square() {
        return 0.5* abs((pointX1 - pointX3)*(pointY2-pointY3)-(pointX2-pointX3)*(pointY1-pointY3));
    }

    public double perimeter() {
        double AB = sqrt(pow(pointX2-pointX1,2)+pow(pointY2-pointY1,2));
        double AC = sqrt(pow(pointX3-pointX1,2)+pow(pointY3-pointY1,2));
        double BC = sqrt(pow(pointX3-pointX2,2)+pow(pointY3-pointY2,2));
        return AB+BC+AC;
    }

    public double[] medianCrossingPoints() {
        double X = (pointX1+pointX2+pointX3)/3;
        double Y = (pointY1+pointY2+pointY3)/3;
        return new double[]{X,Y};
    }
}