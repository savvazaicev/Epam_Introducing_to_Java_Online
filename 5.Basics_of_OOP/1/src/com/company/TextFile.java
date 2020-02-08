package com.company;

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

