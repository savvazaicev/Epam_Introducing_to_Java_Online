package com.company;

import java.util.ArrayList;

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

    public String getName() {
        return name;
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

    public int getCountOfPages() {
        return countOfPages;
    }

    public int getPrice() {
        return price;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
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

class Books {
    private ArrayList<Book> books;

    public Books(ArrayList<Book> books) {
        this.books = books;
    }

    public void output(ArrayList<Book> books) {
        for (Book i : books) {
            i.output();
        }
    }

    public ArrayList<Book> listByAuthor(String author) {
        ArrayList<Book> sortedBooks = new ArrayList<>();
        for (Book i :
                books) {
            if (i.getAuthors().indexOf(author) != -1) {
                i.output();
            }
        }
        return sortedBooks;
    }

    public ArrayList<Book> listByPublisher(String publisher) {
        ArrayList<Book> sortedBooks = new ArrayList<>();
        for (Book i :
                books) {
            if (i.getPublisher().equals(publisher)) {
                i.output();
            }
        }
        return sortedBooks;
    }

    public ArrayList<Book> listByYear(int fromYear) {
        ArrayList<Book> sortedBooks = new ArrayList<>();
        for (Book i :
                books) {
            if (i.getYearOfPublishing() >= fromYear) {
                i.output();
            }
        }
        return sortedBooks;
    }

    public int size() {
        return this.books.size();
    }

    public Book get(int i) {
        return this.books.get(i);
    }
}