package com.company;

//Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
//метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
//Найти и вывести:
//a) список книг заданного автора;
//b) список книг, выпущенных заданным издательством;
//c) список книг, выпущенных после заданного года.
public class Book {
    private int id;
    private String name;
    private String authors;
    private String publisher;
    private int yearOfPublishing;
    private int countOfPages;
    private int price;
    private String bindingType;

    public Book(int id, String name, String authors, String publisher, int yearOfPublishing,
                int countOfPages, int price, String bindingType) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.yearOfPublishing = yearOfPublishing;
        this.countOfPages = countOfPages;
        this.price = price;
        this.bindingType = bindingType;
    }

    public void output() {
        System.out.println(toString());
    }

    public int getId() {
        return id;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors='" + authors + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", countOfPages=" + countOfPages +
                ", price=" + price +
                ", bindingType='" + bindingType + '\'' +
                '}';
    }
}