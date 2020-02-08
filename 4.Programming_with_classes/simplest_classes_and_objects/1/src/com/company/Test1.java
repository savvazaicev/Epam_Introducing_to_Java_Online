package com.company;

//Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
//переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
//наибольшее значение из этих двух переменных.
public class Test1 {
    private int var1;
    private int var2;

    public Test1(int var1) {
        this.var1 = var1;
    }

    public Test1(int var1, int var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public void output() {
        System.out.println(this.var1);
        System.out.println(this.var2);
    }

    public int sum() {
        return var1 + var2;
    }

    public int max() {
        return Math.max(var1, var2);
    }

    public int getVar1() {
        return var1;
    }

    public int getVar2() {
        return var2;
    }

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }
}
