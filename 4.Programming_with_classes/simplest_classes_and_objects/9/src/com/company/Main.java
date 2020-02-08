package com.company;

import java.util.ArrayList;
import java.util.Arrays;

//Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
//метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
//Найти и вывести:
//a) список книг заданного автора;
//b) список книг, выпущенных заданным издательством;
//c) список книг, выпущенных после заданного года.
public class Main {

    public static void main(String[] args) {
        Book book1 = new Book(1,"Abcde","Abcde","Abcde",1999,10,10,"a");
        Book book2 = new Book(2,"Bcdef","Bcdef","Bcdef",2000,10,10,"b");
        Book book3 = new Book(3,"Cdefg","Cdefg, Abcde","Cdefg",2001,10,10,"a");
        Book book4 = new Book(4,"Defgh","Defgh","Defgh",2002,10,10,"b");
        Book book5 = new Book(5,"Efghi","Efghi","Efghi",1988,10,10,"a");
        ArrayList<Book> booksArrayList = new ArrayList<>(Arrays.asList(book1,book2,book3,book4,book5));
        Books books = new Books(booksArrayList);
        System.out.println("Список книг заданного автора: ");
        books.output(books.listByAuthor("Abcde"));
        System.out.println('\n' + "Список книг, выпущенных заданным издательством: ");
        books.output(books.listByPublisher("Bcdef"));
        System.out.println('\n' + "Список книг, выпущенных после заданного года: ");
        books.output(books.listByYear(2000));
        System.out.println('\n' + "Данные по заданным критериям: ");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() > 2 && books.get(i).getId() < 5) {
                System.out.println(books.get(i).toString());
            }
        }
    }
}
