package com.company;

//Создать объект класса Текстовый файл, используя классы Файл, Директория.
//Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
public class Main {

    public static void main(String[] args) {
        TextFiles textFiles = new TextFiles();
        //создать
        textFiles.create("имя","содержимое","TextFiles");
        textFiles.create("имя_2","содержимое_2","TextFiles_2");
        //удалить
        textFiles.delete(1);
        //переименовать
        textFiles.getTextFile(0).rename("новое имя");
        System.out.println(textFiles.getTextFile(0).getName());
        //вывести на консоль содержимое
        textFiles.getTextFile(0).output();
        //дополнить
        textFiles.getTextFile(0).add(" + дополнение");
        textFiles.getTextFile(0).output();
    }
}
