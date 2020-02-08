package com.company;

import java.util.ArrayList;

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
            if (i.getAuthors().contains(author)) {
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