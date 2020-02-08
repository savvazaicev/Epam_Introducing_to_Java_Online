package com.company;

class Wheel {
    private int diameter;

    Wheel(int diameter) {
        if (diameter > 0) {
            this.diameter = diameter;
        } else {
            System.out.println("Ошибка! Диаметр колеса не может быть меньше или равен 0.");
        }
    }

    int getDiameter() {
        return diameter;
    }
}
