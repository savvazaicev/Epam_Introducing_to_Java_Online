package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Singleton with Double Checked Locking & volatile
public class Library {
    private static volatile Library instance;
    private final ArrayList<Book> books = new ArrayList<>();

    public static Library getInstance() {
        Library localInstance = instance;
        if (localInstance == null) {
            synchronized (Library.class) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = new Library();
                    instance = localInstance;
                    //Где правильнее вызвать этот метод?
                    instance.readBooksData();
                }
            }
        }
        return localInstance;
    }

    public void browse() {
        System.out.println("Название книги, тип:");
        for (Book i : books) {
            String type = i.isElectronic() ? "электронная" : "бумажная";
            System.out.println(i.getName() + ", " + type);
        }
    }

    public void searchBook() {
        System.out.println("\nВведите название книги: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        boolean bookIsFound = false;
        for (Book i : books) {
            if (i.getName().equals(name)) {
                String type = i.isElectronic() ? "электронная" : "бумажная";
                System.out.println(i.getName() + ", " + type);
                bookIsFound = true;
            }
        }
        if (!bookIsFound) {
            System.out.println("Книга не найдена!");
        }
    }

    public void addBook() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите имя книги: ");
        String name = in.nextLine();
        if (name.contains(" ")) {
            name = name.replaceAll(" ", "_");
        }
        System.out.println("\nВыберите тип книги: \n1.Электронная\n2.Бумажная");
        int type = in.nextInt();
        if (type == 1 || type == 2) {
            boolean isElectronic = (type == 1);
            books.add(new Book(name, isElectronic));
            saveData();
        } else {
            System.out.println("Ошибка! Выход за диапазон значений.");
        }
    }

    public void deleteBook() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите имя книги: ");
        String name = in.nextLine();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getName().equals(name)) {
                books.remove(book);
                System.out.println("Книга успешно удалена");
            }
        }
        saveData();
    }

    private void readBooksData() {
        try {
            FileReader fr = new FileReader("books.txt");
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String name = str.substring(0, str.indexOf(" "));
                boolean isElectronic = Boolean.parseBoolean(str.substring(str.indexOf(" ") + 1));
                books.add(new Book(name, isElectronic));
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveData() {
        File inputFile = new File("books.txt");
        File tempFile = new File("booksTemp.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter("booksTemp.txt");
            for (Book i : books) {
                fw.write(i.getName() + " " + i.isElectronic() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inputFile.delete()) {
            if (tempFile.renameTo(inputFile)) {
                System.out.println("\nФайл " + inputFile.getName() + " успешно обновлён");
            }
        }
    }

    static class Book {
        private String name;
        private boolean isElectronic;

        public Book(String name, boolean isElectronic) {
            this.name = name;
            this.isElectronic = isElectronic;
        }

        public String getName() {
            return name;
        }

        public boolean isElectronic() {
            return isElectronic;
        }
    }
}