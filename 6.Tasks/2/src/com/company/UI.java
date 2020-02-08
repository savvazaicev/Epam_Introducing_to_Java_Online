package com.company;

import java.text.ParseException;
import java.util.Scanner;

public class UI {

    private Notebook notebook;

    public UI(Notebook notebook) {
        this.notebook = notebook;
    }

    public void menu() {
        System.out.println("Введите номер операции:" +
                "\n1.Найти запись по параметру" +
                "\n2.Найти запись по группе параметров" +
                "\n3.Найти записи, тектовое поле которых содержит определённое слово" +
                "\n4.Добавить новую запись");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        String inputString;
        switch (input) {
            case 1:
                System.out.println("\n1.По теме" +
                        "\n2.По дате добавления" +
                        "\n3.По e-mail");
                input = in.nextInt();
                switch (input) {
                    case 1:
                        System.out.println("Введите название заметки: ");
                        inputString = in.next();
                        notebook.searchByTopic(inputString);
                        break;
                    case 2:
                        System.out.println("Введите дату создания заметки");
                        inputString = in.next();
                        notebook.searchByDate(inputString);
                        break;
                    case 3:
                        System.out.println("Введите почту, связанную с заметкой");
                        inputString = in.next();
                        notebook.searchByEmail(inputString);
                        break;
                    default:
                        System.out.println("Ошибка! Выход за диапазон значений.");
                }
                break;
            case 2:
                System.out.println("Введите название и дату создания заметки: ");
                inputString = in.next();
                String dateString = in.next();
                notebook.search(inputString, dateString);
                break;
            case 3:
                System.out.println("Введите слово, которое есть в тексте заметки: ");
                inputString = in.next();
                notebook.searchByContent(inputString);
                break;
            case 4:
                try {
                    notebook.add();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Ошибка! Выход за диапазон значений.");
        }
    }
}