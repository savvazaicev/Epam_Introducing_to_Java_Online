package com.company;

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
