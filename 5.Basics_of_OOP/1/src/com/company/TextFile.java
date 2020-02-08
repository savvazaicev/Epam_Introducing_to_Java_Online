package com.company;

import java.util.ArrayList;

//Создать объект класса Текстовый файл, используя классы Файл, Директория.
//Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
class TextFiles {
    private ArrayList<TextFile> textFiles = new ArrayList<>();
    private ArrayList<Directory> directories = new ArrayList<>();

    TextFiles() {
    }

    void create(String name, String content, String directoryName) {
        TextFile textFile = new TextFile(name,content);
        Directory directory = new Directory(directoryName);
        this.textFiles.add(textFile);
        this.directories.add(directory);
    }

    void delete(int index) {
        this.textFiles.remove(index);
        this.directories.remove(index);
    }

    TextFile getTextFile(int index) {
        return textFiles.get(index);
    }
}
class TextFile extends File {
    private String content;

    TextFile(String name, String content) {
        super(name);
        this.content = content;
    }

    @Override
    public void output() {
        System.out.println(this.content);
    }

    void add(String str) {
        this.content += str;
    }
}

class File {
    private String name;

    File(String name) {
        this.name = name;
    }

    void rename(String name) {
        this.name = name;
    }

    public void output() {
    }

    String getName() {
        return name;
    }
}

class Directory {
    private String name;

    Directory(String name) {
        this.name = name;
    }
}
